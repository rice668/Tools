package BasicJava.util;

/**
 * Created by root on 16-7-26.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestPriorityQueue {
  private String name;
  private int population;

  public TestPriorityQueue(String name, int population) {
    this.name = name;
    this.population = population;
  }

  public String getName() {
    return this.name;
  }

  public int getPopulation() {
    return this.population;
  }

  public String toString() {
    return getName() + " - " + getPopulation();
  }

  public static void main(String args[]) {
    Comparator<TestPriorityQueue> OrderIsdn = new Comparator<TestPriorityQueue>() {

      @Override
      public int compare(TestPriorityQueue o1, TestPriorityQueue o2) {
       return o1.getPopulation() - o2.getPopulation();
      }
    };
    // First in not the first out.
    PriorityQueue<TestPriorityQueue> priorityQueue = new PriorityQueue<TestPriorityQueue>(10, OrderIsdn);
    TestPriorityQueue t1 = new TestPriorityQueue("t1", 1);
    TestPriorityQueue t3 = new TestPriorityQueue("t3", 3);
    TestPriorityQueue t2 = new TestPriorityQueue("t2", 2);
    TestPriorityQueue t4 = new TestPriorityQueue("t4", 0);
    priorityQueue.add(t1);
    priorityQueue.add(t3);
    priorityQueue.add(t2);
    priorityQueue.add(t4);
    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
    System.out.println(priorityQueue.poll().toString());
  }
}
