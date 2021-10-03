/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FilterRecords {

    public static void main(String[] args){
        int counter;
        int numOfNames = 0;
        String currentLine;
        BufferedReader reader = null;
        BufferedWriter writer = null;

        ArrayList<String> nameArray = new ArrayList<>();

        // READ file
        try
        {
            File inputFile = new File("src/main/java/ex41/exercise41_input.txt");
            FileReader fileReader = new FileReader(inputFile);
            reader = new BufferedReader(fileReader);
            currentLine = reader.readLine();

            // WHILE loop, set counter to 0, iterate through file until EOF
            // put name into array
            // set number of names var to i
            while(currentLine != null)
            {
                nameArray.add(currentLine);
                currentLine = reader.readLine();
                numOfNames++;
            }

            // sort through names
            Collections.sort(nameArray);

            File outputFile = new File("src/main/java/ex41/exercise41_output.txt");
            FileWriter fileWriter = new FileWriter(outputFile);
            writer = new BufferedWriter(fileWriter);

            writer.write("Total of " + numOfNames + " names\n");
            writer.write("-----------------\n");


            // FOR loop, counter to 0, iterate though number of names var
            // put names from array to file one by one
            for(counter = 0; counter < numOfNames; counter++)
            {
                writer.write(nameArray.get(counter));
                writer.newLine();
            }
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
                if(writer != null)
                {
                    writer.close();
                }

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
