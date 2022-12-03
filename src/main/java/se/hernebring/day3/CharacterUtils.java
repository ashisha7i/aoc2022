package se.hernebring.day3;

public class CharacterUtils {
    public static int getValue(char ch) {
        if(Character.isLowerCase(ch))
            return ch - 'a' + 1;
        else
            return ch - 'A' + 27;
    }
}
