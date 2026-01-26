/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matricdiagonalsum;
import java.util.Scanner;

/**
 *
 * @author Marika
 */
public class MatricDiagonalSum {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Scanner so = new Scanner(System.in);
        
        int matrixSize;
        
        do {
            System.out.println("Enter your matrix size: ");
            
            while (!so.hasNextInt()){
                System.out.println("The size must be a valid positive number.");
                so.next();
            }
            
            matrixSize = so.nextInt();
            // Adding this line as nextInt() leaves a newline character in the buffer and can prevent reading the next input
            so.nextLine();
        } while (matrixSize < 0);
        
        int[][] userMatrix = new int[matrixSize][];
        int[] matrixLine = new int[matrixSize];
        
        for (int row = 0; row < userMatrix.length; row++){
            System.out.println("Enter row " + (row + 1) + " in the format: x y z...");
            
            String tempInput  = so.nextLine();
            
            while (!tempInput.matches("^\\d+( \\d+){" + (matrixSize - 1) + "}$")){
                System.out.println("Invalid format. Please enter exactly " + matrixSize + " numbers separated by spaces:");
                tempInput  = so.nextLine();
            }
            
            String[] tempArray = tempInput.split("\\s+");
            
            int[] currentRow = new int[matrixSize];
            
            for (int i = 0; i < tempArray.length; i++){
                currentRow[i] = Integer.parseInt(tempArray[i]);
            }
            
            userMatrix[row] = currentRow;
         }
        
        System.out.println("Your matrix table is ready:");
        
        for (int row = 0; row <  userMatrix.length; row++){
            for (int col = 0; col < userMatrix[row].length; col++){
                System.out.printf("%5d", userMatrix[row][col]);
            }
            System.out.println("");
        }

    }
    
//    static int[] stringToIntArr(String userInput){
//        String userInputArray = userInput.split(" ");
//    }
}
