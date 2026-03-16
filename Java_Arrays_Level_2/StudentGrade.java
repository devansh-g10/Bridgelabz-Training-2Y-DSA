import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students");
        int n = sc.nextInt();

        double[] percentage = new double[n];
        String[] grade = new String[n];

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];

        for(int i=0;i<n;i++){

            System.out.println("Enter physics marks");
            physics[i] = sc.nextDouble();

            System.out.println("Enter chemistry marks");
            chemistry[i] = sc.nextDouble();

            System.out.println("Enter maths marks");
            maths[i] = sc.nextDouble();

            if(physics[i]<0 || chemistry[i]<0 || maths[i]<0){
                System.out.println("Invalid marks");
                i--;
            }
        }

        for(int i=0;i<n;i++){

            percentage[i] = (physics[i]+chemistry[i]+maths[i])/3;

            if(percentage[i] >= 90)
                grade[i] = "A";
            else if(percentage[i] >= 75)
                grade[i] = "B";
            else if(percentage[i] >= 60)
                grade[i] = "C";
            else
                grade[i] = "D";
        }

        for(int i=0;i<n;i++){

            System.out.println("Percentage: "+percentage[i]);
            System.out.println("Grade: "+grade[i]);
        }
    }
}