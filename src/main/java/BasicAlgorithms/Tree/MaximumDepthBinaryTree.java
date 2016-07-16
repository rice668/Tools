package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by root on 16-1-5.
 */
public class MaximumDepthBinaryTree {

    /**
     * You can use BFS rather than DFS, store every leaf node depth into a array, and select the max value is ok.
     *
     * @param root
     * @return
     */
    public static int maxDepthByBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // for each level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // node.left == null && node.right == null illustrate the leaf node.
                if (node.left == null && node.right == null) {
                    arrayList.add(depth);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            } // for end.
            depth++;
        } // while end.
        int max = 0;
        for (Integer i : arrayList) {
            max = i;
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    /**
     * https://leetcode.com/problems/maximum-depth-of-binary-tree/
     * keywords Depth-first Search
     * <p/>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * This method also called DFS.
     */
    public static int maxDepthByDFS(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return maxDepthByDFS(root.right) + 1;
        if (root.right == null)
            return maxDepthByDFS(root.left) + 1;
        return Math.max(maxDepthByDFS(root.left), maxDepthByDFS(root.right)) + 1;
    }

    public static int maxDepthByDFSOneLineCode(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepthByDFSOneLineCode(root.left), maxDepthByDFSOneLineCode(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(5);
        System.out.println(maxDepthByDFS(root));
        System.out.println(maxDepthByBFS(root));
    }
}