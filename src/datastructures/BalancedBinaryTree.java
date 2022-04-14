package datastructures;

public class BalancedBinaryTree {

    static int  height(TreeNode root){
        if (root==null){
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int height = Math.max(lh,rh) + 1 ;
        return height;
    }

    boolean balancedBinaryTree(TreeNode root){
        return false;

    }

    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(BalancedBinaryTree.height(root));
    }
}
