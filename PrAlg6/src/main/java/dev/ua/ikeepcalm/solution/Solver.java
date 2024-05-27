package dev.ua.ikeepcalm.solution;

import dev.ua.ikeepcalm.solution.heaps.Heap;

public class Solver {

    private final Heap maxHeap;
    private final Heap minHeap;

    public Solver() {
        maxHeap = new Heap((a, b) -> b - a);
        minHeap = new Heap(Integer::compareTo);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.getRoot()) {
            maxHeap.addElement(num);
        } else {
            minHeap.addElement(num);
        } balanceHeaps();
    }

    public int[] findMedian() {
        int size = maxHeap.getSize() + minHeap.getSize();
        if (size % 2 == 0) {
            return new int[]{maxHeap.getRoot(), minHeap.getRoot()};
        } else {
            if (maxHeap.getSize() > minHeap.getSize()) {
                return new int[]{maxHeap.getRoot()};
            } else {
                return new int[]{minHeap.getRoot()};
            }
        }
    }

    private void balanceHeaps() {
        int sizeDiff = maxHeap.getSize() - minHeap.getSize();
        if (sizeDiff > 1) {
            minHeap.addElement(maxHeap.poll());
        } else if (sizeDiff < - 1) {
            maxHeap.addElement(minHeap.poll());
        }
    }
}
