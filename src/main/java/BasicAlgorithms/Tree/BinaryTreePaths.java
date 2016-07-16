package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by root on 16-1-6. https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    // Depth-first Search
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            throw new NullPointerException();
        List<String> list = new ArrayList<String>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.empty()) {
            Iterator iterator = stack.iterator();
            StringBuffer sb = new StringBuffer();
            while (iterator.hasNext()) {
                TreeNode node = (TreeNode) iterator.next();
                sb = sb.append(new StringBuffer(String.valueOf(node.val)));
            } // while end.
            list.add(sb.toString()); // print
            stack.pop();
            TreeNode node = stack.peek();
            if (node.right != null && !node.right.flag) {
                node.right.flag = true;
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                } // while end.
            }
        } // while end.
        return list;
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
        binaryTreePaths(root);
    }
}