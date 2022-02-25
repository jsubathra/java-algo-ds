package com.suba.trees;

import java.util.*;

public class PB5BTReverseLevelOrderTraversal {

    public static List<List<Integer>> reverse_level_order_traversal(TreeNode root) {
        List<List<Integer>> results =  new ArrayList<>();
        if(root == null)
            return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> currentList = new ArrayList<>();
            int size = queue.size();
            for(int i =0 ; i < size; i++){
                TreeNode current = queue.remove();
                currentList.add(current.label);

                if(current.left_ptr != null) {
                    queue.add(current.left_ptr);
                }
                if(current.right_ptr != null) {
                    queue.add(current.right_ptr);
                }
            }
            results.add(currentList);
        }
        Collections.reverse(results);
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(2);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(4);

        root.left_ptr = second;
        root.right_ptr = third;
        second.left_ptr = fourth;
        second.right_ptr = fifth;


        System.out.println(reverse_level_order_traversal(root));

    }



}
