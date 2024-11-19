package GFG160.Day05;

//Next Permutation
class Solution {
     void nextPermutation(int[] arr) {
          int n = arr.length;
          int i = n - 2, j = n - 1;

          while (i >= 0 && arr[i] >= arr[i + 1])
               i--;

          if (i >= 0) {
               while (arr[j] <= arr[i])
                    j--;

               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
          }

          reverse(arr, i + 1, n - 1);
     }

     void reverse(int[] arr, int start, int end) {
          while (start < end) {
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
          int arrOne[] = new int[] { 2, 4, 1, 7, 5, 0 };
          int arrTwo[] = new int[] { 3, 2, 1 };
          int arrThree[] = new int[] { 3, 4, 2, 5, 1 };
          Solution obj = new Solution();

          obj.nextPermutation(arrOne);
          obj.nextPermutation(arrTwo);
          obj.nextPermutation(arrThree);

          obj.printArray(arrOne);
          obj.printArray(arrTwo);
          obj.printArray(arrThree);
     }

}
