/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class NameSorter {

    public static void main(String[] args){
        int numOfNames;
        int counter;
        BufferedWriter writer = null;

        ArrayList<String> nameArray;

        try
        {
            nameArray = getInputFromFile("src/main/java/ex41/exercise41_input.txt");
            numOfNames = nameArray.size();

            Collections.sort(nameArray);

            File outputFile = new File("src/main/java/ex41/exercise41_output.txt");
            FileWriter fileWriter = new FileWriter(outputFile);
            writer = new BufferedWriter(fileWriter);

            writer.write("Total of " + numOfNames + " names\n");
            writer.write("-----------------\n");

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

    public static ArrayList<String> getInputFromFile(String s) throws IOException {
        BufferedReader reader;
        String currentLine;

        ArrayList<String> nameArray = new ArrayList<>();

        File inputFile = new File(s);
        FileReader fileReader = new FileReader(inputFile);
        reader = new BufferedReader(fileReader);
        currentLine = reader.readLine();

        while(currentLine != null)
        {
            nameArray.add(currentLine);
            currentLine = reader.readLine();
        }

        return nameArray;
    }
}
