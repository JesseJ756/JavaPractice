/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WebsiteGenerator
{
    public static void main(String[] args) throws IOException {
        String javaScriptAns;
        String cssAns;
        String siteName;
        String author;
        String folder;
        String file;
        String ex43Dir = "src/main/java/ex41";

        BufferedWriter writer = null;

        Scanner userInput = new Scanner(System.in);

        System.out.print("Site name: ");
        siteName = userInput.nextLine();
        folder = "/website/" + siteName;
        file = "/website/" + siteName + "/index.html";

        System.out.print("Author: ");
        author = userInput.nextLine();

        javaScriptAns = askQuestion("JavaScript");
        cssAns = askQuestion("CSS");

        System.out.println("Created ." + folder);
        System.out.println("Created ." + file);

        // MKDIR makes directory
        new File(ex43Dir + folder).mkdirs();
        new File(ex43Dir + file).mkdir();

        File outputFile = new File(file);
        FileWriter fileWriter = new FileWriter(outputFile);
        writer = new BufferedWriter(fileWriter);

        writer.write("<html><head><title>" + siteName + "</title></head><body><p>This is Body</p></body></html>");
        writer.close();

        createFolder(javaScriptAns, "JavaScript", folder, ex43Dir);
        createFolder(cssAns, "CSS", folder, ex43Dir);
    }

    private static void createFolder(String ans, String fileType, String folder, String ex43Dir)
    {
        String dir = folder + "/" + fileType + "/";
        if (ans.equalsIgnoreCase("y"))
        {
            System.out.print("Created ." + dir);

            File outputFile = new File(ex43Dir + dir);
        }
    }

    public static String askQuestion(String string)
    {
        String userAns;
        String ans;

        Scanner userInput = new Scanner(System.in);

        while(true)
        {
            System.out.print("Do you want a folder for " + string + "? Y/N: ");
            userAns = userInput.nextLine();

            if(userAns.equalsIgnoreCase("y"))
            {
                ans = "y";
                break;
            }
            else if(userAns.equalsIgnoreCase("n"))
            {
                ans = "n";
                break;
            }
            else
            {
                System.out.print("Please enter a y or no");
            }

            userInput.nextLine();
        }

        return ans;
    }
}
