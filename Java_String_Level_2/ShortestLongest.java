import java.util.Scanner;

public class ShortestLongest {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] words = text.split(" ");

        String shortest = words[0];
        String longest = words[0];

        for(String w:words){

            if(w.length() < shortest.length())
                shortest = w;

            if(w.length() > longest.length())
                longest = w;
        }

        System.out.println("Shortest word: "+shortest);
        System.out.println("Longest word: "+longest);
    }
}