import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int numberNeeded(String first, String second) {
        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];

        for (char c : first.toCharArray()){
            // Subtract 'a' to get corresponding integer value, ie 'a' = 0 and 'z' = 26
        	firstFreq[c - 'a']++;
        } 
        for (char c : second.toCharArray()){
        	secondFreq[c - 'a']++;
        }

        int sum = 0;
        for(int i=0; i < 26; i++){
        	sum += Math.abs(firstFreq[i] - secondFreq[i])
        }
        return sum;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

