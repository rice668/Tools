package BasicAlgorithms.Tree;

/**
 * Created by root on 16-2-17.
 */
public class NumberOfNodesIn2XTree {

    /**
     * 求2X树结点的个数
     * @param root
     * @return
     */
    public int numbersOfNodes(TreeNode root) {
        if (root != null) {
            return numbersOfNodes(root.left) + numbersOfNodes(root.right) + 1;
        } else
            return 0;
    }
    /**
     * 求二叉树第K层的节点个数,思路是如果求第k层的结点个数,那么就是求第 k-1层
     * 的左右孩子的结点个数的和
     * @param root
     * @return
     */
    public int numberOf_K_thNode(TreeNode root,int k){
        if(root == null || k==0)
            return 0;
        if(k == 1)
            return 1;
        int numLeft = numberOf_K_thNode(root.left, k-1);
        int numRight = numberOf_K_thNode(root.right, k-1);
        return numLeft + numRight;
    }
    /**
     * 求2X树中叶子结点的个数,思路是.什么是叶子结点？有什么性质？
     * 左右子树为空的结点即为叶子结点
     * 递归的遍历每一个结点,只要发现这个结点的左右子树为空就加1
     * @param root
     * @return
     */
    public int numberOfLeafNode(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right ==null)
            return 1;
        return numberOfLeafNode(root.left) + numberOfLeafNode(root.right);
    }

    /**
     * 判断2棵2X树是否结构相同
     * 递归的去判断每一个结点
     * @param root1
     * @param root2
     * @return
     */
    public boolean same2XTree(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if((root1 ==null && root2!=null) || (root1!=null && root2 == null))
            return false;
        boolean leftTree = same2XTree(root1.left, root2.left);
        boolean rightTree = same2XTree(root1.right, root2.right);
        return leftTree && rightTree;
    }
    /**
     * 求2X树的镜像
     * @param root
     */
    public void mirrorOf2XTree(TreeNode root){
        //当树不存在或者只有根结点
        if(root == null || (root.left ==null) &&
                (root.right == null))
            return;
        TreeNode tempNode;
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if(root.left!=null)
            mirrorOf2XTree(root.left);
        if(root.right!=null)
            mirrorOf2XTree(root.right);
    }

    public static void main(String[] args) {
        TwoXTree tree = new TwoXTree();
        TreeNode root1 = tree.createBinaryTree();
        TreeNode root2 = tree.createAnotherBinaryTree();
        new NumberOfNodesIn2XTree().mirrorOf2XTree(root2);

    }
}