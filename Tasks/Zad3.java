package com.company;
import java.util.*;
public class Zad3 {
        public static int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            for (int row = 0; row < m; row++) {
                sortDiagonal(row, 0, mat);
            }

            for (int col = 1; col < n; col++) {
                sortDiagonal(0, col, mat);
            }
            return mat;
        }

        private static void sortDiagonal(int row, int col, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            Queue<Integer> diagonal = new PriorityQueue<>();
            int diagonalLength = Math.min(m - row, n - col);
            // Перемещает значения по этой диагонали
            for (int i = 0; i < diagonalLength; i++) {
                diagonal.add(mat[row + i][col + i]);
            }
            // Перемещает значения обратно в диагональ
            for (int i = 0; i < diagonalLength; i++) {
                mat[row + i][col + i] = diagonal.remove();
            }
        }

    public static void main (String[]args) {
            System.out.println("Исходная матрица: ");
            int[][] mat1 = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                System.out.print(mat1[i][j] + "\t");
            }
            System.out.println();
        }
        diagonalSort(mat1);
        System.out.println("Сортированная матрица: ");
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                System.out.print(mat1[i][j] + "\t");
            }
            System.out.println();
        }
        int [][] mat2 = {{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                System.out.print(mat2[i][j] + "\t");
            }
            System.out.println();
        }
        diagonalSort(mat2);
        System.out.println("Сортированная матрица: ");
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                System.out.print(mat2[i][j] + "\t");
            }
            System.out.println();
        }

        int n = 3;
        int m = 4;
        int min = 1;
        int max = 300;
        int[][] mat3 = new int[n][m];
        System.out.println("Исходная матрица: ");
        for (int i = 0; i < mat3.length; i++) {
            for (int j = 0; j < mat3[i].length; j++) {
                mat3[i][j] = (int) (Math.random() * ((max - min) + 1)) + min;
                System.out.print(mat3[i][j] + "\t");
            }
            System.out.println();
        }
        diagonalSort(mat3);
        System.out.println("Сортированная матрица: ");
        for (int i = 0; i < mat3.length; i++) {
            for (int j = 0; j < mat3[i].length; j++) {
                System.out.print(mat3[i][j] + "\t");
            }
            System.out.println();
        }




    }

}
