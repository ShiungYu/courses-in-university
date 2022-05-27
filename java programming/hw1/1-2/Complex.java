import java.security.SecureRandom;
import java.util.Scanner;
public class Complex { 
    private static final SecureRandom randomNumbers = new SecureRandom();

    private double real;
    private double imaginary;
    public Complex()//essential complex
    {
        this.real=randomNumbers.nextDouble();
        this.imaginary=randomNumbers.nextDouble();
    }
    public Complex(double real,double imaginary)//contructor
    {
        this.real=real;
        this.imaginary=imaginary;
    }
    public void printt()//print complex
    {
        if(this.imaginary>0)
        {
            System.out.printf("%.2f + %.2fi%n",this.real,this.imaginary);
            //returntoString(this.real)+" + "+toString(this.imaginary)+"i";
        }
        else{
            System.out.printf("%.2f - %.2fi%n",this.real,-1*this.imaginary);

           // return toString(this.real)+" - "+toString(-1*this.imaginary)+"i";
        }
    }
    public void add(Complex b)//complex add
    {
        Complex c =new Complex(this.real+b.real,this.imaginary+b.imaginary);
        c.printt();
    }
    public void subtract(Complex b)//complex subtract
    {
        Complex c =new Complex(this.real-b.real,this.imaginary-b.imaginary);
        c.printt();
    }
    public void multiply(Complex b)//complex multiply
    {
        double r=this.real*b.real-this.imaginary*b.imaginary;
        double i=this.real*b.imaginary+this.imaginary*b.real;
        Complex c =new Complex(r,i);
        c.printt();
    }
    public void divide(Complex b)//complex divide
    {
        double r=(this.real*b.real+this.imaginary*b.imaginary)/(b.imaginary*b.imaginary+b.real*b.real);
        double i=(this.imaginary*b.real-this.real*b.imaginary)/(b.imaginary*b.imaginary+b.real*b.real);
        Complex c =new Complex(r,i);
        c.printt();
    }
    public void conjugates()//complex conjugates
    {
        Complex c =new Complex(this.real,-1*this.imaginary);
        c.printt();
    }
    public double absoluteValue()//get a absolute value of complex
    {
        return Math.pow(this.real*this.real+this.imaginary*this.imaginary,0.5);
    }
}
