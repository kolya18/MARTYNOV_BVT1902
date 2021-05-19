package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Deque;
import java.util.LinkedList;
public class Lab4_5 {
    public static void main(String args[]) {
       /* try {
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
        }*/


        System.out.println(isBalanced("[[][]]"));
        System.out.println(isBalanced("[][]"));
        System.out.println(isBalanced("[][]["));

    }
    public static boolean isBalanced(String str) {
        if (null == str || ((str.length() % 2) != 0)) {
            return false;
        } else {
            char[] ch = str.toCharArray();
            for (char c : ch) {
                if (!(c == '{' || c == '[' || c == '(' || c == '}' || c == ']' || c == ')')) {
                    return false;
                }

            }
        }

        Deque<Character> deque = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty() && ((deque.peekFirst() == '{' && ch == '}') || (deque.peekFirst() == '[' && ch == ']') || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
