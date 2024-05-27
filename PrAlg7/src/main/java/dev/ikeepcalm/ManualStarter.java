package dev.ikeepcalm;

import dev.ikeepcalm.structures.HashTable;

import java.util.Random;
import java.util.Scanner;

public class ManualStarter {

    private static final int TEST_AMOUNT = 20;

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        System.out.println("===============================");
        System.out.println("Generating " + TEST_AMOUNT + " random strings...");
        System.out.println("One of these strings will have the key to search for as below:");
        String[][] values = generateRandomStrings(TEST_AMOUNT);
        System.out.println("===============================");
        for (String[] value : values) {
            hashTable.put(value[0], value[1]);
        }
        System.out.println(hashTable);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("===============================");
            System.out.println("Enter a key to search for: ");
            String key = scanner.nextLine();
            System.out.println("Searching for key: " + key);
            String value = hashTable.get(key);
            System.out.println("Value: " + value);
            System.out.println("Do you want to search for another key? (Y/N)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                exit = true;
            }
        }

    }

    private static String[][] generateRandomStrings(int size) {
        String[][] strings = new String[size][2];
        boolean isKey = false;
        for (int i = 0; i < size; i++) {
            if (!isKey && new Random().nextBoolean()) {
                isKey = true;
                String key = generateRandomString(20);
                strings[i][0] = key;
                String value = generateRandomString(20);
                strings[i][1] = value;
                System.out.println("Key: " + key + " Value: " + value);
            } else {
                strings[i][0] = generateRandomString(20);
                strings[i][1] = generateRandomString(200);
            }
        }
        return strings;
    }

    private static String generateRandomString(int length) {
        String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (length-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

}
