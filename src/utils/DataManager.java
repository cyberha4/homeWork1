package utils;

import java.util.HashSet;

/**
 * Created by Хидир on 08.02.2017.
 */
public class DataManager {
    private static HashSet<String> Words = new HashSet<>();

    public static HashSet<String> getWords() {
        return Words;
    }

    synchronized public static void setWord(String word) {
        try {
            if (!Words.contains(word))
                Words.add(word);
            else {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("error5");
        }
    }

    //public static void main(String[] args) {
    //    setWord("test");
    //    setWord("test2");
    //    setWord("test");
    //    for(String s:getWords()){
    //        System.out.println(s);
    //    }
    //}
}