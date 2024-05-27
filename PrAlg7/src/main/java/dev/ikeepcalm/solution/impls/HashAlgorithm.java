package dev.ikeepcalm.solution.impls;

import dev.ikeepcalm.solution.Algorithm;
import dev.ikeepcalm.structures.HashTable;

import java.util.Arrays;
import java.util.Random;

public class HashAlgorithm implements Algorithm {

    private HashTable hashTable;
    private String[][] strings;

    public HashAlgorithm() {
        hashTable = new HashTable();
    }

    @Override
    public void overHash(String[][] values) {
        this.strings = Arrays.copyOf(values, values.length);
        for (String[] string : values) {
            hashTable.put(string[0], string[1]);
        }
    }

    @Override
    public int getComparisons() {
        return hashTable.getComparisons();
    }

    @Override
    public int getProbes() {
        return hashTable.getCollisions();
    }

    @Override
    public double getSearchTime() {
        double startTime = System.nanoTime();
        hashTable.get(strings[new Random().nextInt(strings.length)][0]);
        double endTime = System.nanoTime();
        return endTime - startTime;
    }
}
