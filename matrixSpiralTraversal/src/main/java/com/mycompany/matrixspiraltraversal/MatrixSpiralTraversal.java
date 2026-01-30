/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrixspiraltraversal;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Marika
 */
public class MatrixSpiralTraversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String regex = "^[1-9]\\d*\\s+[1-9]\\d*$";
        int rowValue;
        int colValue;
        
        do {
            System.out.println("Enter your matrix dimensions in format 'm n', where m is the number of rows, and n is the number of columns: ");
            
            String tempInput = sc.nextLine();
            
            while (!tempInput.matches(regex)){
                System.out.println("Incorrect input format or values. Must contain valid whole positive numbers and be in format 'm n'. Try again: ");
                tempInput = sc.nextLine();
            }
            
            String[] tempArray = tempInput.split("\\s+");
            int[] dimensions = new int[2];
            
            for (int i = 0; i < tempArray.length; i++){
                dimensions[i] = Integer.parseInt(tempArray[i]);
            }
            
            rowValue = dimensions[0];
            colValue = dimensions[1]; 
        } while (rowValue < 0 && colValue < 0);
        
        int[][] userMatrix = new int[rowValue][colValue];
        
        for (int row = 0; row < userMatrix.length; row++){
            System.out.println("Enter row " + (row + 1) + " in the format: x y z...");
            
            String tempRow = sc.nextLine();
            
            while (!tempRow.matches("^\\d+( \\d+){" + (colValue - 1) + "}$")){
                System.out.println("Invalid format. Please enter exactly " + colValue + " numbers separated by spaces:");
                tempRow = sc.nextLine();
            }
            
            String[] tempRowArr = tempRow.split("\\s+");
            
            int[] currentRow = new int[colValue];
            
            for (int i = 0; i < tempRowArr.length; i++){
                currentRow[i] = Integer.parseInt(tempRowArr[i]);
            }
            
            userMatrix[row] = currentRow;
        }
        
        System.out.println("Your row value is " + rowValue + " and column value is " + colValue);
        
        System.out.println("\nYour spiral traversal is as follows: " + Arrays.toString(spiralTraversal(userMatrix, rowValue, colValue)));
    }
    
    public static int[] spiralTraversal(int[][] matrix, int numRows, int numCols){
        int matrixSize = numRows*numCols;
        int[] spiral = new int[matrixSize];
        
        // The pattern of the spiral movement is: right(0,1), down(1,0), left(0,-1), up(-1,0)
        int[] directions = {0,1,0,-1,0};
        
        // boolean for tracking the matric values that were visited
        boolean[][] trackingArr = new boolean[numRows][numCols];
        
        int currentRow = 0;
        int currentCol = 0;
        
        // The direction index
        int k = 0;
        
        for (int count = 0; count < matrixSize; count++){
            spiral[count] = matrix[currentRow][currentCol];
            trackingArr[currentRow][currentCol] = true;
            
            // Calculating the next position based on the current direction
            int nextRow = currentRow + directions[k];
            int nextCol = currentCol + directions[k+1];
            
            // Change direction if next is out of bounds
            // if the nextRow is less than 0, or is greater/equal to numRows
            // if the nextCol is less than 0, or is greater/equal to numCols
            // OR Change direction if the position has already been visited
            // if trackingArr[nextRow][nextCol] is true
            if (nextRow < 0 || nextRow >= numRows || nextCol < 0 || nextCol >= numCols || trackingArr[nextRow][nextCol]){
                // return a new value for the direction index is the directions changes
                k = (k + 1) % 4;
            }
            
            currentRow += directions[k];
            currentCol += directions[k+1];
        }
        
        return spiral;
    }
    
}
