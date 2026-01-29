/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matrixspiraltraversal;
import java.util.Scanner;

/**
 *
 * @author Marika
 */
public class MatrixSpiralTraversal {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
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
        
        System.out.println("Your row value is " + rowValue + " and column value is " + colValue);
    }
}
