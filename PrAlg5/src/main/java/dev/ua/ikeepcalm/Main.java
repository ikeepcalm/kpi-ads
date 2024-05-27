package dev.ua.ikeepcalm;

import dev.ua.ikeepcalm.solution.Tree;

public class Main {


    public static void main(String[] args) {
        Tree tree = new Tree(getRandArray(10));
        tree.printTree();
        System.out.println("Largest element in the tree is: " + tree.findLargestElement());
    }


    private static double[] getRandArray(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            double rand = Math.random() * 15;
            rand = Math.round(rand * 100.0) / 100.0;
            arr[i] = rand;
        }
        System.out.println("Generated array which will be converted to binary tree:");
        printArray(arr);
        System.out.println("--------------------------------------------------------------");
        return arr;
//        return new double[]{10, 7, 14, 20, 1, 5, 8};
    }

    private static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

}
