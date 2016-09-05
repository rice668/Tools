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
      pHead = reverseLinkedListByRecur(q);
    }
    q.next = p;
    p.next = null;
    return pHead;
  }


  /**
   * Myself implement this
   */
  public ListNode reverseLinkedListByMySelf(ListNode pHead) {
    ListNode p = pHead;
    ListNode q = pHead.next;
    ListNode r = pHead.next.next;
    pHead.next = null;
      while (q != null) {
        q.next = p;
        p = q;
        q = r;
        if (q == null)
          break;
        r = r.next;
      }
      return p;
  }

  /**
   * http://www.programcreek.com/2014/05/leetcode-reverse-linked-list-java/
   */
  public ListNode reverseList(ListNode head) {
    if(head==null || head.next == null)
      return head;
    //get second node
    ListNode second = head.next;
    //set first's next to be null
    head.next = null;
    ListNode rest = reverseList(second);
    second.next = head;
    return rest;
  }

  public static void main(String[] args) {
    ListNode list = new ListNode(1);
    list.next = new ListNode(2);
    list.next.next = new ListNode(3);
    list.next.next.next = new ListNode(4);
    list.next.next.next.next = new ListNode(5);
    list.next.next.next.next.next = new ListNode(6);
    ReverseListInternal r = new ReverseListInternal();
    ListNode rl = r.reverseList(list);
    r.printLinkedList(rl);
  }
}