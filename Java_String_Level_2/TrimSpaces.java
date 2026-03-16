import java.util.Scanner;

public class TrimSpaces {

    static String trimText(String text){

        int start=0;
        int end=text.length()-1;

        while(text.charAt(start)==' ')
            start++;

        while(text.charAt(end)==' ')
            end--;

        String result="";

        for(int i=start;i<=end;i++)
            result += text.charAt(i);

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String userTrim = trimText(text);
        String builtTrim = text.trim();

        System.out.println("User trim: "+userTrim);
        System.out.println("Built trim: "+builtTrim);
    }
}