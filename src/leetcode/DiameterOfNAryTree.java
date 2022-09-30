package leetcode;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    List<Node> children;

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class DiameterOfNAryTree {
    static int height(Node root){
        if(root == null){
            return -1;
        }
        int maxHeight = -1;
        for(Node node : root.children){
            maxHeight = Math.max(maxHeight, height(node));
        }
        return maxHeight + 1;
    }

    public static  int diameter(Node root) {
        if(root == null){
            return 0;
        }
        List<Integer> childHeights = new ArrayList<>();
        // int maxChildHeight = -1;
        int maxChildDia = 0;
        for(Node node : root.children){
            maxChildDia = Math.max(maxChildDia, diameter(node));
        }

        for(Node node : root.children){
            int tempHeight = height(node);
            childHeights.add(tempHeight);
        }

        int firstMax = -1;
        int secondMax = -1;
        for(Integer childHeight : childHeights){
            firstMax = Math.max(firstMax, childHeight);
        }
        boolean ignoredOnce = false;
        for(Integer childHeight : childHeights){
            if(!ignoredOnce && childHeight == firstMax){
                ignoredOnce = true;
                continue;
            }
            secondMax = Math.max(secondMax, childHeight);
        }

        int dia = (firstMax  == -1 ? 0 : 1 + firstMax) + (secondMax == - 1 ? 0 : 1 + secondMax) ;
        return Math.max(maxChildDia, dia);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.get(0).children.add(new Node(3));
        root.children.get(0).children.add(new Node(4));
        root.children.get(0).children.get(0).children.add(new Node(5));
        root.children.get(0).children.get(1).children.add(new Node(6));

        System.out.println(diameter(root));

    }
}
