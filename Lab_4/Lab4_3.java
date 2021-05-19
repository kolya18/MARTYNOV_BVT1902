package com.company;
import java.util.*;
public class Lab4_3 {

    public static int N;
    public static Stack<Integer>[] tower = new Stack[4];
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        tower[1] = new Stack<Integer>();
        tower[2] = new Stack<Integer>();
        tower[3] = new Stack<Integer>();
        System.out.print("Дисков n=");
        int num = scan.nextInt();
        N = num;
        toh(num);
    }
    public static void toh(int n)
    {
        for (int d = n; d > 0; d--)
            tower[1].push(d);
        display();
        move(n, 1, 2, 3);
    }
    public static void move(int n, int a, int b, int c)
    {
        if (n > 0)
        {
            move(n-1, a, c, b);
            int d = tower[a].pop();
            tower[c].push(d);
            display();
            move(n-1, b, a, c);
        }
    }
    public static void display()
    {
        for(int i = N - 1; i >= 0; i--)
        {
            String d1 = " ", d2 = " ", d3 = " ";
            try
            {
                d1 = String.valueOf(tower[1].get(i));
            }
            catch (Exception e){
            }
            try
            {
                d2 = String.valueOf(tower[2].get(i));
            }
            catch(Exception e){
            }
            try
            {
                d3 = String.valueOf(tower[3].get(i));
            }
            catch (Exception e){
            }
            System.out.println(" "+d1+"   "+d2+"   "+d3);
        }
        System.out.println(" A   B   C");
        System.out.println("\n");
    }


    public static void moveRing(char a, char b, char c, int count) {

        if (count==1){
            System.out.println(String.format("Из %s в %s",a,b));
        }else {
            moveRing(a, c, b, count - 1);
            System.out.println(String.format("Из %s в %s",a,b));
            moveRing(c,b,a,count-1);
        }

    }


    static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod)

    {
        if (n == 1)
        {
            System.out.println("Сдвинуть диск 1 со стержня " +  from_rod + " на стержень " + to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod);
        System.out.println("Сдвинуть диск " + n + " со стержня " +  from_rod + " на стержень " + to_rod);
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod);

    }
}
