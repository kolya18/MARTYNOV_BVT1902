package com.company;

import java.util.*;

public  class puzzleSolver {
    private static class node{
        int level = 0;
        int [][] state = new int [4][4];
        int blankRow;
        int blankCol;
        String move = "";
        node parent = null;
        node up = null;
        node down = null;
        node left = null;
        node right = null;
    }

    private static class solutionData {
        node solutionNode = null;
        String path = "";
        String startingBoard = "";
    }

    public static void main(String [] args){
        if(args.length <= 0){
            System.out.println("Пазла не было");
            return;
        }
        else if(args.length != 16){
            System.out.println("Пазл содержит неправильное количество цифр");
            return;
        }


        System.gc();
        System.out.println("\nАлгоритм A*:");
        try{
            String board = "";
            node root = new node();
            root.move = "Start";
            for (int i =0; i < 4; i++) {
                board = board + "\n";
                for (int q = 0; q < 4; q++) {
                    root.state[i][q] = Integer.parseInt(args[4*i + q]);
                    board = board + root.state[i][q] + "\t";
                    if(root.state[i][q] == 0){
                        root.blankRow = i;
                        root.blankCol = q;
                    }

                }
            }
            solutionData solution = aStarH1(root, board);
            if(solution != null)
                printSolutionData(solution);
            else
                System.out.println("Решений не найдено");
        }catch(OutOfMemoryError e){
            System.out.println("Решений не найдено");
        }

    }

     public static solutionData aStarH1(node root, String board){
        ArrayList<node> unexpandedNodes = new ArrayList<node>();
        unexpandedNodes.add(root);

        solutionData breadthSolution = new solutionData();
        int expandedNodes = 0;
        node cur = null;
        while(expandedNodes < Integer.MAX_VALUE){
            // получить узел с наименьшим результатом f(n) = g(n) + h(n)
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < unexpandedNodes.size() ; i++) {
                node tmp = unexpandedNodes.get(i);
                if(getMissplacedTiles(tmp) + tmp.level < minVal){
                    minVal = getMissplacedTiles(tmp) + tmp.level;
                    cur = tmp;
                }
            }
            unexpandedNodes.remove(cur);

            if (getMissplacedTiles(cur) == 0){
                breadthSolution.solutionNode = cur;
                breadthSolution.startingBoard = board;
                breadthSolution.path = getPath(cur);
                return breadthSolution;
            }
            else{
                evaluateChildren(cur);
                expandedNodes++;

                if(cur.left != null)
                    unexpandedNodes.add(cur.left);
                if(cur.right != null)
                    unexpandedNodes.add(cur.right);
                if(cur.up != null)
                    unexpandedNodes.add(cur.up);
                if(cur.down != null)
                    unexpandedNodes.add(cur.down);
            }
        }
        return null;
    }



     public static void evaluateChildren(node curNode){
        if(curNode.blankCol > 0){
            curNode.left = new node();
            curNode.left.move = "L";
            curNode.left.level = curNode.level + 1;
            curNode.left.blankCol = curNode.blankCol - 1;
            curNode.left.blankRow = curNode.blankRow;
            curNode.left.parent = curNode;
            curNode.left.state = makeState(curNode.state, curNode.blankRow, curNode.blankCol, 'L');
        }
        if(curNode.blankCol < 3){
            curNode.right = new node();
            curNode.right.move = "R";
            curNode.right.level = curNode.level + 1;
            curNode.right.blankCol = curNode.blankCol + 1;
            curNode.right.blankRow = curNode.blankRow;
            curNode.right.parent = curNode;
            curNode.right.state = makeState(curNode.state, curNode.blankRow, curNode.blankCol, 'R');

        }
        if(curNode.blankRow > 0){
            curNode.up = new node();
            curNode.up.move = "U";
            curNode.up.level = curNode.level + 1;
            curNode.up.blankCol = curNode.blankCol;
            curNode.up.blankRow = curNode.blankRow - 1;
            curNode.up.parent = curNode;
            curNode.up.state = makeState(curNode.state, curNode.blankRow, curNode.blankCol, 'U');

        }
        if(curNode.blankRow < 3){
            curNode.down = new node();
            curNode.down.move = "D";
            curNode.down.level = curNode.level + 1;
            curNode.down.blankCol = curNode.blankCol;
            curNode.down.blankRow = curNode.blankRow + 1;
            curNode.down.parent = curNode;
            curNode.down.state = makeState(curNode.state, curNode.blankRow, curNode.blankCol, 'D');
        }
    }

    // возвращает новую матрицу
    public static int[][] makeState(int[][] curState, int blankY, int blankX, char move){
        int [][] newState = new int [4][];
        for(int i = 0; i < 4; i++)
            newState[i] = curState[i].clone();

        if(move == 'U'){
            newState[blankY][blankX] = newState[blankY - 1][blankX];
            newState[blankY - 1][blankX] = 0;
        }
        else if(move == 'D'){
            newState[blankY][blankX] = newState[blankY + 1][blankX];
            newState[blankY + 1][blankX] = 0;
        }
        else if(move == 'L'){
            newState[blankY][blankX] = newState[blankY][blankX - 1];
            newState[blankY][blankX - 1] = 0;
        }
        else{
            newState[blankY][blankX] = newState[blankY][blankX + 1];
            newState[blankY][blankX + 1] = 0;
        }
        return newState;
    }

    //сравнивает состояние цели и текущее состояние и возвращает количество пропущенных ячеек
    public static int getMissplacedTiles(node curNode){
        int [][] goalState = {{1,2,3,4},{5,6,7,8},{9, 10,11,12},{13,14,15,0}};
        int tileCounter = 0;
        for (int row = 0; row<4; row++){
            for (int col = 0; col < 4; col++){
                if(goalState[row][col] != curNode.state[row][col])
                    tileCounter++;
            }
        }
        return tileCounter;
    }

    //возвращает строку, которая показывает путь, который нужно пройти, чтобы решить пазл
    public static String getPath(node solution){
        LinkedList<node> solutionPath = new LinkedList<node>();
        node cur = solution;
        String path = "";
        while(cur != null){
            solutionPath.addFirst(cur);
            cur = cur.parent;
        }
        while(!solutionPath.isEmpty()){
            node tmp = solutionPath.removeFirst();
            if(tmp.move != "Start")
                path = path + tmp.move;
        }
        return path;
    }

   public static void printSolutionData(solutionData solution){
       //1 2 3 4 5 6 7 8 13 9 11 12 10 14 15 0
       //5 1 2 3 9 6 7 4 13 10 11 8 14 15 0 12

        System.out.println(solution.startingBoard + "\n\nДействий:" + solution.path.length() + "\nШаги:" + solution.path);
    }

}
