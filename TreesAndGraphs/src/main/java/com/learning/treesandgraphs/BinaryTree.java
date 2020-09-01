package com.learning.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    void addValue(int value) {
        root = addRecursively(root, value);
    }

    private Node addRecursively(Node root, int value) {
        if (root == null) {
            return new Node(value);
        } else if (root.nodeValue < value) {
            root.left = addRecursively(root.left, value);
        } else if (root.nodeValue > value) {
            root.right = addRecursively(root.right, value);
        }
        return root;
    }

    public int getSize() {
        int size = 0;
        return checkSize(size, root);
    }

    private int checkSize(int size, Node node) {
        if (node != null) {
            size += 1 +
                    checkSize(size, node.left) +
                    checkSize(size, node.right);
        }
        return size;
    }

    boolean containsValueDeepSearch(int val) {
        return deepFirstSearch(val, root);
    }

    boolean containsValueBreadthSearch(int val) {
        return breadthFirstSearch(root, val);

    }

    private boolean breadthFirstSearch(Node node, int val) {
        if (node == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node removedNode = queue.remove();
            if (removedNode.nodeValue == val) {
                return true;
            }
            if (removedNode.left != null) {
                queue.add(removedNode.left);
            }
            if (removedNode.right != null) {
                queue.add(removedNode.right);
            }
        }
        return false;
    }

    private boolean deepFirstSearch(int val, Node node) {
        if (node == null) {
            return false;
        } else {
            if (node.nodeValue == val) {
                return true;
            } else {
                return deepFirstSearch(val, node.left) || deepFirstSearch(val, node.right);
            }
        }
    }

    void deleteNode(int value) {
        root = deleteNodeRecursively(value, root);
    }

    private Node deleteNodeRecursively(int value, Node node) {
        if (value == node.nodeValue) {
            return removeFoundNode(node);
        } else if (value > node.nodeValue && node.left != null) {
            return deleteNodeRecursively(value, node.left);
        } else if (node.right != null) {
            return deleteNodeRecursively(value, node.right);
        }
        return node;
    }

    private Node removeFoundNode(Node node) {
        if (node.left == null && node.right == null) {
            return null;
        } else {
            if (node.left == null) {
                return node.right;
            } else {
                return node.left;
            }
        }
    }

    public void printNumbersInOrder() {
        printNumbersInRightOrder(root);
    }

    private void printNumbersInRightOrder(Node node) {
        if (node != null) {
            printNumbersInRightOrder(node.right);

            System.out.print(node.nodeValue + " ");
            printNumbersInRightOrder(node.left);
        }
    }

    public void printNumbersInPreOrder() {
        printNumbersInPreOrder(root);
    }

    private void printNumbersInPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.nodeValue + " ");
            printNumbersInPreOrder(node.right);
            printNumbersInPreOrder(node.left);
        }
    }

    public void printNumbersInPostOrder() {
        printNumbersInPostOrder(root);
    }

    private void printNumbersInPostOrder(Node node) {
        if (node != null) {
            printNumbersInPostOrder(node.right);
            printNumbersInPostOrder(node.left);
            System.out.print(node.nodeValue + " ");
        }
    }

    private class Node {
        int nodeValue;
        Node left;
        Node right;

        Node(int value) {
            this.nodeValue = value;
        }
    }
}
