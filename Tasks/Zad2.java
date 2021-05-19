package com.company;
import java.util.*;
public class Zad2 {

    private static class LargNumComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String m1 = a + b;
            String m2 = b + a;
            return m2.compareTo(m1);
        }
    }
    public static String largNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new LargNumComparator());

        if (str[0].equals("0")) {
            return "0";
        }

        String number = new String();
        for (String nstr : str) {
            number += nstr;
        }
        return number;
    }

    public static void main (String[]args) {
        int nums1[] = {10,2};
        System.out.println(largNumber(nums1));
        int nums2[] = {3,30,34,5,9};
        System.out.println(largNumber(nums2));
        int nums3[] = {1};
        System.out.println(largNumber(nums3));
        int nums4[] = {10};
        System.out.println(largNumber(nums4));
        System.out.println("Сгенерированый массив");
        int n = 5000;
        int min = 1;
        int max = 100;
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = (int) (Math.random() * ((max - min) + 1)) + min;
            System.out.print(num[i]+" ");
        }
        long time = System.currentTimeMillis();
        System.out.println("\nЧисло: "+largNumber(num));
        System.out.println((System.currentTimeMillis()-time) +"ms");

        Scanner scan = new Scanner(System.in);
        System.out.println("Размерномть массива: ");
        int p = scan.nextInt();
        int arr[] = new int[p];
        System.out.println("Введите элемнты массива: ");
        for (int i = 0; i < p; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Исходный массив: ");
        for (int i = 0; i < p; i++) {
            System.out.print (" " + arr[i]);
        }
        System.out.println("\nРезультат: "+largNumber(arr));



    }

}
