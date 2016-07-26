package BasicJava.util;

/**
 * Created by root on 16-7-26.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class testPriorityQueue {
  private String name;
  private int population;

  public testPriorityQueue(String name, int population) {
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
    Comparator<testPriorityQueue> OrderIsdn = new Comparator<testPriorityQueue>() {

      @Override
      public int compare(testPriorityQueue o1, testPriorityQueue o2) {
       return o1.getPopulation() - o2.getPopulation();
      }
    };
    // First in not the first out.
    PriorityQueue<testPriorityQueue> priorityQueue = new PriorityQueue<testPriorityQueue>(OrderIsdn);
    testPriorityQueue t1 = new testPriorityQueue("t1", 1);
    testPriorityQueue t3 = new testPriorityQueue("t3", 3);
    testPriorityQueue t2 = new testPriorityQueue("t2", 2);
    testPriorityQueue t4 = new testPriorityQueue("t4", 0);
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
