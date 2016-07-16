package ErasureCode_HDFS_Benchmark_Concurrent;

/**
 * Created by root on 16-2-17.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class ReadWriteFileCallable implements Callable<Long> {
  private static final String putBase = "hdfs dfs -put /root/zhangminglei/12GB_file.img";
  private static final String getBase = "hdfs dfs -get";
  private static final String ecDir = "/HDFS-7285-Policy/";
  private static final String localDir = "/tmp/";

  private final String cmd;
  private final String fileName;
  private static final int NumberFile = 20;
  private final boolean isRead;
  private final boolean isEc;
  static AtomicInteger it = new AtomicInteger();
  int id = it.getAndIncrement();

  public ReadWriteFileCallable(boolean read, boolean isEc, String coder) {
    fileName = UUID.randomUUID().toString();
    isRead = read;
    this.isEc = isEc;
    if (read) {
      String getDir = isEc ? ecDir : "/";
      String sourceFileName;
      if (isEc) {
        sourceFileName = "ec-" + (id % NumberFile) + ".img";
      } else {
        sourceFileName = "nonec-" + (id % NumberFile) + ".img";
      }
      cmd = getBase + " " + getDir + sourceFileName + " " + localDir + fileName;
    } else {
      cmd = putBase + " " + (isEc ? ecDir : "/") + "abc" + fileName;
    }
  }

  public void cleanUp() {
    if (isRead) {
      new File(localDir + fileName).delete();
    } else {
      String cleanUpCmd = "hadoop fs -rm " + (isEc ? ecDir : "/") + "abc" + fileName;
      try {
        Runtime.getRuntime().exec(cleanUpCmd).waitFor(); // Use waitFor is for time statistics
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

  public Long call() throws Exception {
    System.out.println("Concurrent process is  " + id);
    System.out.println("Running " + cmd);
    long start = System.currentTimeMillis();
    Process process = Runtime.getRuntime().exec(cmd); // execute a command in terminal
    if (process.waitFor() != 0) {
      // BufferedReader类读取的是字符,屏幕打印出来的东西都是字符信息，获取之后打印出来
      BufferedReader readerInputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
      BufferedReader readerErrStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
      String line = readerInputStream.readLine();
      while (line != null) {
        System.out.println(line);
        line = readerInputStream.readLine();
      }
      line = readerErrStream.readLine();
      while (line != null) {
        System.out.println(line);
        line = readerErrStream.readLine();
      }
      return -1L;
    } else {
      long end = System.currentTimeMillis();
      long time = end - start;
      return time;
    }
  }
}

public class RunBenchmarkToolServerTimes {
  public static void main(String[] args) throws Exception {
    int numClient = 1;
    boolean read = true;
    boolean ec = true;
    String coder = "raid";
    try {
      if (args.length != 0) {
        numClient = Integer.valueOf(args[0]);
        read = args[1].equalsIgnoreCase("read");
        ec = args[2].equalsIgnoreCase("ec");
        coder = args[3];
      }
    } catch (Exception e) {
      System.out.println("Wrong arguments: " + e.getMessage());
      return;
    }
    long startTime = System.currentTimeMillis();

    ExecutorService executor = Executors.newFixedThreadPool(numClient);
    List<Future<Long>> futureList = new ArrayList<Future<Long>>();
    List<ReadWriteFileCallable> callables = new ArrayList<ReadWriteFileCallable>();

    for (int i = 0; i < numClient; i++) { // Concurrent
      ReadWriteFileCallable callable = new ReadWriteFileCallable(read, ec, coder);
      futureList.add(executor.submit(callable));
      callables.add(callable);
    }

    int i = 0;
    long sumTime = 0;
    double[] storageTime = new double[numClient];

    for (Future<Long> future : futureList) {
      storageTime[i++] = future.get() / 1000.0;
      System.out.println("" + (read ? "Read" : "Write") + " time " + future.get() / 1000.0 + "s"
              + "  Throughput = " + (12 * 1024) / (future.get() / 1000.0) + " MB/s");
    }

    long endTime = System.currentTimeMillis();
    for (i = 0; i < numClient; i++) {
      sumTime += storageTime[i];
    }
    System.out.println("Total Throughput = " + (numClient * 12 * 1024 / ((endTime - startTime) / 1000.0)) + " MB/s");
    System.out.println("Average time = " + sumTime / numClient + " s");
    executor.shutdown();
    executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    for (ReadWriteFileCallable callable : callables) {
      callable.cleanUp();
    }
  }
}