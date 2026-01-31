/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bubblesort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Marika
 */
public class BubbleSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int arraySize;
        
        do {
            System.out.print("Enter size of you array: ");
            
            while(!sc.hasNextInt()){
                System.out.println("Array size must be a valid, whole, positive number. Try again.");
                sc.next();
            }
            
            arraySize = sc.nextInt();
            sc.nextLine();
            
        } while (arraySize < 0);
        
        int[] userArray = new int[arraySize];
        
        do {
            System.out.println("Enter your array of the size" + arraySize + " with a space between each value: ");
            
            String tempInput = sc.nextLine();
            
            while (!tempInput.matches("^\\d+( \\d+){" + (arraySize - 1) + "}$")){
                System.out.println("Must be an array of numbers seperated by spaces. Try again.");
                sc.nextLine();
            }
            
            String[] tempArray = tempInput.split("\\s+");
            
            for (int i = 0; i < tempArray.length; i++){
                userArray[i] = Integer.parseInt(tempArray[i]);
            }
        }while (userArray.length < 0);
        
        System.out.println("Your sorted array: " + Arrays.toString(bubbleSort(userArray)));
      }  
    
    static int[] bubbleSort(int[] sorted){
        for (int j = 0; j < sorted.length - 1; j++){
            for (int i = 0; i < sorted.length - 1 - j; i++){
                if (sorted[i] > sorted[i + 1]){
                    int higher = sorted[i];
                    int lower = sorted[i + 1];

                    sorted[i] = lower;
                    sorted[i+1] = higher;
                }
            }
        }
        
        return sorted;
    }
}
