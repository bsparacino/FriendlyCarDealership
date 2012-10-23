import java.sql.*;
import java.io.FileReader;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import java.util.ArrayList;
 
public class Database
{

	public Connection connection = null;

	public static void main(String[] argv)
	{
		Database dbase = new Database();
		dbase.loadData("vehicle");
		dbase.loadData("customer");
		dbase.loadData("employee");
		dbase.loadData("option");

		//dbase.getCustomer(2);
		//dbase.getVehicle(2);
		//dbase.getEmployee(2);
		//dbase.getOption(2);
		
		/*
		ArrayList<Vehicle> vehicles = dbase.getVehicles("");
		for( Vehicle v : vehicles )
		{
			System.out.println(v.id+" "+v.make+" "+v.model);
		}
		*/

		dbase.close();
	}

	public Database()
	{
		connect();
	}

	public void close()
	{
		try { connection.close(); } catch (SQLException e) { e.printStackTrace(); }
	}

	public boolean connect()
	{

		//System.out.println("-------- PostgreSQL " + "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return false;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");		
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/p48501e", "p48501e",
					"FriendlyGroup5Cars");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
 
		}
 
		if (connection != null) {
			System.out.println("Connected");
			return true;
		} else {
			System.out.println("Failed to make connection!");
			return false;
		}

	}

	public void loadData(String tableName)
	{
		try
		{
			Statement stmt = connection.createStatement();
			stmt.execute("TRUNCATE TABLE "+tableName);
			stmt.close();

			CopyManager copyManager = new CopyManager((BaseConnection) connection);
			FileReader fileReader = new FileReader("//home/group/s485/p485-01e/cars/"+tableName+".csv");
			copyManager.copyIn("COPY "+tableName+" FROM STDIN DELIMITERS ',' CSV HEADER", fileReader );

		} catch (Exception e) { e.printStackTrace(); }
	}

	public void reloadAllData()
	{
		this.loadData("vehicle");
		this.loadData("customer");
		this.loadData("employee");
		this.loadData("option");
		this.loadData("sales");
	}

	public ArrayList<Customer> getCustomers()
	{

		ArrayList<Customer> list = new ArrayList<Customer>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			
			while (rs.next())
			{
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String gender = rs.getString("gender");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				
				list.add(new Customer(id, first_name, last_name, gender, dob, address, city, state, zip));
			} 
			
			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }
		
		return list;
	}

	public ArrayList<Customer> getCustomer(int id_val)
	{

		ArrayList<Customer> list = new ArrayList<Customer>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id="+id_val);

			while (rs.next())
			{
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String gender = rs.getString("gender");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				
				list.add(new Customer(id, first_name, last_name, gender, dob, address, city, state, zip));
			}

			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}

	public ArrayList<Employee> getEmployees()
	{

		ArrayList<Employee> list = new ArrayList<Employee>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

			while (rs.next())
			{
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String gender = rs.getString("gender");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				String position = rs.getString("position");

				list.add(new Employee(id, first_name, last_name, gender, dob, address, city, state, zip, position));
			}
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}

	public ArrayList<Employee> getEmployee(int id_val)
	{

		ArrayList<Employee> list = new ArrayList<Employee>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE id="+id_val);

			while (rs.next())
			{
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String gender = rs.getString("gender");
				String dob = rs.getString("dob");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				String position = rs.getString("position");

				list.add(new Employee(id, first_name, last_name, gender, dob, address, city, state, zip, position));
			}
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}
 
	public ArrayList<Vehicle> getVehicles(String query)
	{

		if(query.equals("")) query = "SELECT * FROM vehicle";

		ArrayList<Vehicle> list = new ArrayList<Vehicle>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next())
			{
				int id = rs.getInt("id");
				String vin = rs.getString("vin");
				int invoice_price = rs.getInt("invoice_price");
				int sticker_price = rs.getInt("sticker_price");
				String new_used = rs.getString("new_used");
				int year = rs.getInt("year");
				String make = rs.getString("make");
				String model = rs.getString("model");
				String trim = rs.getString("trim");
				int mileage = rs.getInt("mileage");
				String color = rs.getString("color");
				String date_in_stock = rs.getString("date_in_stock");

				list.add(new Vehicle(id, vin, invoice_price, sticker_price, new_used, year, make, model, trim, mileage, color, date_in_stock));
			}

			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}

	public ArrayList<Vehicle> getVehicle(int id_val)
	{

		ArrayList<Vehicle> list = new ArrayList<Vehicle>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM vehicle WHERE id="+id_val);

			while (rs.next())
			{
				int id = rs.getInt("id");
				String vin = rs.getString("vin");
				int invoice_price = rs.getInt("invoice_price");
				int sticker_price = rs.getInt("sticker_price");
				String new_used = rs.getString("new_used");
				int year = rs.getInt("year");
				String make = rs.getString("make");
				String model = rs.getString("model");
				String trim = rs.getString("trim");
				int mileage = rs.getInt("mileage");
				String color = rs.getString("color");
				String date_in_stock = rs.getString("date_in_stock");

				list.add(new Vehicle(id, vin, invoice_price, sticker_price, new_used, year, make, model, trim, mileage, color, date_in_stock));
			}

			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}

	public ArrayList<Option> getOptions()
	{

		ArrayList<Option> list = new ArrayList<Option>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM option");

			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				list.add(new Option(id, name, price));
			}

			stmt.close();			
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}

	public ArrayList<Option> getOption(int id_val)
	{

		ArrayList<Option> list = new ArrayList<Option>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM option WHERE id="+id_val);

			while (rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");

				list.add(new Option(id, name, price));
			}

			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}	

	public void insertVehicle()
	{
		try
		{			
			String query = "INSERT INTO teams (id,name,abbr,division,meet_id) VALUES (?,?,?,?,?)";
			System.out.println(query);
		    PreparedStatement pstmt = connection.prepareStatement(query);
	    } catch (SQLException e) { e.printStackTrace(); }
	}

	public ArrayList<Sale> getReportVehicle()
	{

		// list of vehicles that sold only

		ArrayList<Sale> list = new ArrayList<Sale>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM sales");

			while (rs.next())
			{
				int id = rs.getInt("id");
				int customer_id = rs.getInt("customer_id");
				int employee_id = rs.getInt("employee_id");
				int vehicle_id = rs.getInt("vehicle_id");
				int tax = rs.getInt("tax");
				int fee = rs.getInt("fee");
				int price = rs.getInt("price");
				String date = rs.getString("date");

				//list.add(new Sale(id, name, price));
			}

			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}	

	public String getReportSalesperson()
	{

		return "";
	}

	public ArrayList<Sale> getReportSales()
	{

		ArrayList<Sale> list = new ArrayList<Sale>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sales.id,sales.tax,sales.fee,sales.price,sales.date,vehicle.vin,customer.first_name AS cust_first_name,customer.last_name AS cust_last_name,employee.first_name AS emp_first_name,employee.last_name AS emp_last_name FROM sales,vehicle,customer,employee WHERE sales.vehicle_id=vehicle.id AND sales.customer_id=customer.id AND sales.employee_id=employee.id");

			while (rs.next())
			{
				int id = rs.getInt("id");
				int tax = rs.getInt("tax");
				int fee = rs.getInt("fee");
				int price = rs.getInt("price");
				String date = rs.getString("date");
				String vin = rs.getString("vin");
				String cust_first_name = rs.getString("cust_first_name");
				String cust_last_name = rs.getString("cust_last_name");
				String emp_first_name = rs.getString("emp_first_name");
				String emp_last_name = rs.getString("emp_last_name");

				//list.add(new Sale(id, customer_id, employee_id, vehicle_id, tax, fee, price, date));
				list.add(new Sale(id, tax, fee, price, date, vin, cust_first_name, cust_last_name, emp_first_name, emp_last_name));

			}

			stmt.close();
			
	  	} catch (SQLException e) { e.printStackTrace(); }

	  	return list;
	}	

}