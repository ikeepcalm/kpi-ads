package dev.ua.ikeepcalm.solution;

public class Tree {

    private final Node root;

    public Tree(double[] arr) {
        root = buildTree(arr);
    }

    public Node buildTree(double[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node root = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            insertNode(root, arr[i]);
        }

        return root;
    }

    private void insertNode(Node node, double data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insertNode(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insertNode(node.right, data);
            }
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print("Node: " + root.data + "(" + (root.left != null ? root.left.data : "null") + ", " + (root.right != null ? root.right.data : "null") + ")\n");
        printTree(root.left);
        printTree(root.right);
    }

    public double findLargestElement() {
        return findLargestElement(root);
    }

    private double findLargestElement(Node root) {
        if (root == null)
            return Double.MIN_VALUE;

        double max = root.data;
        double rightMax = findLargestElement(root.right);

        if (rightMax > max)
            max = rightMax;

        return max;
    }

}