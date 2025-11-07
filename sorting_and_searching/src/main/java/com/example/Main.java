package com.example;

import java.util.Arrays;
import java.util.Random;

/*
 * 1. Generate 100,000 positive numbers in the range (0, 125).
 * 2. Search for the first occurrence of the number 53 using a sequential search algorithm.
 * 3. Count the total number of occurrences of 53 in the array.
 * 4. After completing steps 1–3, sort the array using one of the required sorting algorithms. (Merge Sort)
 * 5. Repeat step 3 using a required search algorithm on the sorted array. (Binary Search)
 * 6. Compute and compare the time cost between step 3 only and steps 4 and 5 combined.
 * @authie Nil Patel
 */

public class Main {
    public static void main(String[] args) {
        long programStart = System.nanoTime();
        int[] array = new int[100000];
        Random value = new Random();

        /*STEP 1 */
        // Generating Array with 100,000 random  numbers
        System.out.println("Generating Array with 100,000 Random numbers.");
        long generatingStart = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            array[i] = value.nextInt(126);
        }
        long generatingEnd = System.nanoTime();
        System.out.println(".Generating Done!");
        System.out.println("Time it took for Generating 100,000: " + (generatingEnd - generatingStart)/1000000.0 + " ms.");

        /*STEP 2 */
        // Finding the first occurence of 53
        System.out.println("Finding the First occurence of 53.");
        long searching53Start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 53 ) {
                long searching53End = System.nanoTime();
                System.out.println("Found 53 at index: " + i + " took " + (searching53End - searching53Start)/1000000.0 + " ms.");
                break;
            }
            else if (i == array.length - 1) {
                System.out.println("53 Not in Array.");
            }
            else {
                continue;
            }
        }

        /*STEP 3 */
        // Counting the total number of occurrence of 53 in the array
        long counting53Start = System.nanoTime();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 53 ) {
                count++;
            }
        }
        long counting53End = System.nanoTime();
        System.out.println("Found 53 " + count + " times. Took " + (counting53End - counting53Start)/1000000.0 + " ms.");

        /*STEP 4 */
        // Sorting the Array with Merge Sort
        

        /*STEP 5 */
        // Counting the Total number of occurrence of 53 in the array with Binary Search


        /*STEP 6 */

    }
}

public void mergeSort(int arr[], int start, int end) {
    //Sorts array by recursive mergesort

    if (end > 1) {
        int[] arrayB = Arrays.copyOfRange(arr, start, end / 2);
        int[] arrayC = Arrays.copyOfRange(arr, end / 2, end);

        mergeSort(arrayB, 0, arrayB.length);
        mergeSort(arrayC, 0, arrayC.length);
    }
}

public void merge(int arrA[], int arrB[], int arrC[]) {
    // Merges two sorted arrays into one sorted array

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < arrB.length && j < arrC.length) {
        if (arrB[i] <= arrC[j]) {
            arrA[k] = arrB[i]; 
            i++;
        } else {
            arrA[k] = arrC[j];
            j++;
        }
        k++;
    }
}