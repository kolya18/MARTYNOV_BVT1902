package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;



public class Lab4_10 {
    public static int i=0;

    public static int M(int a, int b){
        return Integer.max(a,b);
    }

    public static int N(int a, int b){
        return Integer.min(a,b);
    }

    public static int Numb(String str){
        int x = 0;
        while (true)
        {
            if (str.charAt(i)>='0'&& str.charAt(i)<='9')
            {
                x=(x*10)+str.charAt(i)-'0';
                ++i;
            }
            else
                return x;
        }
    }

    public static Stack<Integer> out = new Stack<>();
    public static int Cacl(String str)
    {
        int x,y;
        if(str.charAt(i)=='N'&&str.charAt(i+1)=='(')
        {
            i+=2;
            x=Cacl(str);
            ++i;
            y=Cacl(str);
            ++i;
            return out.push(N(x,y));
            // return N(x,y);
        }
        else if(str.charAt(i)=='M'&&str.charAt(i+1)=='(')
        {
            i+=2;
            x=Cacl(str);
            ++i;
            y=Cacl(str);
            ++i;
            return out.push(M(x,y));
            //return M(x,y);
        }
        else return out.push(Numb(str));
        //else return Numb(str);
    }
//M(N(M(3,N(9,N(3,4))),6),1),0)
//M(N(7,4),N(3,6))
    public static void main(String[] args)
    {
        try {
            File myfile = new File("/Users/k18/Desktop/10.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line=null;
            String progr = "";
            while ((line=reader.readLine())!=null)
            {
                progr += line;
            }
            System.out.println(progr);
            Cacl(progr);
            System.out.println(out.peek());
         //   System.out.println(Cacl(progr));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
