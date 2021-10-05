/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex45;

import java.io.BufferedReader;
import java.util.Scanner;

public class WordFinder
{
    public static void main(String[] args)
    {
        // Scan for name of output file
        // get String and put file into char array
        // Method: changes the words utilizes for uses. return char array
            // WHILE char != '\n'
                // go over each char in file and put each char into output file until u-t-i-l-i-z-e is scanned
                    //stop putting char into output file when u is found
                //if "utilize" is found put "use in output file
        // Method: make a new output file with name depending on the user. RETURN file name
        // put finished char array into new output file.

        String fileName;

        Scanner userInput = new Scanner(System.in);

        System.out.print("Name for new file: ");
        fileName = userInput.nextLine();

        BufferedReader

    }
}
