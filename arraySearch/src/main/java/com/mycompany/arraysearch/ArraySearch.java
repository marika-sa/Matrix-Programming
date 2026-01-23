/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Marika
 */
public class ArraySearch {

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        
        int arraySize;
        do {
            System.out.println("Enter array size: ");
            while (!scannerObj.hasNextInt()){
                System.out.println("That is not a valid array size!");
                scannerObj.next();
            }
            arraySize = scannerObj.nextInt();
            // Adding this line as nextInt() leaves a newline character in the buffer and can prevent reading the next input
            scannerObj.nextLine();
        } while (arraySize < 0);
        
        String arrayElements;
        int[] userArray = new int[arraySize];
        boolean isValid = false;
        
        do {
            System.out.println("Enter the " + arraySize + " array elements: ");
            arrayElements = scannerObj.nextLine();
            
            if (arrayElements.isEmpty()){
                System.out.println("Array can't be empty. Please enter array elements: ");
                // Jumping back to start of the do while loop.
                continue;
            }
            
            try {
                // Using regular expression for splitting the user input in case a user leaves multiple spaces between entries
                String[] tempArray = arrayElements.split("\\s+");
                
                if (tempArray.length != arraySize){
                    System.out.println("Array too short. You provided " + tempArray.length + " but array size must be " + arraySize);
                } else {
                    int i = 0;
                    while (i < arraySize && i < tempArray.length) {
                        userArray[i] = Integer.parseInt(tempArray[i]);
                        i++;
                    }
                    isValid = true;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input: Must be whole numbers only.");
            }
            
        } while (!isValid);
        
        int repeatedNumber = firstRepeatingElement(userArray, arraySize);
        
        if (repeatedNumber == -1){
            System.out.println("Your array had not repeated values.");
        } else {
            System.out.println("The first repeated value in your array is: " + repeatedNumber);
        }
        
        //System.out.println("The size of your array: " + arraySize + "\n" + "Your array :" + Arrays.toString(userArray));
        
    }
    
    static int firstRepeatingElement(int[] arr, int n){
        
        // First loop to get a number arr[i] from the array
        for (int i = 0; i < n - 1 ; i++){
            // Then looping again to the next number arr[j] which is the number after arr[i]
            for (int j = i + 1; j < n; j++){
                // Lastly comparing the two numbers to see if they are the same, returning the repeated number
                if (arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        
        return -1;
    }
}
