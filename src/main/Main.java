package main;

import utils.DataManager;
import utils.Parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        String fileLocation = "C:\\files\\text1.txt";
        String fileLocation1 = "C:\\files\\text2.txt";
        String fileLocation2 = "C:\\files\\text3.txt";
        List<String> resources = new ArrayList<>();
        resources.add(fileLocation);
        resources.add(fileLocation1);
        //resources.add(fileLocation2);
        try {
            for(String item : resources){
                System.out.println(item);
                new Parser(item);
            }
        } catch(Exception E){
            System.out.println("Error");
        }
        try {
            System.out.println("HashMap");
            Thread.sleep(1000);
            HashSet<String> words = DataManager.getWords();
            for (String word:
                    words
                 ) {
                System.out.println(word);
            }
            //Map<String, Integer> hashMap =  Parser.getMap();
            //for (Map.Entry entry : hashMap.entrySet()) {
            //    System.out.println("Key: " + entry.getKey() + " Value: "
            //            + entry.getValue());
            //}
        } catch(Exception E){
            System.out.println("Error");

        }
    }
}
