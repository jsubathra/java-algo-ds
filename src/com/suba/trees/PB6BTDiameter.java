package com.suba.trees;

public class PB6BTDiameter {
    static Integer globalDiameter = 0;

    static Integer binary_tree_diameter(TreeNode root) {

        if(root == null)
            return 0;
        binary_tree_diameterHelper(root);
        return globalDiameter;




    }

   static Integer binary_tree_diameterHelper(TreeNode root){

       //Base CAse
       if(root == null)
           return 0;

       //Recursive Case


          int lHeight = binary_tree_diameterHelper(root.left_ptr);

          int rHeight = binary_tree_diameterHelper(root.right_ptr);

          globalDiameter = Integer.max(globalDiameter,lHeight + rHeight);
         return Integer.max(lHeight,rHeight) +1;
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

        System.out.println(binary_tree_diameter(root));

    }
}
