
import java.util.Scanner;

public abstract class Employee extends Object {

	private Bonus bonus;//這個employee的bonus interface(可用來決定要哪個類別)

	public void setBonus(Bonus bonus) {//set the bonus
		this.bonus = bonus;
	}

	public Bonus getBonus() {//get the bonus
		return bonus;
	}
	//inputData & getEarnings 為抽象method 在子類別會在具體化
	public abstract void inputData(Scanner input);

	public abstract int getEarnings();

}

class SalariedEmployee extends Employee//SalariedEmployee為Employee 的subclass
{
	private int weeklySalary;
	private int weeks;
	private int earnings; 
	public void inputData(Scanner input)
	{
		System.out.print("Please input weekly salary: ");
		weeklySalary=input.nextInt();
		System.out.print("Please input working weeks: ");
		weeks=input.nextInt();
	}

	public int getEarnings()
	{
		earnings=weeklySalary*weeks;
		return earnings;
	}

	public String toString()//override
	{
		return String.format("Salaried Employee => weekly salary: %d, working weeks: %d, calculated earnings: %d, bonus: %d",weeklySalary,weeks,earnings,getBonus().getBonus(earnings));
	}
}

class HourlyEmployee extends Employee//HourlyEmployee為Employee 的subclass
{
	private int wage;
	private int hours; 
	private int earnings;
	public void inputData(Scanner input)
	{
		System.out.print("Please input wage: ");
		wage=input.nextInt();
		System.out.print("Please input hours: ");
		hours=input.nextInt();
	}

	public int getEarnings()
	{
		if(hours<=40)//如果時數<=40
		{
			earnings= hours*wage;
		}
		else
		{
			earnings=40*wage+(int)((hours-40)*wage*1.5);
		}
		return earnings;
	}

	public String toString()//override
	{
		return String.format("Hourly Employee => hourly salary: %d, hours: %d, calculated earnings: %d, bonus: %d",wage,hours,earnings,getBonus().getBonus(earnings));
	}
}

class CommissionEmployee extends Employee//CommiasionEmployee為Employee 的subclass
{
	private double commissionRate;
	private int grossSales;
	private int earnings; 
	public void inputData(Scanner input)
	{
		System.out.print("Please input commission rate: ");
		commissionRate=input.nextDouble();
		System.out.print("Please input gross sales: ");
		grossSales=input.nextInt();
	}

	public int getEarnings()
	{
		earnings=(int)(commissionRate*grossSales);
		return earnings;
	}

	public String toString()//override
	{
		return String.format("Commission Employee => commission rate: %.2f, gross sales: %d, calculated earnings: %d, bonus: %d",commissionRate,grossSales,earnings,getBonus().getBonus(earnings));
	}
}

class PieceWorker extends Employee//PieceWorker為Employee 的subclass
{
	private int wage;
	private int piece; 
	private int earnings;
	public void inputData(Scanner input)
	{
		System.out.print("Please input wage: ");
		wage=input.nextInt();
		System.out.print("Please input piece: ");
		piece=input.nextInt();
	}

	public int getEarnings()
	{
		earnings=wage*piece;
		return earnings;
	}

	public String toString()//override
	{
		return String.format("Piece Worker => wage: %d, piece: %d, calculated earnings: %d, bonus: %d",wage,piece,earnings,getBonus().getBonus(earnings));
	}
}