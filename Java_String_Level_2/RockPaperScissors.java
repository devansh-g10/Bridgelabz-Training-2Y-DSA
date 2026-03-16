import java.util.*;

public class RockPaperScissors {

    static String computerChoice(){

        String[] choices = {"rock","paper","scissors"};

        int index = (int)(Math.random()*3);

        return choices[index];
    }

    static String winner(String user,String comp){

        if(user.equals(comp))
            return "Draw";

        if(user.equals("rock") && comp.equals("scissors") ||
           user.equals("paper") && comp.equals("rock") ||
           user.equals("scissors") && comp.equals("paper"))
            return "User";

        return "Computer";
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of games");

        int n = sc.nextInt();

        int userWin=0, compWin=0;

        for(int i=0;i<n;i++){

            System.out.println("Enter choice (rock/paper/scissors)");

            String user = sc.next();

            String comp = computerChoice();

            String result = winner(user,comp);

            System.out.println("Computer: "+comp);
            System.out.println("Winner: "+result);

            if(result.equals("User"))
                userWin++;
            else if(result.equals("Computer"))
                compWin++;
        }

        System.out.println("User wins: "+userWin);
        System.out.println("Computer wins: "+compWin);
    }
}