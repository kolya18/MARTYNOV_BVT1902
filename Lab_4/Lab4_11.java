package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Lab4_11 {

    public static void main(String[] args){
        try {
            File myfile = new File("/Users/k18/Desktop/11.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line = null;
            String form = "";
            while ((line = reader.readLine()) != null) {
                form += line;
            }
            form = form.replaceAll("\\s+", "");
            System.out.println(form);
            Boolean str = Lab4_4.balancedParenthensies(form);
          if (str == true) {
                  Stack<Character> out = new Stack<>();
                  for (int i = 0; i < form.length(); i++) {
                   //   if ((form.charAt(i) == 'x') || (form.charAt(i) == '(') || (form.charAt(i) == 'y') || (form.charAt(i) == '{') || (form.charAt(i) == 'z') || (form.charAt(i) == '[') || (form.charAt(i) == '+') || (form.charAt(i) == '-')) {

                      if(((form.charAt(i) == 'x') || (form.charAt(i) == 'y') || (form.charAt(i) == 'z'))&&((form.charAt(i+1) == '(') || (form.charAt(i+1) == '[') || (form.charAt(i+1) == '{')))
                      {
                          out.push(form.charAt(i));
                      }
                      if ((form.charAt(i) == ')') || (form.charAt(i) == ']') || (form.charAt(i) == '}')) {
                          out.push(form.charAt(i));
                      }
                      if (form.charAt(i)==form.charAt(i+1))
                      {
                          break;
                      }
                      else {break;}
                  //    if(((form.charAt(i) == 'x') || (form.charAt(i) == 'y') || (form.charAt(i) == 'z'))&&((form.charAt(i+1) == '(') || (form.charAt(i+1) == '[') || (form.charAt(i+1) == '{')))
                    /*  if (form.charAt(i))
                      {

                      }*/
                  }
                  if (out.size() == form.length()) System.out.println("Запись правильная!");
                  else System.out.println("Запись неверна!");

           /* System.out.println(out.size());
            System.out.println(form.length());
            System.out.println(out);*/

          } else {System.out.println("Запись неверна!");}
            }
        catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }

    }


}
