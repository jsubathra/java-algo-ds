package com.suba.trees;

public class PB8SortedListToBST {
    class SinglyLinkedListNode {
        public Integer data;
        public SinglyLinkedListNode next;

        SinglyLinkedListNode(Integer node_data) {
            this.data = node_data;
            this.next = null;
        }

    };

    static class TreeNode{
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        public TreeNode(int val){
            this.val = val;
            this.left_ptr = null;
            this.right_ptr = null;
        }

    };

    static TreeNode sorted_list_to_bst(SinglyLinkedListNode head) {

        int length = findLength(head);

        int[] nums =  new int[length];
        int index =0 ;
        while(head != null){
            nums[index++] = head.data;
            head = head.next;
        }

       return sorted_list_to_bstHelper(nums,0,length -1);

    }

    static int findLength(SinglyLinkedListNode head){
        int cnt=0;
        while(head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

    static TreeNode sorted_list_to_bstHelper(int[] nums, int start, int end){
        //Base Case
        if(start > end)
            return null;
        if(start == 1)
            return new TreeNode(nums[start]);
        //Recursive Case
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left_ptr = sorted_list_to_bstHelper(nums,start,mid-1);
        root.right_ptr = sorted_list_to_bstHelper(nums, mid +1 ,end);
        return root;
    }

    public static void main(String args[]){

    }

}
