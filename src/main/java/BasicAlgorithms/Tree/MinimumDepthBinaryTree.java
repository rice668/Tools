package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by root on 16-1-5.
 */
public class MinimumDepthBinaryTree {

    /**
     * implement by BFS. make the every level nodes into the queue and take out from queue as every loop.
     *
     * @param root
     * @return
     */
    public static int minDepthBinaryTreeByBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // for each level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                // node.left == null && node.right == null illustrate the leaf node.
                if (node.left == null && node.right == null) {
                    return depth;
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
        return depth;
    }

    /**
     * Minimum depth: The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * KeyWords : Tree, Depth-first Search, Breadth-first Search
     *
     * @param root
     * @return
     */
    public static int minDepthBinaryTreeByRecursion(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepthBinaryTreeByRecursion(root.right) + 1;
        if (root.right == null)
            return minDepthBinaryTreeByRecursion(root.left) + 1;
        int leftMinDepth = minDepthBinaryTreeByRecursion(root.left);
        int rightMinDepth = minDepthBinaryTreeByRecursion(root.right);
        return leftMinDepth > rightMinDepth ? rightMinDepth + 1 : leftMinDepth + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        System.out.println(minDepthBinaryTreeByBFS(root));
        System.out.println(minDepthBinaryTreeByRecursion(root));
    }
}
