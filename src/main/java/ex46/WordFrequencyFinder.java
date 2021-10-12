/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex46;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class WordFrequencyFinder
{
    static ArrayList<String> wordArray = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> inputWordArray;
        ArrayList<Integer> wordCount;
        ArrayList<Integer> arrangedWordCount;

        String inputFileName = "src/main/java/ex46/exercise46_input.txt";

        inputWordArray = fileWordsToArray(inputFileName);

        wordCount = countForEachWord(inputWordArray);

        arrangedWordCount = sortHighToLow(wordCount);

        printOutput(arrangedWordCount);
    }

    private static ArrayList<Integer> sortHighToLow(ArrayList<Integer> wordCount)
    {
        int j;
        boolean hasSwapped = true;

        while(hasSwapped)
        {
            hasSwapped = false;
            for(j = wordCount.size() - 1; j > 0; j--)
            {
                if(wordCount.get(j) > wordCount.get(j - 1))
                {
                    swapCount(wordCount, j, j - 1);
                    swapWords(wordArray, j, j - 1);
                    hasSwapped = true;
                }
            }
        }

        return wordCount;
    }

    public static void swapWords(ArrayList<String> array, int i, int j)
    {
        String word = array.get(i);
        array.set(i, array.get(j));
        array.set(j, word);
    }

    public static void swapCount(ArrayList<Integer> array, int i, int j)
    {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void printOutput(ArrayList<Integer> wordCount)
    {
        int j = 0;

        for(String word : wordArray)
        {
            word = word.concat(":");
            System.out.format("%-10s", word);

            for(int i = 0; i < wordCount.get(j); i++)
            {
                System.out.print("*");
            }

            j++;

            System.out.print("\n");
        }
    }

    public static ArrayList<Integer> countForEachWord(ArrayList<String> inputWordArray)
    {
        int i;
        int isIdentifiedWord;
        ArrayList<Integer> wordCount = new ArrayList<>();

        for(String word : inputWordArray)
        {
            isIdentifiedWord = 0;
            // System.out.format("word: %s\n", word);
            for(i = 0; i < wordArray.size(); i++)
            {
                if(word.equalsIgnoreCase(wordArray.get(i)))
                {
                    wordCount.set(i, wordCount.get(i) + 1);
                    // System.out.format("wordCount[%d]: %d\n", i, wordCount.get(i));
                    isIdentifiedWord = 1;
                }
            }

            if(isIdentifiedWord == 0)
            {
                wordArray.add(word);
                wordCount.add(1);
                // System.out.format("In if wordCount[%d]: %d\n", i, wordCount.get(i));
            }
        }

        return wordCount;
    }

    public static ArrayList<String> fileWordsToArray(String s) throws IOException {
        BufferedReader reader;
        String currentLine;
        String[] tokensVal;

        ArrayList<String> inputwordArray = new ArrayList<>();

        File inputFile = new File(s);
        FileReader fileReader = new FileReader(inputFile);
        reader = new BufferedReader(fileReader);
        currentLine = reader.readLine();

        while(currentLine != null)
        {
            tokensVal = currentLine.split(" ");

            Collections.addAll(inputwordArray, tokensVal);

            currentLine = reader.readLine();
        }

        return inputwordArray;
    }
}
