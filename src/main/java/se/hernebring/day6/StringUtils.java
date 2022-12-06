package se.hernebring.day6;

public class StringUtils {
    public static int findUniqueCharacterSequence(String line, int length) {
        int counter = length - 1;
        boolean differentSequence = false;
        while(!differentSequence) {
            counter++;
            differentSequence = isUniqueCharacterSequence(line, length, counter);
        }
        return counter;
    }

    private static boolean isUniqueCharacterSequence(String line, int length, int counter) {
        for(int i = counter - length; i < counter - 1; i++) {
            for(int j = i + 1; j < counter; j++) {
                if(line.charAt(i) == line.charAt(j))
                    return false;

            }
        }
        return true;
    }
}
