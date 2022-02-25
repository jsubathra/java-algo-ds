package com.suba.trees;

import java.util.ArrayList;

public class Pb10BSTfromPreOrderTraversal {

    class TreeNode {
        public int label;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(){
            this.left_ptr = null;
            this.right_ptr = null;
        }

        public TreeNode(int label){
            this.label = label;
            this.left_ptr = null;
            this.right_ptr = null;
        }
    }
    static void build_binary_search_tree(ArrayList<Integer> preorder) {


    }
}
