package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class Lab4_9 {
    public static boolean evaluateBool(String s)
    {
        Stack<Object> stack = new Stack<>();
        StringBuilder expression =new StringBuilder(s);
        expression.chars().forEach(ch->
        {
            if(ch=='F') stack.push(false);
            else if(ch=='T') stack.push(true);
            else if(ch=='A'||ch=='R'||ch=='X')
            {
                boolean op1 = (boolean) stack.pop();
                boolean op2 = (boolean) stack.pop();
                switch(ch)
                {
                    case 'A' : stack.push(op2&&op1); break;
                    case 'O' : stack.push(op2||op1); break;
                    case 'X' : stack.push(op2^op1); break;
                }//endSwitch
            }else
            if(ch=='N')
            {
                boolean op1 = (boolean) stack.pop();
                stack.push(!op1);
            }//endIF
        });
        return (boolean) stack.pop();
    }


    public static void main(String[] args)
    {
            try {
                File myfile = new File("/Users/k18/Desktop/logicFunc.txt");
                BufferedReader reader = new BufferedReader(new FileReader(myfile));
                String line=null;
                String progr = "";
                while ((line=reader.readLine())!=null)
                {
                    progr += line;
                }
                System.out.println(progr);
                 System.out.println(evaluateBool(progr));

                //System.out.println(logicalExpressionEvaluation(progr));




            }
            catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

    }

    //[N,[[0,A,[N,1]],O,[N,[[N,0],A,1]]]]
    //(F+(T*F+(F+T)))X(NT)
    //TRUE

    //XOR !=
    //AND *
    //OR +

    /*public static void main(String[] args)
    {
        String str = "[[0,&,1],|,[!,1]]";
        System.out.println(logicalExpressionEvaluation(str));

    }*/
}


