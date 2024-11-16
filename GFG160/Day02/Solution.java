package GFG160.Day02;

//Move All Zeroes to End
public class Solution {
     void pushZerosToEnd(int[] arr) {
          // code here
          int length = arr.length;
          int count = 0;
          for (int i = 0; i < length; i++) {
               if (arr[i] != 0) {
                    arr[count++] = arr[i];
               }
          }
          while (count < length) {
               arr[count++] = 0;
          }
     }

     public void printArray(int arr[]) {
          for (int i : arr) {
               System.out.print(i + " ");
          }
          System.out.println();
     }

     public static void main(String[] args) {
          int arrOne[] = new int[] { 1, 2, 0, 4, 3, 0, 5, 0 };
          int arrTwo[] = new int[] { 10, 20, 30 };
          int arrThree[] = new int[] { 0, 0 };
          Solution obj = new Solution();

          obj.pushZerosToEnd(arrOne);
          obj.pushZerosToEnd(arrTwo);
          obj.pushZerosToEnd(arrThree);
          obj.printArray(arrOne);
          obj.printArray(arrTwo);
          obj.printArray(arrThree);
     }
}
