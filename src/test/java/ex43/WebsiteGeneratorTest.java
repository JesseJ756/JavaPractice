/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex43;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class WebsiteGeneratorTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        String answer;
        String folderType = "CSS";

        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        System.setIn(in);

        answer = WebsiteGenerator.askQuestion(folderType);

        if(answer.equals("y"))
        {
            assertTrue(true);
        }
        else if(answer.equals("n"))
        {
            assertTrue(true);
        }
        else
        {
            assertFalse(false);
        }

        System.setIn(sysInBackup);
    }
}
