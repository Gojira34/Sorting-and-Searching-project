package com.example;

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
        System.out.println("Generating Done!");
        System.out.println("Time it took for Generating 100,000: " + (generatingEnd - generatingStart)/1000000.0 + " ms.");

        /*STEP 2 */
        // Finding the first occurence of 53
        System.out.println("Finding the First occurence of 53.");
        long searching53Start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 53 ) {
                long searching53End = System.nanoTime();
                System.out.println("Found 53 at index: " + i + " took " + (searching53End - searching53Start)/ 1000000.0 + " ms.");
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
        long sortStart = System.nanoTime();

        // call mergesort on th full array, from index 0 to array.lenth -1
        mergeSort(array, 0, array.length - 1);

        long sortEnd = System.nanoTime();

        System.out.println("Merge sort took " + (sortEnd - sortStart) / 1000000.0 + " ms.");
        

        /*STEP 5 */
        // Counting the Total number of occurrence of 53 in the array with Binary Search
        long binaryCountStart = System.nanoTime();

        // Call the binarySearch method to count how many times 53 appears
        int binaryCount = binarySearch(array, 53);

        long binaryCountEnd = System.nanoTime();
        System.out.println("Binary search found 53 " + binaryCount + " times. Took " + (binaryCountEnd - binaryCountStart) / 1000000.0 + " ms.");


        /*STEP 6 */
        // compare the time cost between step 3 only and steps 4 and 5 combined

        // Sequential count time
        double sequentialCountTime = (counting53End - counting53Start) / 1000000.0;

        //merge sort time
        double mergeSortTime = (sortEnd - sortStart) / 1000000.0;

        //binary search time
        double binarySearchCountTime = (binaryCountEnd - binaryCountStart) / 1000000.0;

        // Combined time: sort + binary search counting
        double sortPlusBinaryTime = mergeSortTime + binarySearchCountTime;

        System.out.println("Time for sequential counting only: " + sequentialCountTime + " ms.");
        System.out.println("Time for merge sort + binary search counting: " + sortPlusBinaryTime + " ms.");

        long programEnd = System.nanoTime();
        System.out.println("Program took: " + (programEnd - programStart) / 1000000.0 + " ms.");
    }


    public static void mergeSort(int arr[], int start, int end) {
        //Sorts array by recursive mergesort

        // sort only if there is more than one element
        if (end > start) {
            // find the middle point
            int middle = (start + end) / 2;

            // Recursively sort the left half
            mergeSort(arr, start, middle);

            // Recursively sort the right half
            mergeSort(arr, middle + 1, end);

            // merge the sorted halves
            merge(arr, start, middle, end);
        }
    }

    public static void merge(int arr[], int start, int middle, int end) {
        // Merges two sorted arrays into one sorted array

        // find size of two subarrays to be merged
        int size1 = middle - start + 1;
        int size2 = end - middle;

        // create temp arrays
        int Leftarr[] = new int[size1];
        int Rightarr[] = new int[size2];

        // copy data to temp arrays
        for (int i = 0; i < size1; i++) {
            Leftarr[i] = arr[start + i];
        }
        for (int i = 0; i < size2; i++) {
            Rightarr[i] = arr[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < size1 && j < size2) {
            if (Leftarr[i] <= Rightarr[j]) {
                arr[k] = Leftarr[i];
                i++;
            }
            else {
                arr[k] = Rightarr[j];
                j++;
            }
            k++;
        }

        // copy remainig elements of Left array
        while (i < size1) {
            arr[k] = Leftarr[i];
            i++;
            k++;
        }

        // copy remaining elements of right array
        while (j < size2) {
            arr[k] = Rightarr[j];
            j++;
            k++;
        }
    }

    // Method for binary search that counts all occurrence of a value
    static int binarySearch(int startingArray[], int search) {
        int start = 0;
        int end = startingArray.length - 1;
        int count = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            
            // if search found we look left and right to see if there is mutiple search values
            if (startingArray[middle] == search) {
                count++;    // the first occurrence
                int left  = middle - 1;
                int right = middle + 1;

                // check left
                while (left >= 0 && startingArray[left] == search) {
                    count++;
                    left--;
                }

                // check right
                while (right < startingArray.length && startingArray[right] == search) {
                    count++;
                    right++;
                }
                return count;   // return total count
            }
            // search the left subarray
            else if (startingArray[middle] > search) {
                end = middle - 1;
            }
            //search the right subarray
            else {
                start = middle + 1;
            }
        }

        // if no element Found
        return 0;
    }
}