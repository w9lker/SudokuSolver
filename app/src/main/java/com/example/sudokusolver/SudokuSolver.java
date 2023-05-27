package com.example.sudokusolver;

import java.util.Scanner;
import java.lang.Math;

class SudokuSolver{
    public static boolean isValid(int[][] gameboard)
    {

        //checking for rows
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                for(int k = j+1; k < 9; k++)
                {
                    if(gameboard[i][j] == gameboard[i][k] && gameboard[i][j] != 0)
                    {
                        System.out.println("Rows");
                        return false;
                    }
                }
            }
        }
        //checking for columns
        for(int j = 0; j < 9; j++)
        {
            for(int i = 0; i < 9; i++)
            {
                for(int k = i+1; k < 9; k++)
                {
                    if(gameboard[i][j] == gameboard[k][j] && gameboard[i][j]!= 0)
                    {
                        System.out.println("Columns");
                        return false;
                    }
                }
            }
        }
        //checking for 3 by 3 squares
        for(int m = 0; m < 3; m++)
        {
            for(int n = 0; n < 3; n++)
            {
                for(int i = 0; i < 3;i++)
                {
                    for(int j = 0; j < 3; j++)
                    {
                        for(int a = 0; a < 3; a++)
                        {
                            for(int b = 0; b < 3; b++)
                            {
                                if(gameboard[3*m + i][3*n + j] == gameboard[3*m +a][3*n + b] && gameboard[3*m+i][3*n+j] != 0 && (a!=i && b!=j))
                                {
                                    System.out.println("Squares");
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isSafe(int[][] gameboard, int row, int column, int entry)
    {
        // we assume that gameboard is solvable
        // then we only need to check whether new entry makes it unsolvable in respective row, column, 3 x 3 grid
        
        //checking row
        for(int i = 0; i < 9; i++)
        {
            if(gameboard[row][i] == entry)
            {
                return false;
            }
        }

        //checking column
        for(int i = 0; i < 9; i++)
        {
            if(gameboard[i][column] == entry)
            {
                return false;
            }
        }

        //checking 3 x 3 squares
        for(int i = (row -(row % 3)); i < (3 + (row -(row % 3))); i++)
        {
            for(int j = (column - (column % 3)); j < (3 + (column - (column % 3))); j++)
            {
                if(gameboard[i][j] == entry)
                {
                    return false;
                }
            }
        }
        return true;
    }



    //this method is a helper method that helps find the empty cell and returns whether the the gameboard has empty cells
    // true - there are emmpty cells left; false - no empty cell are left
    //data[0] represents a row, data[1] represents a column
    public static boolean hasEmpty(int[][] gameboard, int[] data)
    {
 
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(gameboard[i][j] == 0)
                {
                    data[0] = i;
                    data[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    //assume that initially board doesn't have any mistakes
    public static boolean solveSudoku(int gameboard[][])
    {
        int[] location = new int[2];
        if(hasEmpty(gameboard, location))
        {
            for(int i = 1; i < 10; i++)
            {
                if(isSafe(gameboard, location[0], location[1], i))
                {
                    gameboard[location[0]][location[1]] = i;
                    if(solveSudoku(gameboard))
                    {
                        return true;
                    }
                    else
                    {
                        gameboard[location[0]][location[1]] = 0;
                    }
                }
            }
        }
        else
        {
            return true;
        }
        return false;
    }

    //same as solveSudoku, but returns 2 if number of unique sollutions is more than 1, returns 1 and 0 if the number of solutions is 1 and 0 accordingly
    public static int uniqueSolutions(int[][] gameboard)
    {
        //to keep track of number of solutions
        int count = 0;
        int[] location = new int[2];
        if(hasEmpty(gameboard, location))
        {
            for(int i = 1; i < 10;i++)
            {
                if(isSafe(gameboard, location[0], location[1], i))
                {
                    gameboard[location[0]][location[1]] = i;
                    count += uniqueSolutions(gameboard);
                    if(count >= 2)
                    { 
                        return 2;
                    }
                    else if(count < 2)
                    {
                        gameboard[location[0]][location[1]] = 0;
                    }
                }
            }
        }
        else{
            return 1;
        } 
        return count;
    }

    public static void printBoard(int[][]gameboard)
    {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                System.out.print(gameboard[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    //takes input as a string consisting of integers 000000000000000000000000000000000000000000000000000000...0
    public static int[][] createBoard()
    {
        //initializing gameboard filled with 0's
        int[][] gameboard = new int[9][9];
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                gameboard[i][j] = (input.charAt(9*i + j) -'0');
            }
        }

        return gameboard;
    }

    public static boolean hasEmptyRandom(int[][] gameboard, int[] data)
    {
        //picking random number in a range 0 - 80
        int max = 80, min = 0;
        int count = 0;
        while(count < 1)
        {
            int random = (int)Math.floor(Math.random() * (max - min + 1) + min);
            if(gameboard[random / 9][random % 9] == 0)
            {
                data[0] = random / 9;
                data[1] = random % 9;
                return true;
            }
            count++;
        }

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(gameboard[i][j] == 0)
                {
                    data[0] = i;
                    data[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

//N is the number of missing entries in a Sudoku Board
    public static boolean RandomCompleteSudoku(int[][] gameboard)
    {
        //generating random valid board
        //using the alternative of SolveSudoku, where picking cells is randomized
        int[] location = new int[2];
        if(hasEmptyRandom(gameboard, location))
        {
            for(int i = 1; i < 10; i++){
                if(isSafe(gameboard, location[0], location[1], i))
                {
                    gameboard[location[0]][location[1]] = i;
                    if(RandomCompleteSudoku(gameboard))
                    {
                        return true;
                    }
                    else
                    {
                        gameboard[location[0]][location[1]] = 0;
                    }
                }
            }
        }
        else
        {
            return true;
        }
        return false;
    }

//N indicated the number of empty cells, it has to be less than 64
    public static void GenerateSudoku(int[][] gameboard, int N)
    {
        //generating the completed board first
        RandomCompleteSudoku(gameboard);
        if(isValid(gameboard))
        {
             putZeros(gameboard, N);
        }
    }
    //helper function
    public static boolean putZeros(int[][] gameboard, int N)
    {   int[] location = new int[2];
        int value;
        if(numofZeros(gameboard) == N){
            System.out.println("KJ");
            return true;
        }
        else{
            for(int i = 0; i < 5; i++)
            {
                if(!chooseCell(gameboard, location)){
                    return false;
                }
                else
                {
                    value = gameboard[location[0]][location[1]];
                    gameboard[location[0]][location[1]] = 0;
                    if(putZeros(gameboard, N))
                    {
                        return true;
                    }
                    else
                    {
                        //backtracking
                        gameboard[location[0]][location[1]] = value;
                    }
                }
            }
            

        }
        return false;

    }
    //helper function
    public static boolean chooseCell(int[][] gameboard, int[] location)
    {   
        //choose the random cell
        int random = (int)Math.floor(Math.random() * 81); 
        int row = random / 9, column = random % 9;
        int value = gameboard[row][column];
        gameboard[row][column] = 0;
        int unique = uniqueSolutions(gameboard);
        gameboard[row][column] = value;
        if(value == 0 || unique != 1 )
        {
            //choose the next non-empty cell which leads to unique solution
            for(int i = 0; i < 9; i++)
            {
               for(int j = 0; j < 9; j++)
                {
                    value = gameboard[i][j];
                    gameboard[i][j] = 0;
                    unique = uniqueSolutions(gameboard);
                    if(value != 0 &&  unique == 1)
                    {
                        location[0] = i;
                        location[1] = j;
                        return true;
                    }
                    gameboard[i][j] = value;
                }
            }
        }
        else{
            location[0] = row;
            location[1] = column;
            return true;
        }
        return false;
    }

    //returns the number of zeros
    public static int numofZeros(int[][] gameboard){
        int count = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(gameboard[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args)
    {
        int[][] gameboard = new int[][] 
        {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        int[][] gameboard_1 = gameboard.clone();
        for(int i = 0; i < 9; i++){
            gameboard_1[i] = gameboard[i].clone();
        }
        GenerateSudoku(gameboard_1,51);
        printBoard(gameboard_1);
    }

}