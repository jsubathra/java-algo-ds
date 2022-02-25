package com.suba.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
public class PB3BTPostOrderTraversal {

    static ArrayList<Integer> postorder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null)
            return result;

        postorderHelper(root,result);

        return result;

    }

    public static void postorderHelper(TreeNode node, ArrayList<Integer> result){
        if(node == null)
            return;
        postorderHelper(node.left_ptr,result);
        postorderHelper(node.right_ptr,result);
        result.add(node.label);



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


        System.out.println(postorder(root));
    }


}
