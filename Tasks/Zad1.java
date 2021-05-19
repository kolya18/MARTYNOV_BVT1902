package com.company;
public class Zad1 {

    static void maxPerimeter(int arr[], int n)
    {
        int max = 0;

        for (int i = 0; i < n - 2; i++)
        {
            for (int j = i + 1; j < n - 1; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    int a = arr[i];
                    int b = arr[j];
                    int c = arr[k];
                    if (a < b+c && b < c+a && c < a+b)
                    {
                        max = Math.max(max, a+b+c);
                    }

                }
            }
        }

        if (max > 0)
            System.out.println( "Максимально возможный периметр: " + max);
        else

            System.out.println(0);
    }


    public static void main (String[]args) {
    int a1[] = {2,1,2};
    maxPerimeter(a1,3);
    int a2[] = {1,2,1};
    maxPerimeter(a2,3);
    int a3[] = {3,2,3,4};
    maxPerimeter(a3,4);
    int a4[] = {3,6,2,3};
    maxPerimeter(a4,4);

        int n = 5;
        int min = 1;
        int max = 100;
        int a[] = new int[n];
        System.out.println("Сгенерированный массив: ");
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * ((max - min) + 1)) + min;
            System.out.print(a[i]+" ");
        }
    System.out.println("\n");
    maxPerimeter(a,n);

    }

}
