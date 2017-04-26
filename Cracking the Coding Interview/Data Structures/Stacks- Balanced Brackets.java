import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isBalanced(String expression) {
        if (expression.length() % 2 != 0) return false;
        char[] brackets = expression.toCharArray();
        Map<Character, Character> matches = new HashMap<Character,Character>(); 
        matches.put('{', '}');
        matches.put('(', ')');
        matches.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (char bracket : brackets){
            // Opening bracket
            if(matches.containsKey(bracket)){
                // Add corresponding closing bracket to stack
                stack.push(matches.get(bracket));
            }
            // Closing bracket
            else if (stack.isEmpty() || bracket != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}


