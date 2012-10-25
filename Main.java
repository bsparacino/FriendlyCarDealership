import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.*;
import java.util.ArrayList;

public class Main {
		
	private static String OPTIONS = "1. View Sales\n2. View Customers\n3. View Employees\n4. View Vehicles" + 
			"\n5. Add Customer\n6. Add Employee\n7. View Reports\n8. Reload All Data\n9. Exit";

	private static String OPTIONS_VEHICLES = "1. View All\n2. View New\n3. View Used\n4. View >$20,000" + 
			"\n5. Main Menu";

	private static String OPTIONS_REPORTS = "1. Vehicle Report\n2. Salesperson Report\n3. Sales Report" + 
			"\n4. Main Menu";
			
	public static void main(String[] args)
	{	
		Database db = new Database();
		boolean exit = false;
		
		while( !exit )
		{
			//clear();
			System.out.println("\n-------- Friendly Car Dealership ------------\n");
			System.out.println("Enter a numeric option:");
			System.out.println(OPTIONS);
			
			try {
				Scanner scan = new Scanner(System.in);
				int option = scan.nextInt();

				clear();

				if ( option == 1)
				{
					System.out.println("-------- Sales ------------\n");
					ArrayList<Sale> sales = db.getReportSales();
					Main.printSales(sales);
				} else if ( option == 2)
				{
					System.out.println("-------- Customers ------------\n");
					ArrayList<Customer> customers = db.getCustomers();
					Main.printCustomers(customers);
				} else if ( option == 3 )
				{
					System.out.println("-------- Employees ------------\n");
					ArrayList<Employee> employees = db.getEmployees();
					Main.printEmployees(employees);
				} else if ( option == 4 )
				{

					System.out.println("-------- Vehicles ------------\n");
					System.out.println(OPTIONS_VEHICLES);

					scan = new Scanner(System.in);
					option = scan.nextInt();
					
					if(option == 1)
					{
						ArrayList<Vehicle> vehicles = db.getVehicles("");
						Main.printVehicles(vehicles);
					}
					else if(option == 2)
					{
						ArrayList<Vehicle> vehicles = db.getVehicles("SELECT * FROM vehicle WHERE new_used='new'");
						Main.printVehicles(vehicles);
					}
					else if(option == 3)
					{
						ArrayList<Vehicle> vehicles = db.getVehicles("SELECT * FROM vehicle WHERE new_used='used'");
						Main.printVehicles(vehicles);
					}
					else if(option == 4)
					{
						ArrayList<Vehicle> vehicles = db.getVehicles("SELECT * FROM vehicle WHERE sticker_price>=20000");
						Main.printVehicles(vehicles);
					}
					else if(option == 5)
					{
						clear();
					}


				} else if ( option == 5 )
				{
					System.out.println("-------- New Customer ------------\n");
					String[] customer = Main.enterCustomer();
					db.insertCustomer(customer[0], customer[1], customer[2], customer[3],
						customer[4], customer[5], customer[6],
						Integer.parseInt(customer[7]));
				} else if ( option == 6 )
				{	
					System.out.println("-------- New Employee ------------\n");
					String[] employee = Main.enterEmployee();
					db.insertEmployee(employee[0], employee[1], employee[2],
						employee[3], employee[4], employee[5], employee[6],
						Integer.parseInt(employee[7]), employee[8]);
				} else if ( option == 7 )
				{	

					System.out.println("-------- View Reports ------------\n");
					System.out.println(OPTIONS_REPORTS);

					scan = new Scanner(System.in);
					option = scan.nextInt();
					
					if(option == 1) // vehicle report
					{
						//String report = db.getReportVehicle();
						//System.out.println(report);
					}
					else if(option == 2) // salesperson report
					{
						//String report = db.getReportSalesperson();
						//System.out.println(report);
					}
					else if(option == 3) // sales report
					{
						ArrayList<Sale> sales = db.getReportSales();
						Main.printSales(sales);
					}

				} else if ( option == 8 )
				{
					db.reloadAllData();
				} else if ( option == 9 )
				{
					exit = true;
					db.close();
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
		
		System.out.println("Enter gender (M or F):");
		customer[2] = sc.nextLine();
		
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
		
		System.out.println("Enter Enter gender (M or F):");
		customer[2] = sc.nextLine();
		
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
		
		System.out.println("Enter employee position:");
		customer[8] = sc.nextLine();
		
		return customer;
	}
	
	private static void printCustomers(ArrayList<Customer> customers) {
		System.out.println("id\tFirst Name\tLast Name\tGender\tDOB\tAddress\tCity\tState\tZip");
		
		for( Customer c : customers )
		{
			System.out.println(c);
		}
	}
	
	private static void printSales(ArrayList<Sale> sales) {
		System.out.println("id\tTax\tFee\tPrice\tDate\t\tVIN\t\t\tCustomer\t\tSalesperson");
		
		for( Sale s : sales )
		{
			System.out.println(s);
		}
	}
	
	private static void printEmployees(ArrayList<Employee> employees) {
		System.out.println("id\tFirst Name\tLast Name\tGender\tDOB\tPosition\tAddress\tCity\tState\tZip");
		
		for( Employee e : employees )
		{
			System.out.println(e);
		}
	}
	
	private static void printVehicles(ArrayList<Vehicle> vehicles) {
		System.out.println("id\tvin\tInvoice Price\tSticker Price\tNew/Used\tYear\tMake\tModel\tTrim\tMileage\tColor\tDate in Stock");
		
		for( Vehicle v : vehicles )
		{
			System.out.println(v);
		}
	}

	private static void clear()
	{
		System.out.print("\033[2J\033[1;1H");
	}
	
}