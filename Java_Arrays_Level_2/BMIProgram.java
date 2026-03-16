import java.util.Scanner;

public class BMIProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of persons");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for(int i=0;i<n;i++){

            System.out.println("Enter weight");
            weight[i] = sc.nextDouble();

            System.out.println("Enter height (meters)");
            height[i] = sc.nextDouble();
        }

        for(int i=0;i<n;i++){

            bmi[i] = weight[i]/(height[i]*height[i]);

            if(bmi[i] < 18.5)
                status[i] = "Underweight";
            else if(bmi[i] < 25)
                status[i] = "Normal";
            else if(bmi[i] < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for(int i=0;i<n;i++){

            System.out.println("Height: "+height[i]);
            System.out.println("Weight: "+weight[i]);
            System.out.println("BMI: "+bmi[i]);
            System.out.println("Status: "+status[i]);
        }
    }
}