/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex42;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class ParseDataTest
{

    @Test
    public void shouldAnswerWithTrue() throws IOException {
        ArrayList<String> fileArray;
        ArrayList<String> outputFileArray = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("src/test/java/ex42/ex42InputFileTest.txt"));

        fileArray = ParseData.inputFileToArray(reader);

        outputFileArray.add("Michael");
        outputFileArray.add("Scott");
        outputFileArray.add("Manager");
        outputFileArray.add("Dwight");
        outputFileArray.add("Schrute");
        outputFileArray.add("ARM");
        outputFileArray.add("Jim");
        outputFileArray.add("Halpert");
        outputFileArray.add("Salesman");
        outputFileArray.add("Pam");
        outputFileArray.add("Beesly");
        outputFileArray.add("Receptionist");

        for(int i = 0; i < outputFileArray.size(); i++)
        {
            Assert.assertEquals(outputFileArray.get(i), fileArray.get(i));
        }
    }
}
