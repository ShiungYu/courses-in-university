import java.util.ArrayList;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner14;

public class EmployeeDataCollector {
	
	private Scanner input = new Scanner(System.in);
	private ArrayList<Employee> list = new ArrayList<Employee>();//create a Employee's list

	public EmployeeDataCollector () {//contructor
		input = new Scanner(System.in);
		list = new ArrayList<Employee>();
	}
	
	public void collectEmployeeData() {
		// TODO (會用到inputEmployeeData)
		while(true){
			System.out.println("---Earnings Calculation System:");
			System.out.println("1. Salaried Employee");
			System.out.println("2. Hourly Employee");
			System.out.println("3. Commission Employee");
			System.out.println("4. Piece Worker");
			System.out.print("Please input (1~4, -1 to end): ");
			int i=input.nextInt();
			Employee employee=null;
			if(i==1)
			{
				employee=new SalariedEmployee();
			}
			else if (i==2)
			{
				employee=new HourlyEmployee();
			}
			else if(i==3)
			{
				employee=new CommissionEmployee();
			}
			else if(i==4)
			{
				employee=new PieceWorker();
			}
			else //if i==-1 stop inputting
			{
				break;
			}
			inputEmployeeData(employee);//input the data to the list
		}
			System.out.println("Input finished!");
			System.out.println();
			System.out.println("---Result:");
			int totalEarnings=0;
			int totalBonus=0;
			int j;
			for(j=0;j<list.size();)
			{
				Employee currentEmployee=list.get(j);
				j++;
				totalEarnings+=currentEmployee.getEarnings();
				totalBonus+=currentEmployee.getBonus().getBonus(currentEmployee.getEarnings());
				System.out.printf("No. %d:%n",j);
				System.out.printf("%s%n",currentEmployee);
			}
			System.out.println();
			//print the sum of earnings and bonus
			System.out.printf("Total earnings: %d\n",totalEarnings);
			System.out.printf("Total bonus: %d\n",totalBonus);
	}
	

	public void inputEmployeeData(Employee employee) {
		employee.inputData(input);
		setBonus(employee);
		list.add(employee);
		System.out.println();
	}

	public void setBonus(Employee employee) {
		// TODO
		System.out.print("Please input type of Bonus (1: static, 2: dynamic): ");
		int i=input.nextInt();
		Bonus bonus;
		if(i==1)
		{
			bonus=new StaticBonus();
		}
		else
		{
			bonus=new DynamicBonus();
		}
		employee.setBonus(bonus);
	}
}
