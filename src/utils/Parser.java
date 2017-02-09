package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Parser implements Runnable {
    private String file;
    private Thread T;

    private void writeWords(String line) {
        try {
            //Проверяем наличие запрещенных символов в считанной строке
            if (!validate(line))
                throw new Exception();
        } catch (Exception E){
            System.out.println("error1");
            System.exit(2);
        }
        String[] words = line.split(" ");
        System.out.println(Arrays.toString(words));
            for (String word : words) {
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
    }
    @Override
    public void run() {
        try {
            readFileBuffer(file);
            //List<String> lines = readFile(file);
            //Parser.writeWords(lines);
        } catch (Exception e) {
            System.out.println("error3");
        }
    }

    private void readFileBuffer(String file){
        try(BufferedReader br = new BufferedReader (new FileReader(file))){
            String s;
            while((s=br.readLine())!=null){
                writeWords(s);
            }
        } catch(IOException ex){
            System.out.println("error4");
        }

    }
    private List<String> readFile(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        System.out.println(lines);
        return lines;
    }

}
