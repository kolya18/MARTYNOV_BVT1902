package com.company;
import java.util.*;


public class puz {
    public static int slidingPuzzle(int[][] board) {
        // m * n version
        int m = board.length;
        int n = board[0].length;
        //build target string
        //1->A 2->B ...etc
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m * n - 1; i++){
            sb.append((char)(i+65));
        }
        sb.append("0");
        String target = sb.toString();


        //build start string
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0){
                    start += 0;
                }else {
                    start += (char)(board[i][j] +64);
                }
            }
        }

        HashSet<String> visited = new HashSet<>();
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        //BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int index = cur.indexOf('0');
                int x = index / n;
                int y = index % n;

                for (int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx <m && ny >= 0 && ny < n){
                        int indexToSwap = nx * n + ny;
                        String next = swap(cur, index, indexToSwap);
                        if (visited.contains(next)){
                            continue;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

  public static void main (String[]args) {
      int mat1[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {13, 9, 11, 12}, {10, 14, 15, 0}};
      slidingPuzzle(mat1);
      System.out.println("Шагов: "+slidingPuzzle(mat1));
          int mat2[][] = new int[][]{{5, 1, 2, 3}, {9, 6, 7, 4}, {13, 10, 11, 8}, {14, 15, 0, 12}};
      slidingPuzzle(mat2);
      System.out.println("Шагов: "+slidingPuzzle(mat2));

      //1 2 3 4 5 6 7 8 13 9 11 12 10 14 15 0
      //5 1 2 3 9 6 7 4 13 10 11 8 14 15 0 12
      //3 8 12 10 14 13 0 15 5 11 7 1 4 6 2 9
  }




}
