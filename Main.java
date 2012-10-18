import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
		
	private static String OPTIONS = "1. View Sales\n2. View Customers\n3. View Employees\n4. View Vehicles" + 
			"\n5. Add Customer\n6. Add Employee\n7. Exit";
			
	public static void main(String[] args)
	{
		System.out.println("Friendly Car Dealership");
		
		boolean exit = false;
		
		while( !exit )
		{
			System.out.println("Enter a numeric option:");
			System.out.println(OPTIONS);
			
			try {
				Scanner scan = new Scanner(System.in);
				int option = scan.nextInt();
			
				if ( option == 1)
				{
				} else if ( option == 2)
				{
				} else if ( option == 3 )
				{
				} else if ( option == 4 )
				{
				} else if ( option == 5 )
				{
					String[] customer = Main.enterCustomer();
				} else if ( option == 6 )
				{	
					String[] employee = Main.enterEmployee();
				} else if ( option == 7 )
				{
					exit = true;
				} else
				{
					System.out.println("Please enter a number listed above");
				}
			} catch ( InputMismatchException e ) {
				System.out.println("Option input must be a number");
			}
		}
	}
	
	// Method for retrieving customer information to enter into the DB
	private static String[] enterCustomer() {
		String[] customer = new String[8];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first name:");
		customer[0] = sc.nextLine();
		
		System.out.println("Enter last name:");
		customer[1] = sc.nextLine();
		
		System.out.println("Enter date of birth (e.g. 1990-04-30:");
		customer[3] = sc.nextLine();
		
		System.out.println("Enter address:");
		customer[4] = sc.nextLine();
		
		System.out.println("Enter city:");
		customer[5] = sc.nextLine();
		
		System.out.println("Enter state:");
		customer[6] = sc.nextLine();
		
		System.out.println("Enter zip code:");
		customer[7] = sc.nextLine();
		
		return customer;
	}
	
	// Method for retrieving employee information to enter into the DB
	private static String[] enterEmployee() {
		String[] customer = new String[9];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first name:");
		customer[0] = sc.nextLine();
		
		System.out.println("Enter last name:");
		customer[1] = sc.nextLine();
		
		System.out.println("Enter date of birth (e.g. 1990-04-30:");
		customer[3] = sc.nextLine();
		
		System.out.println("Enter employee position:");
		customer[4] = sc.nextLine();
		
		System.out.println("Enter address:");
		customer[5] = sc.nextLine();
		
		System.out.println("Enter city:");
		customer[6] = sc.nextLine();
		
		System.out.println("Enter state:");
		customer[7] = sc.nextLine();
		
		System.out.println("Enter zip code:");
		customer[8] = sc.nextLine();
		
		return customer;
	}
}