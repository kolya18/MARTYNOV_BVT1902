package com.company;
import java.io.*;
import java.util.Stack;

public class Lab4_6 {

    public static void main(String args[]) {
        Stack<String> strOut  = new Stack<String>();
        try {
            File myfile = new File("/Users/k18/Desktop/6.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line=null;
            String progr = "";
            while ((line=reader.readLine())!=null)
            {
                progr = progr+line;
            }
            System.out.println(progr);

            String[] parts = progr.split("[^0-9]");
            String[] parts2 = progr.split("[^a-zA-z]");
            String[] parts3 = progr.split("[^&\\/\\\\#,+()$~%.'\":*?<>{}]");

            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].equals("")) {
                    strOut.addElement(parts[i]);
                }
            }
            for (int i = 0; i < parts2.length; i++) {
                if (!parts2[i].equals("")) {
                    strOut.addElement(parts2[i]);
                }
            }
            for (int i = 0; i < parts3.length; i++) {
                if (!parts3[i].equals("")) {
                    strOut.addElement(parts3[i]);
                }
            }

            System.out.println(strOut);

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }


    }

}
