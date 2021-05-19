package com.company;
import java.io.*;
import java.util.*;

public class Lab4 {

    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String[]args) {
        DoublyLinkList books = new DoublyLinkList();
        List<String> list = new ArrayList();
        try {
            File myfile = new File("/Users/k18/Desktop/books.txt");
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line=null;
            while ((line=reader.readLine())!=null)
            {
                books.addHead(line);
                list.add(line);
            }

        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println(books);
        Collections.sort(list);

        String fileName = "/Users/k18/Desktop/books_out.txt";

        DoublyLinkList books2 = new DoublyLinkList();
        for (int i = 0; i < list.size(); i++) {
            books2.addTail(list.get(i));
        }
        System.out.println(books2);
        write(fileName,books2.toString());
    }




}
