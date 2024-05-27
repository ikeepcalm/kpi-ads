package dev.ikeepcalm.analysis;

import java.util.Random;

public class ArrayGenerator {

    public static int[] generateBestScenario(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateRandomScenario(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        shuffleArray(array);
        return array;
    }

    public static int[] generateWorstScenario(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

    private static void shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Swap
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }


}
