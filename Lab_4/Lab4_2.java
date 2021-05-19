package com.company;
import java.io.*;
public class Lab4_2 {
    private static DoublyLinkList alf = new DoublyLinkList();
    public static void main(String[] args) throws IOException {
              for(char i = '\u0430'; i <= '\u044f'; i++){
           alf.addTail(i);
        }


        System.out.println(alf);

        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/k18/Desktop/message.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("/Users/k18/Desktop/outMessage.txt")));
        int i = 0;
        while((i = reader.read()) != -1) {
            char ch = (char) i;
            writer.append(switchLetter(ch));
            writer.flush();
        }

        reader.close();
        writer.close();
    }



  private static char switchLetter(char ch) {
      char outchar = '0';
      char[] cc = alf.toChar().toCharArray();
      for(int i = 2; i < cc.length; i++) {
          char c = cc[i] ;
          if(Character.compare(c, ch) == 0) {
              outchar = cc[i-2];
              break;
          }
      }

      if(Character.compare(outchar, '0') == 0)
          outchar = ch;

      return outchar;
  }
}
