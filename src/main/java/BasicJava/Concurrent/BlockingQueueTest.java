package BasicJava.Concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  public void put(E e) {
 *     putLast(e);
 *  }
 *  可读性也比较差
 */
public class BlockingQueueTest<E> {
  /** Main lock guarding all access */
  final ReentrantLock lock = new ReentrantLock();

  static final class Node<E> {
    E item;
    Node(E x) {
      item = x;
    }
  }

  public void putLast(E e) throws InterruptedException {
    if (e == null) throw new NullPointerException();
    Node<E> node = new Node<E>(e);
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
//      while (!linkLast(node))
//        notFull.await();
    } finally {
      lock.unlock();
    }
  }


  public static void main(String[] args) throws Exception {
    BlockingQueue blockingQueue = new LinkedBlockingDeque();
    blockingQueue.put(1);

  }


}
