# Sorting-and-Searchng-project WIP

## 📘 Project Overview
This project is part of **CSCI 4520 – Analysis of Algorithms** and demonstrates the implementation and efficiency analysis of two fundamental algorithms: **Merge Sort** and **Binary Search**.

The goal is to:
1. Generate 100,000 random positive numbers.
2. Search for the number `53` using **Sequential Search**.
3. Count the total occurrences of `53`.
4. Sort the array using **Merge Sort**.
5. Repeat the search using **Binary Search** on the sorted data.
6. Compare and analyze the execution times.

---

## 🧠 Algorithms Used
### 🔹 Sequential Search (Linear Search)

Used to:
- Find the **first occurrence** of `53` in the unsorted array.
- Count all occurrences of `53` by scanning the entire array.

**Time Complexity:**
- Best case: Θ(1)
- Worst / Average case: **Θ(n)**
---
### 🔹 Merge Sort
Used to sort the array after the initial sequential search and counting.

Key idea:
- **Divide and conquer** – recursively split the array into halves, sort each half, and merge them.
- **Time Complexity:** Θ(n log n)  
- **Space Complexity:** Θ(n)
---
### 🔹 Binary Search
After sorting, the program calls `binarySearch(int[] startingArray, int search)`:

1. Uses standard **binary search** to locate any occurrence of the search value (53).
2. Once found:
   - Scans left while the value is still 53.
   - Scans right while the value is still 53.
   - Counts all occurrences and returns the total number.

**Time Complexity:**  
- Binary search part: Θ(log n)  
- Left/right scan: Θ(k), where k is the number of repeats  
- Overall: **Θ(log n + k)**


---

## ⚙️ Program Workflow
1. Generate 100,000 random integers between 0 and 125.  
2. Search for `53` using Sequential Search.  
3. Count all occurrences of `53`.  
4. Sort the array using Merge Sort.  
5. Search again using Binary Search.  
6. Record and display timing results for each operation.
