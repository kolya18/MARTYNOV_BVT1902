package com.company;
import java.util.*;
public class tasksStr2 {
    //БВТ1902 Мартынов Николай
    public static boolean checkStr(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        boolean aa = true;
        boolean bb = true;
        for (int i = 0; i < a.length && (aa || bb); i++) {
            if (a[i] < b[i]) aa = false;
            if (b[i] < a[i]) bb = false;
        }
        return aa || bb;
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int len = 0;
        boolean[][] Palindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int k = i; k < s.length(); k++) {
                if (s.charAt(i) == s.charAt(k) && (k - i < 2 || Palindrome[i + 1][k - 1])) {
                    Palindrome[i][k] = true;
                    if (k - i + 1 > len) {
                        result = s.substring(i, k + 1);
                        len = k - i + 1;
                    }
                }
            }
        }
        return result;
    }


    public static int notsubStr(String text) {
        char[] a = text.toCharArray();
        Set<String> result = new HashSet<>();
        for (int L = 0; L < a.length - 1; L++) {
            for (int R = L + 1; R < a.length; R++) {
                if (isNot(L, R, a)) {
                    String c = text.substring(L, R + 1);
                    result.add(c);
                }
            }
        }
        return result.size();
    }

    private static boolean isNot(int l, int r, char[] a) {
        if ((r - l) % 2 == 0) {
            return false;
        }
        int mid = l + (r - l) / 2 + 1;
        while (mid <= r) {
            if (a[l] != a[mid]) {
                return false;
            }
            mid++;
            l++;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("ЗАДАЧА 1 Перестановки строк");
        String s1 ="abc";
        String s2 = "xya";
        System.out.println(s1+"\n"+s2+"\n"+checkStr(s1,s2)+"\n");
        String s3 ="ayx";
        System.out.println(s2+"\n"+s3+"\n"+checkStr(s2,s3)+"\n");
        String s4="abe";
        String s5 = "acd";
        System.out.println(s4+"\n"+s5+"\n"+checkStr(s4,s5)+"\n");

        System.out.println("ЗАДАЧА 2 Самая длинная полиндромная подстрока");
        String st1 = "babad";
        System.out.println(st1+"\n"+longestPalindrome(st1)+"\n");
        String st2 ="cbbd";
        System.out.println(st2+"\n"+longestPalindrome(st2)+"\n");

        System.out.println("ЗАДАЧА 3 Непустые подстроки текста");
        String text1 = "abcabcabc";
        System.out.println(text1+"\n"+notsubStr(text1)+"\n");
        String text2 = "abcabcabcabcabcabc";
        System.out.println(text2+"\n"+notsubStr(text2)+"\n");
    }
}
