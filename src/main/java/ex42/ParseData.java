/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ParseData {
    public static void main(String[] args)
    {
        BufferedReader reader = null;
        ArrayList<String> nameArray;

        try
        {
            // Allows reading of data from input file
            reader = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));

            System.out.print("Last      First     Salary\n");
            System.out.print("--------------------------\n");

            nameArray = inputFileToArray(reader);
            printOutput(nameArray);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(reader != null)
                {
                    // Always close reader
                    reader.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    // Prints names in nameArray
    public static void printOutput(ArrayList<String> nameArray)
    {
        for(int i = 0; i < nameArray.size(); i++)
        {
            System.out.format("%-10s", nameArray.get(i));

            if((i % 3) == 2)
                System.out.print("\n");
        }

    }

    // Reads names from input file and puts them in ArrayList
    public static ArrayList<String> inputFileToArray(BufferedReader reader) throws IOException
    {
        String currentLine;
        String[] tokensVal;
        ArrayList<String> nameArray = new ArrayList<>();

        currentLine = reader.readLine();

        while(currentLine != null)
        {
            tokensVal = currentLine.split(",", 3);

            Collections.addAll(nameArray, tokensVal);

            currentLine = reader.readLine();
        }

        return nameArray;
    }
}