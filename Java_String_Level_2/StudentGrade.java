import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students");

        int n = sc.nextInt();

        int[][] marks = new int[n][3];

        double[] percentage = new double[n];
        char[] grade = new char[n];

        for(int i=0;i<n;i++){

            System.out.println("Physics Chemistry Maths");

            for(int j=0;j<3;j++)
                marks[i][j] = sc.nextInt();

            int total = marks[i][0]+marks[i][1]+marks[i][2];

            percentage[i] = total/3.0;

            if(percentage[i]>=90)
                grade[i]='A';
            else if(percentage[i]>=75)
                grade[i]='B';
            else if(percentage[i]>=60)
                grade[i]='C';
            else
                grade[i]='D';
        }

        System.out.println("Percentage\tGrade");

        for(int i=0;i<n;i++){
            System.out.println(percentage[i]+"\t"+grade[i]);
        }
    }
}