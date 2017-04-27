import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
In my opinion this was a stupid question, 
using binary search to solve seems really weird but thats
what the question wanted so the answr is given below
*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            Icecream[] icecreams = new Icecream[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                icecreams[a_i] = new Icecream(a_i+1, a[a_i]);
            }

            // Binary search only works if sorted
            Arrays.sort(icecreams);
            search(n, m, icecreams);
            
        }
    }
    
    private static void search(int n, int m, Icecream[] icecreams){
        for(int i=0; i < n; i++){
                Icecream icecream = icecreams[i];
                // Number to search for
                int goalCost = m - icecream.cost;
                int match = binarySearch(goalCost, icecream.index, icecreams);
                if(match != -1){
                    // Success
                    System.out.println(Math.min(icecream.index, match) + " " + Math.max(icecream.index, match));
                    return;
                }
            }
    }

    public static int binarySearch(int goal, int exclude, Icecream[] icecreams) {
        int low = 0;
        int high = icecreams.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (goal < icecreams[mid].cost) high = mid - 1;
            else if (goal > icecreams[mid].cost) low = mid + 1;
            else if (icecreams[mid].index == exclude) low++;
            else return icecreams[mid].index;    
        }
        return -1;
    }

    
}

class Icecream implements Comparable<Icecream> {
    int index;
    int cost;

    public Icecream(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    public int compareTo(Icecream other){
        return cost - other.cost;
    }
}


