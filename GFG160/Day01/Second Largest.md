# Second Largest Element in an Array
**Problem  Statement:**
> Given an array of positive integers arr[] of size n, the task is to find second largest distinct element in the array.
Note: If the second largest element does not exist, return -1.

**Example**
> **Input:** arr[] = [12, 35, 1, 10, 34, 1]<br>
**Output:** 34<br>
**Explanation:** The largest element of the array is 35 and the second largest element is 34.

> **Input:** arr[] = [10, 5, 10]<br>
**Output:** 5<br>
**Explanation:** The largest element of the array is 10 and the second largest element is 5.

> **Input:** arr[] = [10, 10, 10]<br>
**Output:** -1<br>
**Explanation:** The largest element of the array is 10 there is no second largest element.

## Approach 01 [Naive Approach] Using Sorting - O(n*logn) Time and O(1) Space
> The idea is to sort the array in non-decreasing order. Now, we know that the largest element will be at index n - 1. So, starting from index (n - 2), traverse the remaining array in reverse order. As soon as we encounter an element which is not equal to the largest element, return it as the second largest element in the array. If all the elements are equal to the largest element, return -1.
``` Java
// Java program to find second largest element in an array
// using Sorting

import java.util.Arrays;

class GfG {
    
    // function to find the second largest element
    static int getSecondLargest(int[] arr) {
        int n = arr.length;
        
        // Sort the array in non-decreasing order
        Arrays.sort(arr);
        
        // start from second last element as last element is the largest
        for (int i = n - 2; i >= 0; i--) {
            
            // return the first element which is not equal to the 
            // largest element
            if (arr[i] != arr[n - 1]) {
                return arr[i];
            }
        }
        
        // If no second largest element was found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 35, 1, 10, 34, 1 };
        System.out.println(getSecondLargest(arr));
    }
}

```
## Information
> Time Complexity: O(n*logn), as sorting the array takes O(n*logn) time and traversing the array can take O(n) time in the worst case, so total time complexity = (n*logn + n) = O(n*logn).
Auxiliary space: O(1), as no extra space is required.

## Approach 02 [Better Approach] Two Pass Search - O(n) Time and O(1) Space
> The approach is to traverse the array twice. In the first traversal, find the maximum element. In the second traversal, find the maximum element ignoring the one we found in the first traversal.
## Working
<p align="center">
  <img src="https://github.com/user-attachments/assets/63bcc9c4-748e-4d76-9246-64e2704f642d" alt="output">
</p>

```java
// Java program to find the second largest element in the array
// using two traversals

import java.util.Arrays;

class GfG {

    // Function to find the second largest element in the array
    static int getSecondLargest(int[] arr) {
        int n = arr.length;

        int largest = -1, secondLargest = -1;

        // Finding the largest element
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest)
                largest = arr[i];
        }

        // Finding the second largest element
        for (int i = 0; i < n; i++) {
            
            // Update second largest if the current element is greater
            // than second largest and not equal to the largest
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(arr));
    }
}

```
## Information
> Time Complexity: O(2*n) = O(n), as we are traversing the array only once.<br>
Auxiliary space: O(1), as no extra space is required.

## Approach 03 [Expected Approach] One Pass Search - O(n) Time and O(1) Space
> The idea is to keep track of the largest and second largest element while traversing the array. Initialize largest and second largest with -1. Now, for any index i,
- If arr[i] > largest, update second largest with largest and largest with arr[i].
- Else If arr[i] < largest and arr[i] > second largest, update second largest with arr[i].

## Working
<p align="center">
  <img src="https://github.com/user-attachments/assets/1c3df59e-ac25-4035-95bc-ffa2232dfa3f" alt="output">
</p>

``` java
// Java program to find the second largest element in the array
// using one traversal

import java.util.Arrays;

class GfG {
    
    // function to find the second largest element in the array
    static int getSecondLargest(int[] arr) {
        int n = arr.length;

        int largest = -1, secondLargest = -1;

        // finding the second largest element
        for (int i = 0; i < n; i++) {

            // If arr[i] > largest, update second largest with
            // largest and largest with arr[i]
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
          
            // If arr[i] < largest and arr[i] > second largest, 
            // update second largest with arr[i]
            else if(arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(arr));
    }
}

```

## Information
> Time Complexity: O(n), as we are traversing the array only once.<br>
Auxiliary space: O(1)<br>
Related Article: Smallest and second smallest element in an array
