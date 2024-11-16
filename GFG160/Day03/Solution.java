package GFG160.Day03;

// Reverse an Array
public class Solution {
     public void reverseArray(int arr[]) {
          // code here
          if (arr.length < 2) {
               return;
          }
          int start = 0;
          int end = arr.length - 1;
          while (start < arr.length / 2) {
               int temp = arr[start];
               arr[start] = arr[end];
               arr[end] = temp;
               start++;
               end--;
          }
     }

     public void printArray(int arr[]) {
          for (int i : arr) {
               System.out.print(i + " ");
          }
          System.out.println();
     }

     public static void main(String[] args) {
          int arrOne[] = new int[] { 1, 4, 3, 2, 6, 5 };
          int arrTwo[] = new int[] { 4, 5, 2 };
          int arrThree[] = new int[] { 1 };
          Solution obj = new Solution();

          obj.reverseArray(arrOne);
          obj.reverseArray(arrTwo);
          obj.reverseArray(arrThree);

          obj.printArray(arrOne);
          obj.printArray(arrTwo);
          obj.printArray(arrThree);
     }
}