package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class Lab4_4 {
    public static void main(String args[]) {
        try {
            File myfile = new File("/Users/k18/Desktop/testProg.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line=null;
            String progr = "";
            while ((line=reader.readLine())!=null)
            {
                progr = progr+line;
            }
            System.out.println(progr);
            System.out.println(balancedParenthensies(progr));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }



        /*
        System.out.println(balancedParenthensies("{(a,b)}"));
        System.out.println(balancedParenthensies("{(a},b)"));
        System.out.println(balancedParenthensies("{)(a,b}"));*/
    }

    public static boolean balancedParenthensies(String s) {
        Stack<Character> stack  = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '(' || c == '{' ) {
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if(c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
