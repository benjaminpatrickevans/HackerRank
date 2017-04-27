import java.io.*;
import java.util.*;

public class Solution {

    public static int bubbleSort(int[] a, int n){
        int totalNumberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    numberOfSwaps++;
                    totalNumberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        return totalNumberOfSwaps;
    }
    
    public static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i=0; i<n; i++){
            input[i] = sc.nextInt();
        }

        int swaps = bubbleSort(input, n);

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + input[0]);
        System.out.println("Last Element: " + input[n - 1]);
    }
}