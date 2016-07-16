package BasicAlgorithms;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
/**
 list1     1
            ↘
                3 → 4 → 5
            ↗
 list2	  2
 */
public class Crosspoint {

    /**
     *
     * @param headA
     * @param headB
     * @return Crosspoint
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            throw new NullPointerException("No Crosspoint");
        ListNode node = null;
        HashSet<ListNode> setA = new HashSet<ListNode>();
        while(headA != null) {
            setA.add(headA);
            headA = headA.next;
        }
        //接下来,对headB里面的每一个元素,去HashSet里面查询
        while(headB != null) {
            if(setA.contains(headB)) {
                node = headB;
                break;
            }
            else {
                headB = headB.next;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);
        list1.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = list1.next;

        Crosspoint i = new Crosspoint();
        ListNode node = i.getIntersectionNode(list1, list2);
        System.out.println(node.val);
    }
}
