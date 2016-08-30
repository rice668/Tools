package BasicAlgorithms.LinkedList;


public class ReverseListInternal {

  public void printLinkedList(ListNode list) {
    while (list != null) {
      System.out.print(list.val);
      list = list.next;
    }
  }

  /**
   * http://www.2cto.com/kf/201110/106607.html
   *
   * @param pHead
   * @return
   */
  public ListNode reverseLinkedList(ListNode pHead) {
    ListNode p = pHead;
    ListNode q = pHead.next; // working point
    ListNode r;
    pHead.next = null;
    while (q != null) {
      r = q.next;
      q.next = p;
      p = q;
      q = r;
    }
    pHead = p;
    return pHead;
  }

  /**
   * Recur way
   */
  public ListNode reverseLinkedListByRecur(ListNode pHead) {
    ListNode p = pHead;
    if (p == null) {
      return null;
    }
    ListNode q = p.next;
    if (q == null) {
      return p;
    } else {
      pHead = reverseLinkedListByRecur(q); // 记录子序列的新的头结点
    }
    q.next = p;
    p.next = null;
    return pHead; // 返回新的子序列的头结点
  }


  public static void main(String[] args) {
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);
    list.next.next = new ListNode(3);
    list.next.next.next = new ListNode(4);
    list.next.next.next.next = new ListNode(5);
    ReverseListInternal r = new ReverseListInternal();
    ListNode rl = r.reverseLinkedListByRecur(list);
    r.printLinkedList(rl);
  }
}