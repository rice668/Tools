package BlockQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Typical producer and consumer model.
 *
 * @param <T>
 */
public class BlockQueue<T> {

  public LinkedList<T> queue = new LinkedList<T>();
  private final int capacity;

  public BlockQueue(int capacity) {
    this.capacity = capacity;
  }

  public static synchronized void Output(Queue queue) throws InterruptedException {
    Iterator iterator = queue.iterator();
    while (iterator.hasNext()) {
      Object object = iterator.next();
      System.out.println("Remain elements = " + object);
    }
  }

  public synchronized void put(T element) throws InterruptedException {
    System.out.println("put " + element + " " + Thread.currentThread().getName());
    while (queue.size() == capacity) {
      System.out.println("put wait");
      wait();
      System.out.println("put have invoked");
    }
    queue.add(element);
    notifyAll();
  }

  public synchronized T take() throws InterruptedException {
    System.out.println("take " + Thread.currentThread().getName());
    while (queue.isEmpty()) {
      System.out.println("take wait");
      wait();
      System.out.println("take have invoked");
    }
    T item = queue.remove();
    System.out.println("take the element = " + item);
    notifyAll();
    return item;
  }

}