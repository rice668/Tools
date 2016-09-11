package BasicAlgorithms.HuaWei;

/**
 * http://blog.csdn.net/ywh147/article/details/8675532
 * 设计一个共享数据队列，一个读操作，一个写操作，不给用锁，保证线程安全
 *
 * 加一个辅助队列专门用于写就行，读都在第一块读，写都在第二块，写完后更新第一块的值
 * 并且是每进行一次写操作都要进行更新。如果在一个共享数据队列里面的话，比如在写count
 * 变量的时候，此时另一个线程去读count变量，这个时候就出现了问题，所以在一块内存区域
 * 里面得加锁进行保护。
 */

public class ShareDataQueueWithoutLock {

  public static int count = 0;

  public static void inc() {
    count++;
  }

  public static void main(String[] args) {
    Thread threads[] = new Thread[1000];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          ShareDataQueueWithoutLock.inc();
        }
      });
      try {
        threads[i].start();
        threads[i].join(); // 主线程等待子线程执行完毕，不然主线程提前执行完毕，得不到你想要的结果，count不一定为1000
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("运行结果:Counter.count=" + ShareDataQueueWithoutLock.count);
  }
}
