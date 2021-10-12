/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex44;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ProductSearchTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        String ans;
        String expectedAns = "y";

        File input = new File("src/test/java/ex44/ex44TestFile.json");

        ans = ProductSearch.checkFile("Potato", input);

        Assert.assertEquals(ans, expectedAns);

        ans = ProductSearch.checkFile("Tomato", input);

        Assert.assertEquals(ans, "n");
    }
}
