/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex45;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFinderTest
{
    @Test
    public void shouldAnswerWithTrue() throws FileNotFoundException {
        char[] testCharArray;
        char[] inputCharArray;
        String fileInput = "Hello, my name is Jesse James Johnson";
        String inputFileName = "src/test/java/ex45/ex45TestFile.txt";

        File inputFile = new File(inputFileName);
        Scanner fileScanner = new Scanner(inputFile);

        inputCharArray = WordFinder.fileToCharArray(fileScanner);

        testCharArray = fileInput.toCharArray();

        for(int i = 0; i < testCharArray.length; i++)
        {
            Assert.assertEquals(testCharArray[i], inputCharArray[i]);
        }
    }
}
