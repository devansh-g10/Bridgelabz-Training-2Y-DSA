import java.util.Scanner;

public class VowelConsonant {

    static boolean isVowel(char c){

        c = Character.toLowerCase(c);

        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int vowel=0, consonant=0;

        for(int i=0;i<text.length();i++){

            char c = text.charAt(i);

            if(Character.isLetter(c)){

                if(isVowel(c))
                    vowel++;
                else
                    consonant++;
            }
        }

        System.out.println("Vowels: "+vowel);
        System.out.println("Consonants: "+consonant);
    }
}