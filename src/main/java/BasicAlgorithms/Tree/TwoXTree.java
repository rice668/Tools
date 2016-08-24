package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  Boolean flag = false;

  public TreeNode(int val) {
    this.val = val;
  }
}

public class TwoXTree {

  /**
   * 1
   * 2       3
   * 4   5   6   7
   * 8
   * 12   9
   */
  public TreeNode createBinaryTree() {
    TreeNode treenode;
    treenode = new TreeNode(1);
    treenode.left = new TreeNode(2);
    treenode.left.left = new TreeNode(4);
    treenode.left.right = new TreeNode(5);
    treenode.right = new TreeNode(3);
    treenode.right.left = new TreeNode(6);
    treenode.right.right = new TreeNode(7);
    treenode.right.right.right = new TreeNode(8);
    treenode.right.right.right.left = new TreeNode(12);
    treenode.right.right.right.right = new TreeNode(9);
    return treenode;
  }

  /**
   *       1
   *   2       3
   * 4   5   6   7
   */
  public TreeNode createAnotherBinaryTree() {
    TreeNode treenode;
    treenode = new TreeNode(1);
    treenode.left = new TreeNode(2);
    treenode.left.left = new TreeNode(4);
    treenode.left.right = new TreeNode(5);
    treenode.right = new TreeNode(3);
    treenode.right.left = new TreeNode(6);
    treenode.right.right = new TreeNode(7);
    return treenode;
  }

  /**
   * 后序遍历
   *
   * @param root
   */
  public void postOrderTraversal(TreeNode root) {
    if (root != null) {
      postOrderTraversal(root.left);
      postOrderTraversal(root.right);
      System.out.println(root.val + " ");
    }
  }

  /**
   * 中序遍历
   *
   * @param root
   */
  public void inOrderTraversal(TreeNode root) {
    if (root != null) {
      inOrderTraversal(root.left);
      System.out.println(root.val + " ");
      inOrderTraversal(root.right);
    }
  }

  /**
   * 先序遍历
   *
   * @param root
   */
  public void preOrderTraversal(TreeNode root) {
    if (root != null) {
      System.out.println(root.val + " ");
      preOrderTraversal(root.left);
      preOrderTraversal(root.right);
    }
  }

  /**
   * 二叉树的高度等于根节点左边的二叉树深度和根节点右边的二叉树深度的最大值加上1，当不能再往下遍历的时候就为空了，这是
   * 递归的出口
   */
  public int depth(TreeNode root) {
    if (root != null) {
      int left = depth(root.left);
      int right = depth(root.right);
      return left > right ? left + 1 : right + 1;
    }
    return 0;
  }

  /**
   * 判断此2X树是否是平衡树 {任意结点的左右子树的深入相差不超过1}
   * <p/>
   * 你需要对每个节点都判断一次，一直到没有节点为止， 递归的去判断每个节点
   * <p/>
   * 在上面求过关于树的深入的问题之后，有了思路如下：
   * 在遍历到2X树每个结点的时候,调用depth函数看其左右的结点的深入
   * 并比较即可
   * 弊端！！！重复遍历结点
   * <p/>
   * 递归的判断左右子树是不是平衡树
   */
  public boolean isBalanceTree(TreeNode root) {
    if (root == null)
      return true;
    int left = depth(root.left);
    int right = depth(root.right);
    if (Math.abs(left - right) > 1)
      return false;
    return isBalanceTree(root.left) && isBalanceTree(root.right);
  }

  /**
   * 2X树非递归算法
   *
   * @param root
   * @return
   */
  public ArrayList<Integer> inorderTraversalWithoutRecursion(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (root != null || !stack.empty()) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        list.add(stack.peek().val);
        root = stack.pop();
        root = root.right;
      }
    }
    return list;
  }

  /**
   * 1
   * 2     3
   * 4   5 6   7
   * <p/>
   * 层次遍历
   * 输出为 1 2 3 4 5 6 7
   */
  public ArrayList<Integer> levelOrder(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) { // 递归的出口就是队列不为空
      list.add(queue.peek().val);
      root = queue.remove();
      if (root.left != null || root.right != null) {
        queue.add(root.left);
        queue.add(root.right);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    TwoXTree in = new TwoXTree();
    TreeNode treenode = in.createBinaryTree();
    in.postOrderTraversal(treenode);
  }
}