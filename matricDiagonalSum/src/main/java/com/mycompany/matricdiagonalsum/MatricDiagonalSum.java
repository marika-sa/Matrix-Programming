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
        
    }
}
