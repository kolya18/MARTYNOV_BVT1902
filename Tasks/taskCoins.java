package com.company;
import java.util.*;
public class taskCoins {
    //БВТ1902 Мартынов Николай
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i=piles.length-2;
        int k=0;
        int res=0;
        while(k++<piles.length/3)
        {
            res+=piles[i];
            i-=2;
        }
        return res;
    }
    public static void main(String[] args){
        int piles[] = {2,4,1,2,7,8};
        for (int i=0; i<piles.length; i++)
        {
            System.out.print(piles[i]+" ");
        }
        System.out.println("\n"+maxCoins(piles)+"\n");

        int piles1[] = {2,4,5};
        for (int i=0; i<piles1.length; i++)
        {
            System.out.print(piles1[i]+" ");
        }
        System.out.println("\n"+maxCoins(piles1)+"\n");

        int piles2[] = {9,8,7,6,5,1,2,3,4};
        for (int i=0; i<piles2.length; i++)
        {
            System.out.print(piles2[i]+" ");
        }
        System.out.println("\n"+maxCoins(piles2)+"\n");
    }
}
