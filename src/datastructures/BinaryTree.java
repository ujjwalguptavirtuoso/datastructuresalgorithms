package datastructures;

import java.util.*;

public class BinaryTree {

    static BinaryTree bt = new BinaryTree();

    TreeNode root;

    BinaryTree(){
        root = null;
    }

    public static void printInOrderTraversal(TreeNode root){

        if(root == null){
            return;
        }
        printInOrderTraversal(root.left);

        System.out.println(root.key);

        printInOrderTraversal(root.right);
    }

    public static void  printPreOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.key);

        printPreOrderTraversal(root.left);

        printPreOrderTraversal(root.right);

    }

    public static void  printPostOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        printPostOrderTraversal(root.left);

        printPostOrderTraversal(root.right);

        System.out.println(root.key);

    }

    public void levelOrderTraversal(TreeNode root){
       if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<TreeNode> stack = new Stack<>();
        //stack.
        TreeNode tempNode = root;
        queue.add(root);
        while(!queue.isEmpty()){
          //  System.out.println(tempNode.key);

            TreeNode outNode =  queue.remove();
            System.out.println(outNode.key);
            if(tempNode.left!= null) {
                queue.add(tempNode.left); }
            if(tempNode.right!= null){
                queue.add(tempNode.right); }

        }

       /* Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {

            *//* poll() removes the present head.
            For more information on poll() visit
            http://www.tutorialspoint.com/java/
            util/linkedlist_poll.htm *//*
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.key + " ");

            *//*Enqueue left child *//*
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            *//*Enqueue right child *//*
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }*/
       /* TreeNode node = new TreeNode();
        this.tempQueue.add(root);
        while(!this.tempQueue.isEmpty()){
            node = this.tempQueue.remove();
            System.out.println(node.key);
        }
        levelOrderTraversal(node.left);
        levelOrderTraversal(node.right);*/
    }



    public static void main(String []args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

       // printInOrderTraversal(root);

       // printPreOrderTraversal(root);

        //
        // printPostOrderTraversal(root);

         bt.levelOrderTraversal(root);


    }

    private Queue<TreeNode> tempQueue = new Queue<TreeNode>() {
        @Override
        public boolean add(TreeNode treeNode) {
           return tempQueue.add(treeNode);
        }

        @Override
        public boolean offer(TreeNode treeNode) {
            return false;
        }

        @Override
        public TreeNode remove() {
            return tempQueue.remove();
        }

        @Override
        public TreeNode poll() {
            return null;
        }

        @Override
        public TreeNode element() {
            return null;
        }

        @Override
        public TreeNode peek() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<TreeNode> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends TreeNode> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };


}
