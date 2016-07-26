package BasicAlgorithms.SortAndSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class Merge_Two_Sorted_Lists {

  // Common Way
  public ListNode mergeTwoListsByCommonWay(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode workPointer = ans;

    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        workPointer.next = l2;
        l2 = l2.next;
      } else {
        workPointer.next = l1;
        l1 = l1.next;
      }
      workPointer = workPointer.next;
    } // while end.

    if (l2 == null) {
      workPointer.next = l1;
    } else {
      workPointer.next = l2;
    }
    return ans.next;
  }

  // solution by priority queue
  public void mergeKLists(ListNode l1, ListNode l2) {
    PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });
    while (l1 != null) {
      queue.add(l1);
      l1 = l1.next;
    }
    while (l2 != null) {
      queue.add(l2);
      l2 = l2.next;
    }
    //8 is the mock list length of l1+l2
    for (int i = 0; i < 8; i++) {
      System.out.println(queue.poll().val);
    }
  }

  // solution by recursion
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  public static void main(String[] args) {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(3);
    ListNode list2 = new ListNode(2);
    list2.next = new ListNode(4);
//    ListNode list = new Merge_Two_Sorted_Lists().mergeTwoLists(list1, list2);

//    List<ListNode> lists = new ArrayList<ListNode>();
//    lists.add(list1);
//    lists.add(list2);
//    new Merge_Two_Sorted_Lists().mergeKLists(list1, list2);
//    while (listNode != null) {
//      System.out.print(listNode.val + " ");
//      listNode = listNode.next;
//    }
    ListNode list = new Merge_Two_Sorted_Lists().mergeTwoListsByCommonWay(list1, list2);
    while (list != null) {
      System.out.print(list.val + " ");
      list = list.next;
    }
  }
}