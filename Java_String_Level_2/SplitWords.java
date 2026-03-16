// Write a method that takes a string as input and returns an array of words in the string. The method should split the string based on spaces and return the individual words as elements of the array.
import java.util.Scanner;

public class SplitWords {

    static String[] splitText(String text) {

        int spaceCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                spaceCount++;
        }

        String[] words = new String[spaceCount + 1];

        String word = "";
        int index = 0;

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) != ' ') {
                word += text.charAt(i);
            } else {
                words[index] = word;
                index++;
                word = "";
            }
        }

        words[index] = word;

        return words;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = sc.nextLine();

        String[] result = splitText(text);

        System.out.println("Words are:");

        for (String w : result) {
            System.out.println(w);
        }
    }
}