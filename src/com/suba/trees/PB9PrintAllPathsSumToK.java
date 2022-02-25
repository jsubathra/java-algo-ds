package com.suba.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PB9PrintAllPathsSumToK {

    static List<List<Integer>> all_paths_sum_k(TreeNode root, int k){
        List<List<Integer>> resuts = new ArrayList<>();
        //edge case
        if(root == null)
            return resuts;
        List<Integer> slate = new ArrayList<>();

        all_paths_sum_kHelper(root,k,slate,resuts);
        if (resuts.size() == 0)
            resuts.add(new ArrayList<>(Arrays.asList(-1)));
        return resuts;
    }

    static void all_paths_sum_kHelper(TreeNode node, int k,List<Integer> slate,List<List<Integer>> resuts) {
        //Base Case
        if(node.left_ptr == null && node.right_ptr == null){
            if(k == node.val){
                slate.add(node.val);
                resuts.add(new ArrayList<>(slate));
                slate.remove(slate.size() -1);
            }
        }

        //Recursive Case
        slate.add(node.val);
        if(node.left_ptr != null)
            all_paths_sum_kHelper(node.left_ptr,k-node.val,slate,resuts);

        if(node.right_ptr != null)
            all_paths_sum_kHelper(node.right_ptr,k-node.val,slate,resuts);

        slate.remove(slate.size() - 1);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        TreeNode second = new TreeNode(25);
        TreeNode third = new TreeNode(30);
        TreeNode fourth = new TreeNode(45);
        TreeNode fifth = new TreeNode(40);
        TreeNode sixth = new TreeNode(50);


        root.left_ptr = second;
        root.right_ptr = third;
        second.left_ptr = fourth;
        third.left_ptr = fifth;
        third.right_ptr = sixth;

        System.out.println(all_paths_sum_k(root,80));
    }

    private static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;
        public TreeNode(int val) {
            this.val = val;
            left_ptr = null;
            right_ptr = null;
        }
    }

}
