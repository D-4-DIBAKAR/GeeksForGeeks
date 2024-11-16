
package GFG160.Day01;
//Second Largest

public class Solution {

     public int getSecondLargest(int[] arr) {
          int first = Integer.MIN_VALUE;
          int second = Integer.MIN_VALUE;

          for (int num : arr) {
               if (num > first) {
                    second = first;
                    first = num;
               } else if (num > second && num < first) {
                    second = num;
               }
          }

          return second == Integer.MIN_VALUE ? -1 : second;
     }

     public static void main(String[] args) {
          int arrOne[] = new int[] { 12, 35, 1, 10, 34, 1 };
          int arrTwo[] = new int[] { 10, 5, 10 };
          int arrThree[] = new int[] { 10, 10, 10 };
          Solution obj = new Solution();

          System.out.println(obj.getSecondLargest(arrOne));
          System.out.println(obj.getSecondLargest(arrTwo));
          System.out.println(obj.getSecondLargest(arrThree));

     }
}