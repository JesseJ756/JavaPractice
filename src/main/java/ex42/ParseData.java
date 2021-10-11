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
        BufferedReader reader = null;

        try
        {
            reader = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));

            System.out.print("Last      First     Salary\n");
            System.out.print("--------------------------\n");

            printOutput(reader);
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

    public static void printOutput(BufferedReader reader) throws IOException
    {
        String currentLine;
        String[] tokensVal;

        currentLine = reader.readLine();

        while(currentLine != null)
        {
            tokensVal = currentLine.split(",", 3);

            for(String token : tokensVal)
                System.out.format("%-10s", token);

            System.out.print("\n");

            currentLine = reader.readLine();
        }
    }
}
