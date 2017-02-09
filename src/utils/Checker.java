package utils;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Checker {
    public static boolean validate(String str) {
        if (str.matches("[а-яА-Я0-9\\s]+"))
            return true;
        return false;
    }
}
