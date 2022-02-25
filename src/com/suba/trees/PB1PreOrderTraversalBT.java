package com.suba.trees;
import java.util.ArrayList;

public class PB1PreOrderTraversalBT {


    static ArrayList<Integer> preorder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        preorderHelper(root, result);
        return result;
    }

    static void preorderHelper(TreeNode node, ArrayList<Integer> result) {
        //Base Case
        if (node == null)
            return;
        // Recursive Case
        result.add(node.label);

        preorderHelper(node.left_ptr, result);

        preorderHelper(node.right_ptr, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(2);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(4);

        root.left_ptr = second;
        root.left_ptr.left_ptr = fourth;
        root.left_ptr.right_ptr = fifth;
        root.right_ptr = third;


        System.out.println(preorder(root));
    }
}
