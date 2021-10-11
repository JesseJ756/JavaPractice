/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ex44;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ProductSearch
{
    public static void main(String[] args)
    {
        String productName;
        String isInFile;

        Scanner userInput = new Scanner(System.in);

        while(true)
        {
            System.out.print("What is the product name? ");
            productName = userInput.nextLine();

            isInFile = checkFile(productName);

            if (isInFile.equalsIgnoreCase("y"))
            {
                break;
            }
            else
            {
                System.out.print("Sorry, that product was not found in our inventory.\n");
            }
        }
    }

    public static String checkFile(String productName)
    {
        String isInFile = "n";
        File input = new File("src/main/java/ex44/exercise44_input.json");

        try
        {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            JsonArray jsonArrayProducts = fileObject.get("products").getAsJsonArray();

            for(JsonElement product : jsonArrayProducts)
            {
                JsonObject productObject = product.getAsJsonObject();

                String name = productObject.get("name").getAsString();
                String price = productObject.get("price").getAsString();
                String quantity = productObject.get("quantity").getAsString();

                if(name.equals(productName))
                {
                    System.out.println("Name: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Quantity: " + quantity);

                    isInFile = "y";
                    break;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return isInFile;
    }
}
