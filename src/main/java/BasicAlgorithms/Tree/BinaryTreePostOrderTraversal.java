package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */

import java.util.*;

/**
 * Created by root on 16-1-7.
 * <p/>
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostOrderTraversal {

    public static List<Integer> postOrderTraversalByArrayList(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode last = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) { // As long as root is not NULL, then push all left node. Node that: apply this rules to all node in the tree.
                stack.push(root);
                root = root.left;
                // traverse to the leftmost
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && last != peekNode.right) {
                    root = peekNode.right;
                } else {
                    result.add(peekNode.val);
                    last = stack.pop();
                }
            }
        } // while
        return result;
    }

    public static List<Integer> postOrderTraversalByLinkedList(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        } // while end
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.left.left = new TreeNode(9);
        root.left.right.left.right = new TreeNode(10);
        for (Integer i : postOrderTraversalByArrayList(root)) {
            System.out.print(i + ", ");
        }
    }
}