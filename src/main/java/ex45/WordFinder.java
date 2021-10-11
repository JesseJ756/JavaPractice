/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex45;

import java.io.*;
import java.util.Scanner;

public class WordFinder
{
    public static void main(String[] args) throws IOException {

        char[] inputCharArray;
        String inputFileName = "src/main/java/ex45/exercise45_input.txt";

        Scanner userInput = new Scanner(System.in);

        File inputFile = new File(inputFileName);
        Scanner fileScanner = new Scanner(inputFile);

        inputCharArray = fileToCharArray(fileScanner);

        System.out.print("Name for new file: ");
        String fileName = userInput.nextLine();

        File outputFile = new File("src/main/java/ex45/" + fileName + ".txt");
        FileWriter fileWriter = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        utilizeToUse(inputCharArray, writer);

        writer.close();
    }

    private static char[] fileToCharArray(Scanner fileScanner)
    {
        String fileString;

        fileString = fileScanner.nextLine();
        while(fileScanner.hasNextLine())
        {
            fileString = fileString.concat("\n");
            fileString = fileString.concat(fileScanner.nextLine());
        }

        return fileString.toCharArray();
    }

    private static void utilizeToUse(char[] inputCharArray, BufferedWriter writer) throws IOException
    {
        for(int i = 0; i < inputCharArray.length; i++)
        {
            if(inputCharArray[i] == 'u' && inputCharArray[i + 1] == 't' && inputCharArray[i + 2] == 'i'
                    && inputCharArray[i + 3] == 'l' && inputCharArray[i + 4] == 'i' && inputCharArray[i + 5] == 'z'
                    && inputCharArray[i + 6] == 'e')
            {
                i += 6;

                writer.write('u');
                writer.write('s');
                writer.write('e');
            }
            else
            {
                writer.write(inputCharArray[i]);
            }
        }
    }
}
