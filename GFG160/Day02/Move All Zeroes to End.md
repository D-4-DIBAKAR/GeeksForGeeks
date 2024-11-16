# Move all zeros to end of array

**Problem Statement:**

> Given an array of integers arr[], the task is to move all the zeros to the end of the array while maintaining the relative order of all non-zero elements.

**Example**

> **Input:** arr[] = [1, 2, 0, 4, 3, 0, 5, 0]<br> > **Output:** [1, 2, 4, 3, 5, 0, 0, 0]<br> > **Explanation:** There are three 0s that are moved to the end.

> **Input:** arr[] = [10, 20, 30]<br> > **Output:** [10, 20, 30]<br> > **Explanation:** No change in array as there are no 0s.

> **Input:** arr[] = [0, 0]<br> > **Output:** [0, 0]<br> > **Explanation:** No change in array as there are all 0s.

## Approach 01 [Naive Approach] Using Temporary Array - O(n) Time and O(n) Space

> The idea is to create a temporary array of same size as the input array arr[].
>
> - First, copy all non-zero elements from arr[] to the temporary array.
> - Then, fill all the remaining positions in temporary array with 0.
> - Finally, copy all the elements from temporary array to arr[].

## Working:

<p align="center">
  <img src="https://github.com/user-attachments/assets/95fa8710-328c-46ac-b761-853e69e28313" alt="output">
</p>

```java
// Java Program to move all zeros to end using temporary array

import java.util.Arrays;

class GfG {

    // function to move all zeros to the end
    static void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        // to keep track of the index in temp[]
        int j = 0;

        // Copy non-zero elements to temp[]
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0)
                temp[j++] = arr[i];
        }

        // Fill remaining positions in temp[] with zeros
        while (j < n)
            temp[j++] = 0;

        // Copy all the elements from temp[] to arr[]
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);

        // Print the modified array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

```

## Information

> Time complexity: O(n), as we are traversing the array three times.<br>
> Auxiliary Space : O(n), as we are using a temp[] array to move all the zeros.

## Approach 02 [Better Approach] Two Traversals - O(n) Time and O(1) Space

> The idea is to move all the zeros by traversing the array twice.
> **First Traversal: Shift non-zero elements**
>
> - Traverse the array and maintain the count of non-zero elements. This count is initialized with 0 and keeps track of where the next non-zero element should be placed in the array.
> - If the element is non-zero, place it at arr[count] and increment count by 1.
> - After traversing all the elements, all non-zero elements will be shifted to the front while maintaining their original order.
>   **Second Traversal: Fill remaining positions with zeros**
> - After the first traversal, all non-zero elements will be at the start of the array and count will store the index where the first zero should be placed.
> - Iterate from count to the end of array and fill all indices with 0.

## Working:

<p align="center">
  <img src="https://github.com/user-attachments/assets/d0afda2b-a2ec-4d6e-94e0-fc25ec4e52f4" alt="output">
</p>

```java
// Java Program to move all zeros to end using two traversals

class GfG {

    // Function which pushes all zeros to end of an array
    static void pushZerosToEnd(int[] arr) {

        // Count of non-zero elements
        int count = 0;

        // If the element is non-zero, replace the element at
        // index 'count' with this element and increment count
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }

        // Now all non-zero elements have been shifted to
        // the front. Make all elements 0 from count to end.
        while (count < arr.length)
            arr[count++] = 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

```

## Information

> Time Complexity: O(n), as we are traversing the array only twice.<br>
> Auxiliary Space: O(1)

## Approach 03 [Expected Approach] One Traversal - O(n) Time and O(1) Space

> The idea is similar to the previous approach where we took a pointer, say count to track where the next non-zero element should be placed.
> However, on encountering a non-zero element, instead of directly placing the non-zero element at arr[count],
> we will swap the non-zero element with arr[count]. This will ensure that if there is any zero present at arr[count],
> it is pushed towards the end of array and is not overwritten.

## Working:

<p align="center">
  <img src="https://github.com/user-attachments/assets/288f03be-6366-4aff-b813-361068b9dabf" alt="output">
</p>

```java
// Java Program to move all zeros to end using one traversal

import java.util.Arrays;

class GfG {

    // Function which pushes all zeros to end of array
    static void pushZerosToEnd(int[] arr) {

        // Pointer to track the position for next non-zero element
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // If the current element is non-zero
            if (arr[i] != 0) {
                //1, 2, 0, 4, 3, 0, 5, 0
                // Swap the current element with the 0 at index 'count'
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

                // Move 'count' pointer to the next position
                count++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

```

## Information

> Time Complexity: O(n), as we are traversing the array only once.<br>
> Auxiliary Space: O(1).
