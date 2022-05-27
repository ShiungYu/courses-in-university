
import java.util.InputMismatchException;
import java.util.Scanner;

public class FuelCalculator {

	private static final GasStationBrand[] BRANDS = { null, new GasStationBrand("CPC", "Chinese Petroleum Corporation"),
			new GasStationBrand("FPCC", "Formosa Petrochemical Corporation"),
			new GasStationBrand("Costco", "Costco Wholesale") };

	public void calculateFuelUnitPrice() {
		boolean continueloop=true;
		do
		{
		try
		{

			Scanner scanner = new Scanner(System.in);

			System.out.printf("%nPlease enter the cost of gasoline: ");
			int numerator = scanner.nextInt();
			System.out.print("Please enter the liters of gasoline: ");
			double denominator = scanner.nextDouble();
			System.out.print("Please enter the brand (1: CPC, 2: FPCC, 3: Costco): ");
			int brandNumber = scanner.nextInt();

			String brandName = BRANDS[brandNumber].getName();
			FuelRecord record = new FuelRecord(numerator, denominator, brandName);
			double result = record.costPerLiter();

			System.out.printf("Cost per liter of fuel for %s: %d / %.2f = %.2f%n", brandName, record.getFuelCost(),
					record.getLiters(), result);

			scanner.close();
			continueloop=false;
		}
		catch (InputMismatchException inputMismatchException)//input the non integer
		{
			System.err.printf("%nException: %s%n",inputMismatchException);
			System.out.println("You must enter integers. Please try again.");
		}
		catch(ArithmeticException arithmeticException)//liters pf gasollne is 0
		{
			System.err.printf("%nException: %s%n",arithmeticException);
			System.out.println("liters of gasoline cannot be 0");
		}
		catch(ArrayIndexOutOfBoundsException arrayIndexOutofBoundsException)//input wroung brands
		{
			System.err.printf("%nException: %s%n",arrayIndexOutofBoundsException);
			System.out.println("Only have three brands. Please enter 1~3");
		}
		catch(IllegalArgumentException illegalArgumentException)//the costs or liters isn't positive
		{
			System.err.printf("%nException: %s%n",illegalArgumentException);
			System.out.println("the costs and the liters need to be positive");
		}
		}while(continueloop);
		System.out.println("Thank you for the test!");

	}

}
