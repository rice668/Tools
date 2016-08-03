package BasicAlgorithms.LinkedList;



public class ReverseListInternal {

    public void printLinkedList(ListNode list){
        while(list != null) {
            System.out.print(list.val);
            list = list.next;
        }
    }

    /**
     * http://www.2cto.com/kf/201110/106607.html
     * @param pHead
     * @return
     */
    public ListNode reverseLinkedList(ListNode pHead){
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

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        ReverseListInternal r = new ReverseListInternal();
        ListNode rl = r.reverseLinkedList(list);
        r.printLinkedList(rl);
    }
}