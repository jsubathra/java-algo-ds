package com.suba.trees;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pb1BTLevelOrderTraversal {
    //This is also called BreadthFirstSearch

    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;

        //System.out.println(root.rightChild.rightChild.value);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.remove(); // Pop the current level item and add to the individual level list
                currentLevel.add(node.label);

                if (node.left_ptr != null) {
                    queue.add(node.left_ptr); // Add the left child to the queue
                }
                else if (node.right_ptr != null){
                    queue.add(node.right_ptr); // Add right child to the queue
                }
            }
            result.add(currentLevel); // Add all current levels to the result list.
        }
        return result;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode second = new TreeNode(1);
        TreeNode third = new TreeNode(2);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(4);

        root.left_ptr = second;
        second.right_ptr = third;
        third.left_ptr = fifth;
        fifth.right_ptr = fourth;

        System.out.println(bfs(root));

    }



}


