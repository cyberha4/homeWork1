package com.ramazanov.khidirkhan.main;

import com.ramazanov.khidirkhan.main.utils.DataManager;
import com.ramazanov.khidirkhan.main.utils.Parser;

import java.util.*;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        //String fileLocation = "C:\\files\\text1.txt";
        //String fileLocation1 = "C:\\files\\text2.txt";
        //String fileLocation2 = "C:\\files\\text3.txt";

        String fileLocation = "/home/sa/files/text1";
        String fileLocation1 = "/home/sa/files/text2";
        //String fileLocation2 = "C:\\files\\text3.txt";

        List<String> resources = new ArrayList<>();
        resources.add(fileLocation);
        resources.add(fileLocation1);
        //resources.add(fileLocation2);
        try {
            for(String item : resources){
                if(Parser.isGood) {
                    System.out.println(item);
                    new Parser(item);
                }
            }
        } catch(Exception E){
            System.out.println("Error");
        }

        //Цепляем массивы к главному трэду, чтобы он ждал их окончания
        for(Thread thread:
                Parser.threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        HashSet<String> words = DataManager.getWords();
        System.out.println("\n--------Количество уникальных слов в ресурсах "+words.size()+"----------\n");

        for (String word:
                words
             ) {
            System.out.println(word);
        }
    }
}
