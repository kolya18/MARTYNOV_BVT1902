package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Lab4_7 {

    static void RearrangePosNeg(int arr[], int n)
    {
        int key, j;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            if (key > 0)
                continue;
            j = i - 1;
            while (j >= 0 && arr[j] > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        DoublyLinkList strOut = new DoublyLinkList();
        try {
            File myfile = new File("/Users/k18/Desktop/7.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line=null;
            String progr = "";
            while ((line=reader.readLine())!=null)
            {
                progr = progr+line;
            }
            System.out.println(progr);

            String[] parts = progr.split("[^0-9-]+");

            int arr[] = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                if (!parts[i].equals("")) {
                    arr[i] = Integer.parseInt(parts[i]);
                }
            }
            RearrangePosNeg(arr,arr.length);
            for (int i = 1; i < arr.length; i++) {
               strOut.addTail(arr[i]);
            }
            System.out.println(strOut);


        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }





    }

}
