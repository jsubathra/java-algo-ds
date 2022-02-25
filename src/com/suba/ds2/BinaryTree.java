package com.suba.ds2;

public class BinaryTree {

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node= " + value;
        }
    }
    // this is the root node
    private Node root;

    public void insert(int value){
        var node = new Node(value);
        // if Tree empty then root is set to the value inserted and return
        if(root == null) {
            root = node;
            return;
        }
        // if root not null we need to identify the parent for the value to be inserted
        // if less that root value shd be left and if greater will be right
        var current = root;
        //loop till we need parent
        while(true){
            if(value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else {
                if(current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while(current != null){
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;

        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if(root == null)
            return; //Base condition ... recursion
        System.out.println(root.value);
        //root ... left .. right
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root){
        if(root == null)
            return; //Base condition ... recursion
        //left ... root .. right
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if(root == null)
            return; //Base condition ... recursion
        //left ... right .. root
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);

    }

    public int height(){
       return height(root);
    }

    private int height(Node root) {
        if (isRootEmpty())
            return -1;
        // base Condition
        if(isLeaf(root))
            return 0;
        // cal the ht of left subtree and right subtree  height and chk which is grater - then add 1 to it.
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean isRootEmpty(){
        return root == null;
    }

    public int depth(){
        return depth(root);
    }
    private int depth(Node node){
        if(node == null)
            return 0;
        int left = depth(node.leftChild);
        int right = depth(node.rightChild);
        return Math.max(left,right) + 1;

    }

    public int min(){
        // return min(root); ==> if binary tree ==> O(n)
        // if binary search  === > Find leftmost tree ==> O(log n)
       return binSearchMin(root);
    }

    // This is for Binary Tree - it is not binary search tree where left < root < right
    //O(n)
    private int min(Node node){
        // Base Condition
        if(isLeaf(node))
            return node.value;
        var left = min(node.leftChild);
        var right = min(node.rightChild);
        // compare the left subtree,right subtree min value and then with the node value
        return Math.min(Math.min(left,right),node.value);
    }

    // Binary Search - left < root < right == O(log n) -- only finding the left most leaf
    private int binSearchMin(Node root){
        if( root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while ( current != null){
            last = current; // pointer to left most child
            current = current.leftChild;
        }
        return last.value;
    }

    private int binSearchMax(Node root) {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current; // pointer to left most child
            current = current.rightChild;
        }
        return last.value;
    }

    public boolean equals (BinaryTree other){
        //if other is empty tree
        if(other == null) return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        // If both tree are null
        if(first == null && second == null)
            return true;
        // if both are not null compare root values and the left and right subtrees of both recursively (used PreOrder)
        if(first != null && second != null){
            return first.value == second.value
                    && equals(first.leftChild,second.leftChild)
                    && equals(first.rightChild,second.rightChild);
        }

        // if one is null
        return false;

    }

    public void swapRoot(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE); // because min and max could be any integers
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        // if root is null then it is a BST
        if(root == null)
            return true;
        // if root.value is not in range then not BST
        if(root.value < min || root.value > max)
            return false;
        // AT this point means it is in range and we need to recursively check
        // left subtree shd be between min and root value-1 and
        //right subtree shd be between root.value +1 and max
        return
             isBinarySearchTree(root.leftChild, min, root.value - 1 )
                && isBinarySearchTree(root.rightChild,root.value + 1, max);

    }
}
