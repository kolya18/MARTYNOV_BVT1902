package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;
public class Lab4_8 {
    public static String reverse(String str)
    {
        if (str == null || str.equals("")) {
            return str;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(ch[i]);
        }
        int k = 0;
        while (!stack.isEmpty())
        {
            ch[k++] = stack.pop();
        }
        return String.copyValueOf(ch);
    }

    public static void main(String[] args)
    {
        try {
            File myfile = new File("/Users/k18/Desktop/textReverse.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line=null;
            String progr = "";
            while ((line=reader.readLine())!=null)
            {
                progr = progr+line;
            }
            System.out.println(progr);
            System.out.println(reverse(progr));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}
