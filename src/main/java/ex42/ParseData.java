/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseData {
    public static void main(String[] args)
    {
        String currentLine;
        int token;
        String[] tokensVal = new String[5];
        BufferedReader reader = null;

        // read file
        try
        {
            reader = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));
            currentLine = reader.readLine();

            System.out.print("Last      First     Salary\n");
            System.out.print("--------------------------");

            // WHILE line != null
            while(currentLine != null)
            {
                // SPLIT string when ',' is found
                tokensVal = currentLine.split(",", 3);

                System.out.print("%s %s %s", tokensVal[0], tokensVal[1], tokensVal[2]);



                currentLine = reader.readLine();
            }
                // WHILE char fo array line ist not \n
                // PRINT letter
                // find comma in line of file (method?)
                // PRINT \tab


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
                    reader.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
