package com.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
         long programStart = System.nanoTime();
        int[] array = new int[100000];
        Random value = new Random();

        // Generating Array with 100,000 random  numbers
        System.out.println("Generating Array with 100,000 Random numbers.");
        long generatingStart = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            array[i] = value.nextInt(126);
        }
        long generatingEnd = System.nanoTime();
        System.out.println(".Generating Done!");
        System.out.println("Time it took for Generating 100,000: " + (generatingEnd - generatingStart)/1000000.0 + " ms.");

        // Finding the first occurence of 53
        System.out.println("Finding the First occurence of 53.");
        long searching53Start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 53 ) {
                long searching53End = System.nanoTime();
                System.out.println("Found 53 at index: " + i + " took " + (searching53End - searching53Start)/1000000.0 + " ms.");
                break;
            }
            else {
                continue;
            }

        }
    }
}