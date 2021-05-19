package com.company;
import java.util.*;

public class Zad4 {

    public static int arrowsFind(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowCount = 0;
        long end = Long.MIN_VALUE;
        for (int [] p: points) {
           if (p[0] > end) {
                end = p[1];
                arrowCount += 1;
            }
        }
        return arrowCount;
    }

    public static void main (String[]args) {
        int [][] points1 = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(arrowsFind(points1));
        int [][] points2 = {{1,2},{3,4},{5,6},{7,8}};
        System.out.println(arrowsFind(points2));
        int [][] points3 = {{1,2},{2,3},{3,4},{4,5}};
        System.out.println(arrowsFind(points3));
        int [][] points4 = {{1,2}};
        System.out.println(arrowsFind(points4));
        int [][] points5 = {{2,3},{2,3}};
        System.out.println(arrowsFind(points5));

    }
}
