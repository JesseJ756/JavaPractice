/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex46;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class WordFrequencyFinderTest
{
    @Test
    public void testswapWords()
    {
        ArrayList<String> testArray = new ArrayList<>();

        testArray.add("This is one");
        testArray.add("This is two");

        WordFrequencyFinder.swapWords(testArray, 0, 1);

        Assert.assertEquals(testArray.get(0), "This is two");
        Assert.assertEquals(testArray.get(1), "This is one");
    }

    @Test
    public void testSwapCount()
    {
        ArrayList<Integer> testArray = new ArrayList<>();

        testArray.add(5);
        testArray.add(10);

        WordFrequencyFinder.swapCount(testArray, 0, 1);

        int test1Cell = testArray.get(0);
        int test2Cell = testArray.get(1);

        Assert.assertEquals(test1Cell, 10);
        Assert.assertEquals(test2Cell, 5);
    }

    @Test
    public void TestFileWordsToArray() throws IOException {
        String fileName ="src/test/java/ex46/ex46TestFile.txt";
        ArrayList<String> array;
        ArrayList<String> testArray = new ArrayList<>();

        testArray.add("Spread");
        testArray.add("love");
        testArray.add("everywhere");
        testArray.add("you");
        testArray.add("go");

        array = WordFrequencyFinder.fileWordsToArray(fileName);

        for(int i = 0; i < array.size(); i++)
        {
            Assert.assertEquals(testArray.get(i), array.get(i));
        }
    }

}
