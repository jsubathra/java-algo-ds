package com.suba.trees;

public class TreeNode {
    public int label;
    public TreeNode left_ptr;
    public TreeNode right_ptr;

    public TreeNode(int label) {
        this.label = label;
        left_ptr = null;
        right_ptr = null;
    }

    public void insert(int value) {
       // if (value <= label) {
            if (left_ptr == null)
                left_ptr = new TreeNode(value);
            else
                left_ptr.insert(value);
      //  } else {
            if (right_ptr == null)
                right_ptr = new TreeNode(value);
            else
                right_ptr.insert(value);
        //}
    }
}
