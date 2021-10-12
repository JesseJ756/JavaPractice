/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex41;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


public class NameSorterTest
{
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        ArrayList<String> arrayList;
        ArrayList<String> presidentArrayList = new ArrayList<>();

        String fileName = "src/test/java/ex41/inputFileTest.txt";

        presidentArrayList.add("George Washington");
        presidentArrayList.add("Thomas Jefferson");
        presidentArrayList.add("James Madison");
        presidentArrayList.add("James Monroe");
        presidentArrayList.add("John Quincy Adams");

        arrayList = NameSorter.getInputFromFile(fileName);

        for(int i = 0; i < 5; i++)
        {
            Assert.assertEquals(presidentArrayList.get(i), arrayList.get(i));
        }
    }
}
