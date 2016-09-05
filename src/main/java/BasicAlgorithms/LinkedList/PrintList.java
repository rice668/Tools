package BasicAlgorithms.LinkedList;

/**
 * Created by zhangminglei on 2016/9/4.
 */
public class PrintList {

  static void printListByRecur(ListNode list) {
    if (list != null) {
      printListByRecur(list.next);
      System.out.println(list.val);
    }
  }

  public static void main(String[] args) {
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);
    list.next.next = new ListNode(3);
    list.next.next.next = new ListNode(4);
    list.next.next.next.next = new ListNode(5);
    printListByRecur(list);
  }
}
