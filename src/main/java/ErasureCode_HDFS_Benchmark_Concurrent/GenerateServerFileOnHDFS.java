package ErasureCode_HDFS_Benchmark_Concurrent;

/**
 * Created by root on 16-2-17.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Use thread to manage process. Main thread is dead, but all the sub thread is still alive.
 */
public class GenerateServerFileOnHDFS {

    static AtomicInteger num = new AtomicInteger();

    public static void generateServerFileOnHDFS() {
        int id = num.getAndIncrement();
        String command = "hadoop fs -put /tmp/ec-isa.img /HDFS-7285-Non-Policy/nonec-" + id + ".img";
        String commandEC = "hadoop fs -put /tmp/ec-isa.img /HDFS-7285-Policy/ec-" + id + ".img";
        try {
            System.out.println("Current Thread name = " + Thread.currentThread().getName());
            Runtime.getRuntime().exec(command).waitFor();
            Runtime.getRuntime().exec(commandEC).waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int num = 0;
        int numThread = Integer.parseInt(args[0]);
        ExecutorService exec = Executors.newFixedThreadPool(numThread);
        while (num++ < numThread) {
            Runnable task = new Runnable() {
                public void run() {
                    GenerateServerFileOnHDFS.generateServerFileOnHDFS();
                }
            };
            exec.execute(task);
        }
    }

}