package com.company;
import java.util.*;

//БВТ1902 Мартынов Николай 16 вариант

public class Main {

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    static void heapify(int[] array, int length, int i) {
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;

        // если левый дочерний больше родительского
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // если правый дочерний больше родительского
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // если должна произойти замена
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) return;

        // Строим кучу
        int length = array.length;
        // проходим от первого без ответвлений к корню
        for (int i = length / 2-1; i >= 0; i--)
            heapify(array, length, i);

        for (int i = length-1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }




    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello, world!");

        int m,n,min_limit,max_limit;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите m");
        m = scan.nextInt();
        System.out.println("Введите n");
        n = scan.nextInt();
        System.out.println("Введите min_limit");
        min_limit = scan.nextInt();
        System.out.println("Введите max_limit");
        max_limit = scan.nextInt()+16;

       // int m = 50;
       // int n = 50;
       // int min_limit = -250;
       // int max_limit = 1000+16;


        int[][] a = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
               // a[i][j] = min_limit + (int) (Math.random()*(max_limit-min_limit+1));   }
                a[i][j] = (int) (Math.random() * ((max_limit - min_limit) + 1)) + min_limit ; }
        }
        System.out.println("Матрица :");
        for(int i = 0; i< a.length; i++){
            for(int j = 0;j<a[i].length; j++){
                System.out.print(a[i][j]+ "  ");
            }
            System.out.print("\n");}


        System.out.println("Сортировка Выбором :");
        for(int i = 0; i<a.length; i++){//Перебираем массив
            for(int j = 0; j<a[i].length; j++){//Перебираем массив
                for (int s = 0; s<a[i].length; s++){//Перебираем строку
                    int pos = s;
                    int min = a[i][s];
                    // цикл выбора наименьшего элемента
                    for (int z = a[i].length-1; z>s; z--){//Перебираем строку
                        if (a[i][z] < min) {
                            pos = z;    // pos - индекс наименьшего элемента
                            min = a[i][z];
                        }
                    }
                    a[i][pos] = a[i][s];
                    a[i][s] = min;
                }
            }
        }
        for(int i1 = 0; i1<a.length; i1++){
            for(int j = 0;j<a[i1].length; j++){
                System.out.print(a[i1][j]+ "  ");
            }
            System.out.print("\n");}

        System.out.println("Сортировка Вставкой :");
        for(int i = 0; i<a.length; i++){//Перебираем массив
            for(int j = 0; j<a[i].length; j++){//Перебираем массив
                for (int s = 0; s<a[i].length; s++){//Перебираем строку
                    int current = a[i][s];
                    int z = s - 1;
                    while(z >= 0 && current < a[i][z]) {
                        a[i][z+1] = a[i][z];
                        j--;
                    }
                    // выход j так же -1
                    // или в первом элементе, где текущий >= a[j]
                    a[i][z+1] = current;
                }
            }
        }
        for(int i1 = 0; i1<a.length; i1++){
            for(int j = 0;j<a[i1].length; j++){
                System.out.print(a[i1][j]+ "  ");
            }
            System.out.print("\n");}

        System.out.println("Сортировка Обменом :");
       boolean sorted = false;
        int temp;
        for(int i = 0; i<a.length; i++){//Перебираем массив
            for(int j = 0; j<a[i].length; j++){//Перебираем массив
                    while(!sorted){
                        sorted = true;
                        for (int s = 0; s <a[i].length -1; s++)
                        {
                            if (a[i][s] > a[i][s+1])
                            {
                                temp = a[i][s];
                                a[i][s] = a[i][s+1];
                                a[i][s+1] = temp;
                                sorted = false;
                            }
                        }

                    }
                }
            }
            for(int i1 = 0; i1< a.length; i1++){
            for(int j = 0;j<a[i1].length; j++){
                System.out.print(a[i1][j]+ "  ");
            }
            System.out.print("\n");}

        System.out.println("Сортировка Шелла :");
        int temp1;
        int h = 0;//величина интервала
        //вычисляем исходное значение интервала
        while(h <= a.length/3)
            h = 3*h + 1;

        for(int i = 0; i<a.length; i++){//Перебираем массив
            for(int j = 0; j<a[i].length; j++){//Перебираем массив
               for (int k=h; k >0; k=(k-1)/3)
                for (int s = k; s < a[i].length; s++){//Перебираем строку
                    temp1 = a[i][s];
                    int z;
                    for (z=s;z >=k; z -=k){
                        if (temp1 < a[i][z-k])
                            a[i][z]=a[i][z-k];
                        else
                            break;
                    }
                    a[i][z] = temp1;
                }
            }
        }

        for(int i1 = 0; i1< a.length; i1++){
            for(int j = 0;j<a[i1].length; j++){
                System.out.print(a[i1][j]+ "  ");
            }
            System.out.print("\n");}

        System.out.println("Быстрая сортировка:");
        for(int i = 0; i<a.length; i++){//Перебираем массив
            for(int j = 0; j<a[i].length; j++){//Перебираем массив
                for (int s = 0; s<a[i].length; s++){//Перебираем строку
                  int low = 0;
                  int high = a[i].length-1;
                    // цикл выбора наименьшего элемента
                    for (int z = a[i].length-1; z>s; z--){//Перебираем строку
                     quickSort(a[i],low,high);
                    }

                }
            }
        }
        for(int i1 = 0; i1<a.length; i1++){
            for(int j = 0;j<a[i1].length; j++){
                System.out.print(a[i1][j]+ "  ");
            }
            System.out.print("\n");}


        System.out.println("Пирамидальная сортировка:");
        for(int i = 0; i<a.length; i++){//Перебираем массив
            for(int j = 0; j<a[i].length; j++){//Перебираем массив
                for (int s = 0; s<a[i].length; s++){//Перебираем строку
                    for (int z = a[i].length-1; z>s; z--){//Перебираем строку
                        heapSort(a[i]);
                    }

                }
            }
        }
        for(int i1 = 0; i1<a.length; i1++){
            for(int j = 0;j<a[i1].length; j++){
                System.out.print(a[i1][j]+ "  ");
            }
            System.out.print("\n");}






    }
}
