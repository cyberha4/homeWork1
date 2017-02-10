package com.ramazanov.khidirkhan.main.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Parser implements Runnable {
    private String file;
    private Thread T;
    public static volatile boolean isGood = true;
    public static HashSet<Thread> threads = new HashSet<>();

    private ArrayList<String> splitLine(String line){
        Pattern p = Pattern.compile("\\b[а-яА-Я0-9-]{2,}");
        Matcher m = p.matcher(line);

        ArrayList<String> ArrayMain = new ArrayList<>();
        int i = 0;
        while(m.find()){
            ArrayMain.add(m.group());
            System.out.println("--- " + m.group());
        }
        return ArrayMain;
    }

    private void writeWords(String line) {
        try {
            //Проверяем наличие запрещенных символов в считанной строке
            if (!validate(line))
                throw new Exception();
        } catch (Exception E){
            System.out.println("Найден запрещенный символ в строке!");
            isGood=false;
        }

        ArrayList<String> words = splitLine(line);
        for(String word:words){
            System.out.println(word+" name:"+this.T.getName());
            writeWord(word);
        }
    }
    private boolean validate(String line){
        return Checker.validate(line);
    }

    private void writeWord(String word){
        DataManager.setWord(word);
    }

    public  Parser(String file){
        this.file = file;
        T = new Thread(this);
        T.start();
        threads.add(T);
    }
    @Override
    public void run() {
        try {
            readFileBuffer(file);
            //List<String> lines = readFile(file);
            //Parser.writeWords(lines);
            //while (true) {
            //    System.out.println(T.getName());
            //}
        } catch (Exception e) {
            System.out.println("error3");
        }
    }

    private void readFileBuffer(String file){
        try(BufferedReader br = new BufferedReader (new FileReader(file))){
            String s;
            while(isGood && (s=br.readLine())!=null){
                writeWords(s);
            }
        } catch(IOException ex){
            System.out.println("Ошибка чтения файла!");
        }

    }
    private List<String> readFile(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        System.out.println(lines);
        return lines;
    }

}
