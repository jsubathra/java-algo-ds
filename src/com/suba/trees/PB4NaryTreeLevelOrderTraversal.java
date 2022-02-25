package com.suba.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import java.util.Queue;

public class PB4NaryTreeLevelOrderTraversal {

    public static List<List<Integer>> level_order(TreeNode root){

        if (root == null) new ArrayList<>();
        ArrayList<List<Integer>> results = new ArrayList<>();
        TreeNode current = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.remove();
                currentLevel.add(current.label);
                for (int j = 0; j < current.children.size(); j++) {
                    queue.add(current.children.get(j));
                }
            }
            results.add(currentLevel);
        }
        return results;
    }


    static class TreeNode
    {
        int label;
        Vector<TreeNode> children = new Vector<TreeNode>(0);
        TreeNode(int _label)
        {
            label = _label;
            children.clear();
        }
    }
    public static void main(String[] args) {
       TreeNode root = new TreeNode(1);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(4);
        TreeNode fourth = new TreeNode(2);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        Vector<TreeNode> children = new Vector<TreeNode>(6);
         children.add(root);
         root.children.add(second);
         root.children.add(third);
         root.children.add(fourth);

        third.children.add(fifth);
        third.children.add(sixth);

        System.out.println(level_order(root));

    }

}
