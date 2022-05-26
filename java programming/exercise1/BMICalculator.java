import java.util.Scanner;

public class BMICalculator
{    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        double weight;
        double height;
        double bmi;

        System.out.print("Please enter your weight (kilograms): ");
        weight =input.nextDouble();
        System.out.print("Please enter your height (centimeters): ");
        height=input.nextDouble()/100;
        bmi=weight/(height*height);

        System.out.printf("Your BMI is %.1f",bmi);
        if(bmi<18.5)
        {
            System.out.print("(Underweight)\n");
        }
        else if(bmi<25)
        {
            System.out.print("(Normal)\n");
        }
        else if(bmi<30)
        {
            System.out.print("(Overweight)\n");
        }
        else 
        {
            System.out.print("(Obese)\n");
        }
    }
}