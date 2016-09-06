package BasicAlgorithms.LeeCode;


import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Idea
 * 用一个栈实现队列的push，另一个栈完成队列的Pop，注意在pop的时候，必须等到
 * 先把stack2里面的元素全部pop完之后，才可以继续从stack1里面把元素push到stack2里面【这样才符合先进先出特性】
 *
 */
public class QueueFromStack {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(stack2.size()>0){
            return stack2.pop();
        }
        while(stack1.size()!=0){
            int node = stack1.pop();
            stack2.push(node);
        }
        int node = stack2.pop();
        return node;
    }

    public static void main(String[] args) {
        QueueFromStack q = new QueueFromStack();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.pop());
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        q.push(5);
        q.push(6);
        System.out.println(q.pop());
    }
}