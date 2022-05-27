import java.security.SecureRandom;
import java.util.Scanner;
public class ComplexTest
{	
	public static void main (String[] args)//input the data to Complex and output the result
	{
		Complex a = new Complex(1.1, 2.2);
		Complex b = new Complex(3.3, -4.4);

		System.out.print("a = ");
		a.printt();
		System.out.print("Conjugates of a = ");
		a.conjugates();
		System.out.printf("Absolute value of a = %.2f%n",a.absoluteValue());
		// TODO
		System.out.println();

		System.out.print("b = " );
		b.printt();
		System.out.print("Conjugates of b = ");
		b.conjugates();
		System.out.printf("Absolute value of b = %.2f%n",b.absoluteValue());
		// TODO
		System.out.println();

		System.out.print("a + b = ");
		a.add(b);
		System.out.print("a - b = ");
		a.subtract(b);
		System.out.print("a x b = ");
		a.multiply(b);
		System.out.print("a / b = ");
		a.divide(b);		
		System.out.println();	
			
		Complex c = new Complex();
		Complex d = new Complex();

		System.out.print("c = ");
		c.printt();
		// TODO
		System.out.print("Conjugates of c = ");
		c.conjugates();
		System.out.printf("Absolute value of c = %.2f%n",c.absoluteValue());
		System.out.println();

		System.out.print("d = ");
		d.printt();
		//TODO
		System.out.print("Conjugates of d = ");
		d.conjugates();
		System.out.printf("Absolute value of d = %.2f%n",d.absoluteValue());
		System.out.println();
		System.out.print("c + d = ");
		c.add(d);
		System.out.print("c - d = ");
		c.subtract(d);
		System.out.print("c x d = ");
		c.multiply(d);
		System.out.print("c / d = ");
		c.divide(d);		
		System.out.println();
		//TODO
	}
	
}