package com.suba.ds2;

public class BinaryTreeTest {
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree(); // leftchild < root < rightchild
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        BinaryTree tree1 = new BinaryTree(); // leftchild < root < rightchild
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(3);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);



        System.out.println("Depth First : PreOrder : Root, Left, Right");
        tree.traversePreOrder();

        System.out.println("Depth First : InOrder ==> Asc order: Left, Root, Right");
        tree.traverseInOrder();

        System.out.println("Depth First : PostOrder ==> from leaf to Root : Left, Right, Root");
        tree.traversePostOrder();

        System.out.println("Height for leaf nodes is 0 and the longest path is the  height use postTraversal");
        System.out.println(tree.height());

        System.out.println("Depth is opp of height:  No: of edges : Maximum depth of a tree");
        System.out.println(tree.depth());
        System.out.println("Done");

        System.out.println("Min Value in the Binary Tree: " + tree.min());

        System.out.println("Check if tree are equal : " + tree.equals(tree1));

        //tree.swapRoot();

        System.out.println("Check if the tree is a BST :  " + tree.isBinarySearchTree());

    }
}
