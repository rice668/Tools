package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by root on 16-1-5.
 */

public class BinaryTreeLevelOrderTraversal {

    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            throw new NullPointerException();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null)
                  q.offer(node.left);
                if (node.right != null)
                  q.offer(node.right);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(5);
        System.out.println(levelOrder(root));

    }
}