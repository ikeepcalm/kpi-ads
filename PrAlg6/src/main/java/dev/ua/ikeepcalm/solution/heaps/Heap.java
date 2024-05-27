package dev.ua.ikeepcalm.solution.heaps;

import java.util.Arrays;
import java.util.Comparator;

public class Heap {
    private Integer[] contents;
    private final Comparator<Integer> comparator;
    int size;

    public Heap(Comparator<Integer> comparator) {
        this.contents = new Integer[20];
        this.comparator = comparator;
    }

    public void buildFromArray(Integer[] elements) {
        contents = Arrays.copyOf(elements, elements.length);
        size = elements.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            moveDown(contents[i], contents, size);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseCapacity() {
        int oldCapacity = contents.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        contents = Arrays.copyOf(contents, newCapacity);
    }

    public void addElement(Integer element) {
        int i = size;
        if (i >= contents.length)
            increaseCapacity();
        moveUp(i, element, contents);
        size = i + 1;
    }

    public Integer getRoot() {
        return contents[0];
    }


    public int getSize() {
        return size;
    }

    public Integer poll() {
        final Integer[] elements;
        final Integer result;

        if ((result = ((elements = contents)[0])) != null) {
            final int n;
            final int x = elements[(n = --size)];
            elements[n] = null;
            moveDown(x, elements, n);
        }
        return result;
    }

    private void moveUp(int k, Integer x, Integer[] elements) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Integer e = elements[parent];
            if (comparator.compare(x, e) >= 0)
                break;
            elements[k] = e;
            k = parent;
        }
        elements[k] = x;
    }

    private void moveDown(Integer x, Integer[] elements, int n) {
        int k = 0;
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Integer c = elements[child];
            int right = child + 1;
            if (right < n && comparator.compare(c, elements[right]) > 0)
                c = elements[child = right];
            if (comparator.compare(x, c) <= 0)
                break;
            elements[k] = c;
            k = child;
        }
        elements[k] = x;
    }
}
