package BlockQueueRealize;


/**
 * http://stackoverflow.com/questions/2536692/a-simple-scenario-using-wait-and-notify-in-java?rq=1
 */
public class UseBlockQueue {
  static final BlockQueue<Integer> blockQueue = new BlockQueue<Integer>(10);

  static void useBlockQueue() throws InterruptedException {

    Thread thread1 = new Thread(new Runnable() {
      public void run() {
        try {
          blockQueue.put(1);
          blockQueue.put(2);
          blockQueue.put(3);
          blockQueue.put(4);
        } catch (InterruptedException e) {
          e.getMessage();
        }
      }
    });

    Thread thread2 = new Thread(new Runnable() {
      public void run() {
        try {
          for (int i = 0; i < 3; i++)
            blockQueue.take();
        } catch (InterruptedException e) {
          e.getMessage();
        }
      }
    });

    Thread thread3 = new Thread(new Runnable() {
      public void run() {
        try {
          blockQueue.put(5);
          blockQueue.put(6);
          blockQueue.put(7);

        } catch (InterruptedException e) {
          e.getMessage();
        }
      }
    });

    Thread thread4 = new Thread(new Runnable() {
      public void run() {
        try {
          blockQueue.put(8);
          blockQueue.put(9);
          blockQueue.put(10);
        } catch (InterruptedException e) {
          e.getMessage();
        }
      }
    });

    Thread thread5 = new Thread(new Runnable() {
      public void run() {
        try {
          for (int i = 0; i < 4; i++)
            blockQueue.take();
        } catch (InterruptedException e) {
          e.getMessage();
        }
      }
    });


    thread1.setName("thread-1");
    thread2.setName("thread-2");
    thread3.setName("thread-3");
    thread4.setName("thread-4");
    thread5.setName("thread-5");

    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();

    /**
     *  With RuiLi help.
     *  main thread wait thread1 end. When thread1 end, thread2
     *  and thread3 may be end before.
     *
     *  Waits for this thread to die. Who wait ? Main Thread wait.
     */
    thread1.join();
    thread2.join();
    thread3.join();
    thread4.join();
    thread5.join();
  }

  public static void main(String[] args) throws InterruptedException {
    useBlockQueue();
//    Thread.sleep(3000); It is not a good method. Use join() instead.
    BlockQueue.Output(blockQueue.queue);
  }
}