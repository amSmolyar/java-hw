package javaBasics.SeaBattle;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.StrictMath.random;

public class SeaBattle {
    public static final int SIZE = 10 ;
    public static final int NSHIP = 10 ;

    public static final int ITERATION = 30 ;

    public static final int EMPTY = 0;
    public static final int SHIP = 1;
    public static final int DEAD = 2;
    public static final int MISS = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        String dataIn = "" ;

        System.out.println("\nHello!") ;

        // Поле боя в виде двумерного массива:
        int[][] field = createWarField(SIZE, NSHIP) ;
        //Для отладки:
        /*
        showArray(field) ;
        System.out.println();
        */

        // Поле игрока:
        int[][] userField = createWarField(SIZE, 0) ;
        showArray(userField) ;

        int ii = 0 ;
        int cntDeadShips = 0 ;
        while (ii < ITERATION) {
            System.out.println("\nWrite coordinates for arrack in '<>:<>' format (" + (ITERATION - ii) + " iterations left):");
            dataIn = scan.nextLine();
            if (dataIn.matches("(\\s*)(\\d{1,2})(:)(\\d{1,2})(\\s*)")) {
                dataIn = dataIn.trim() ;
                String[] arrayIn = dataIn.split(":") ;
                int row = Integer.parseInt(arrayIn[0]) - 1 ;
                int col = Integer.parseInt(arrayIn[1]) - 1 ;

                if ((row >= SIZE) || (row < 0) || (col >= SIZE) || (col < 0)) {
                    System.out.println("Try again!") ;
                    continue ;
                }

                if (userField[row][col] != EMPTY)
                    System.out.println("\nThis field is already checked!") ;
                else if (field[row][col] == SHIP) {
                    userField[row][col] = DEAD ;
                    ii++ ;
                    cntDeadShips++ ;
                    System.out.println("\nShip destroyed!") ;
                }
                else {
                    userField[row][col] = MISS ;
                    ii++ ;
                    System.out.println("\nMiss!") ;
                }
                System.out.println((NSHIP - cntDeadShips) + " ships left!\n") ;

                showArray(userField) ;

                // Победа:
                if (cntDeadShips == NSHIP) {
                    System.out.println("You are win!") ;
                    break ;
                }
                // Попытки закончились:
                if (ii == ITERATION)
                    System.out.println("You are lost!") ;

            } else
                System.out.println("Try again!") ;

        }

        scan.close() ;
    }

    // Метод создания поля боя:
    public static int[][] createWarField (int size, int cntShip) {
        int[][] warField = new int[size][size] ;
        for (int ii = 0; ii < size; ii++)
            Arrays.fill(warField[ii], EMPTY) ;

        if (cntShip == 0)
            return warField ;

        for (int cnt = 0; cnt < cntShip; cnt++) {
            int row = (int) (random() * (size - 1)) ;
            int col = (int) (random() * (size - 1)) ;

            if (warField[row][col] == SHIP)
                cnt-- ;

            warField[row][col] = SHIP ;
        }
        return warField ;
    }

    // Вывод матрицы в консоль:
    public static void showArray(int[][] matrix) {
        for (int ii = 0; ii < matrix.length; ii++) {
            for (int jj = 0; jj < matrix[0].length; jj++) {
                System.out.printf("%2d", matrix[ii][jj]);
            }
            System.out.println();
        }
    }
}
