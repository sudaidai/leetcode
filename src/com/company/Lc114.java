package com.company;

/*
 * 114. Flatten Binary Tree to Linked List
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */

import com.company.data.TreeNode;

import java.util.Stack;

public class Lc114 implements Answer{

    @Override
    public int getIndex() {
        return 114;
    }

    public void flatten(TreeNode root) {
//        preorder(root);
        morris(root);
    }

    private void preorder(TreeNode root) {
        TreeNode pre = new TreeNode();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()) {
            TreeNode tn = stack.pop();
            if(tn != null) {
                if(tn.right != null) {
                    stack.push(tn.right);
                }
                if(tn.left != null) {
                    stack.push(tn.left);
                    tn.left = null;
                }
            }
            pre.right = tn;
            pre = pre.right;
        }
    }

    public void morris(TreeNode root) {
        while(root != null){
            if(root.left != null){
                TreeNode prev = root.left;
                while(prev.right != null ){
                    prev = prev.right;
                }
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }


}
