import java.util.Scanner;
import java.util.InputMismatchException;
import java.sql.*;
import java.util.ArrayList;

public class Main {
		
	private static String OPTIONS = "1. View Sales\n2. View Customers\n3. View Employees\n4. View Vehicles" + 
			"\n5. Add Customer\n6. Add Employee\n7. Exit";
			
	public static void main(String[] args)
	{
		System.out.println("Friendly Car Dealership");
		
		Database db = new Database();
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
					/**ArrayList<Sales> sales = db.getSales();
					Main.printSales(sales);**/
				} else if ( option == 2)
				{
					ArrayList<Customer> customers = db.getCustomers();
					Main.printCustomers(customers);
				} else if ( option == 3 )
				{
					ArrayList<Employee> employees = db.getEmployees();
					Main.printEmployees(employees);
				} else if ( option == 4 )
				{
					ArrayList<Vehicle> vehicles = db.getVehicles();
					Main.printVehicles(vehicles);
				} else if ( option == 5 )
				{
					String[] customer = Main.enterCustomer();
					/**db.insertCustomer(customer[0], customer[1], customer[2],
						customer[3], customer[4], customer[5], customer[6],
						Integer.parseInt(customer[7]));**/
				} else if ( option == 6 )
				{	
					String[] employee = Main.enterEmployee();
					/**db.insertEmployee(customer[0], customer[1], customer[2],
						customer[3], customer[4], customer[5], customer[6],
						customer[7], Integer.parseInt(customer[8]));**/
				} else if ( option == 7 )
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
	
	private static void printCustomers(ArrayList<Customer> customers) {
		System.out.println("id\tFirst Name\tLast Name\tDOB\tAddress\tCity\tState\tZip");
		
		for( Customer c : customers )
		{
			System.out.println(c);
		}
	}
	
	private static void printSales(ArrayList<Sale> sales) {
		System.out.println("id\tCustomer id\tEmployee id\tVehicle id\tTax\tFee\tPrice\tDate");
		
		for( Sale s : sales )
		{
			System.out.println(s);
		}
	}
	
	private static void printEmployees(ArrayList<Employee> employees) {
		System.out.println("id\tFirst Name\tLast Name\tDOB\tPosition\tAddress\tCity\tState\tZip");
		
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
	
}