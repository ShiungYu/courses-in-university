import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class MaskJsonHandlerTest {
	public static void main(String[] args) {
		String zone = "";
		String keyword = "";
		Scanner input=new Scanner(System.in);
		System.out.print("Please input a zone: ");
		zone=input.nextLine();
		System.out.print("Please input a keyword of the pharmacy that you want to search for: ");
		keyword=input.nextLine();
		List<Pharmacy> filteredClinicList;

		try {
			MaskJsonHandler handler = new MaskJsonHandler();
			handler.initialize();
			
			// A Test Case: 
			
			filteredClinicList = handler.findPharmacies(keyword,zone);			
			System.out.println(filteredClinicList.get(0)); 
			System.out.println();			

			// input.close();

		} catch (IOException | IndexOutOfBoundsException e) {
			System.err.println("Error: " + e);
		}
	}
}