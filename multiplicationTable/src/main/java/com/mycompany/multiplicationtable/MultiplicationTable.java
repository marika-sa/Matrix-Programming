/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.multiplicationtable;

import java.util.Arrays;
import java.util.Scanner;
        

/**
 *
 * @author Marika
 */
public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner so = new Scanner(System.in);
        
        int tableSize;
        
        do {
            System.out.println("Enter size of your matrix table: ");
            
            while (!so.hasNextInt()){
                System.out.println("The size must be a number value.");
                so.next();
            }
            
            tableSize = so.nextInt();
            // Adding this line as nextInt() leaves a newline character in the buffer and can prevent reading the next input
            so.nextLine();
            
        } while (tableSize < 0);
        
        int[][] userTable = makeMatrixTable(tableSize);
        
        System.out.println("Your matrix table is ready:");
        
        for (int row = 0; row <  userTable.length; row++){
            for (int col = 0; col < userTable[row].length; col++){
                System.out.printf("%5d", userTable[row][col]);
            }
            System.out.println("");
        }
        
        
    }
    
    static int[][] makeMatrixTable(int size){
        int[][] table = new int[size][size];
        
        for (int row = 0; row < table.length; row++){
            for (int col = 0; col < table[row].length; col++){
                table[row][col] = (row+1)*(col+1);
            }
        }
        return table;
    }
}
