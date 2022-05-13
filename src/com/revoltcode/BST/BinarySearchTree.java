package com.revoltcode.BST;

/*
 * Binary search tree (BST) is a binary tree where the value of each node is larger or equal to the values in all the nodes in that node's left subtree and is smaller than the values in all the nodes in that node's right subtree.

 * Write a function that, efficiently with respect to time used, checks if a given binary search tree contains a given value.

 * For example, for the following tree:

 * n1 (Value: 1, Left: null, Right: null)
 * n2 (Value: 2, Left: n1, Right: n3)
 * n3 (Value: 3, Left: null, Right: null)
 * Call to contains(n2, 3) should return true since a tree with root at n2 contains number 3.
 *
 * binary search tree:
 *          2
 *      /       \
 *      1       3
 */

class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        if (root.value == value) {
            return true;
        }else if (value<root.value && root.left!=null) {
            return contains(root.left, value);
        }else if (value> root.value && root.right!=null){
            return contains(root.right, value);
        }else return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}