package com.company;
import java.util.*;

public class Lab3 {

    //БВТ1902 Мартынов Николай 16 вариант

    public static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }

            prefixFunc[i] = j;
        }

        return prefixFunc;
    }

    public static List<Integer> KMPSearch(String text, String pattern) {
        int[] prefixFunc = prefixFunction(pattern);
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefixFunc[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }
            if (j == pattern.length()) {
                occurrences.add(i - j + 1);
                j = prefixFunc[j - 1];
            }
        }
        return occurrences;
    }

    public static int BMSearch(String T, String P)
    {
        int i = P.length() -1;
        int j = P.length() -1;
        do
        {
            if (P.charAt(j) == T.charAt(i))
            {
                if (j == 0)
                {
                    return i;
                }
                else
                {
                    i--;
                    j--;
                }
            }
            else
            {
                i = i + P.length() - min(j, 1+last(T.charAt(i), P));
                j = P.length()-1;
            }
        } while(i <= T.length()-1);

        return -1;
    }
    public static int last(char c, String P)
    {
        for (int i=P.length()-1; i>=0; i--)
        {
            if (P.charAt(i) == c)
            {
                return i;
            }
        }
        return -1;
    }
    public static int min(int a, int b)
    {
        if (a < b)
            return a;
        else if (b < a)
            return b;
        else
            return a;
    }









    public static void main (String[]args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str1 = scan.nextLine();
        System.out.println("Введите подстроку:");
        String str2 = scan.nextLine();

        long time1 = System.nanoTime();
        System.out.println("Поиск Кнута-Морриса-Пратта: "+KMPSearch(str1,str2)+" time: "+(System.nanoTime()-time1) +"ns");

        long time2 = System.nanoTime();
        System.out.println("Поиск упрощенный Бойера-Мура: "+BMSearch(str1,str2)+" time: "+(System.nanoTime()-time2) +"ns");

        long time3 = System.nanoTime();
        System.out.println("Стандартный поиск: "+str1.indexOf(str2)+" time: "+(System.nanoTime()-time3) +"ns");


    }
}
