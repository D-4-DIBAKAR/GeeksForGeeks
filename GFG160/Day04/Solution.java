package GFG160.Day04;

// Rotate Array
public class Solution {
     // Function to rotate an array by d elements in counter-clockwise direction.

     // Optimized Approach
     static void rotateArr(int[] arr, int d) {
          int len = arr.length;
          d = d % len;
          if (d < 0) {
               d = d + len;
          }
          reverse(arr, 0, d - 1);// [4,5,3,2,1] -> [5,4,3,2,1]
          reverse(arr, d, len - 1);// [4,5,1,2,3]
          reverse(arr, 0, len - 1);// [3, 4, 5, 1, 2]

     }

     private static void reverse(int arr[], int start, int end) {
          while (start < end) {
               int temp = arr[start];
               arr[start] = arr[end];
               arr[end] = temp;
               start++;
               end--;
          }
     }
     // static void rotateArr(int[] arr, int d) {
     // int len = arr.length;
     // d = d % len;
     // if (d < 0) {
     // d = d + len;
     // }

     // for (int i = 0; i < d; i++) {
     // rotateONE(arr);
     // }
     // }

     // static void rotateONE(int[] arr) {
     // int temp = arr[0];
     // for (int i = 1; i < arr.length; i++) {
     // arr[i - 1] = arr[i];
     // }
     // arr[arr.length - 1] = temp;

     // }

     public void printArray(int arr[]) {
          for (int i : arr) {
               System.out.print(i + " ");
          }
          System.out.println();
     }

     public static void main(String[] args) {
          int arrOne[] = new int[] { 1, 2, 3, 4, 5 };// d=2
          int arrTwo[] = new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };// d=3
          int arrThree[] = new int[] { 7, 3, 9, 1 };// d=9
          Solution obj = new Solution();

          rotateArr(arrOne, 2);
          rotateArr(arrTwo, 3);
          rotateArr(arrThree, 9);

          obj.printArray(arrOne);
          obj.printArray(arrTwo);
          obj.printArray(arrThree);
     }
}
