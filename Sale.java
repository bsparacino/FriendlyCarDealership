public class Sale
{
	public int id;
	public int customer_id;
	public int employee_id;
	public int vehicle_id;
	public int tax;
	public int fee;
	public int price;
	public String date;

	public String vin;
	public String cust_first_name;
	public String cust_last_name; 
	public String emp_first_name;
	public String emp_last_name; 

	public Sale(int id, int customer_id, int employee_id, int vehicle_id, int tax, int fee, int price, String date)
	{
		this.id = id;
		this.customer_id = customer_id;
		this.employee_id = employee_id;
		this.vehicle_id = vehicle_id;
		this.tax = tax;
		this.fee = fee;
		this.price = price;
		this.date = date;
	}

	public Sale(int id, int tax, int fee, int price, String date, String vin, String cust_first_name, String cust_last_name, String emp_first_name, String emp_last_name)
	{
		this.id = id;
		this.tax = tax;
		this.fee = fee;
		this.price = price;
		this.date = date;

		this.vin = vin;
		this.cust_first_name = cust_first_name;
		this.cust_last_name = cust_last_name;
		this.emp_first_name = emp_first_name;
		this.emp_last_name = emp_last_name;
	}
	
	public String toString()
	{
		//return id +"\t"+ customer_id +"\t\t"+ employee_id +"\t\t"+ vehicle_id +"\t\t"+ tax +"\t"+ fee +"\t"+ price +"\t"+ date;
		return id +"\t"+ tax +"\t"+ fee +"\t"+ price +"\t"+ date+"\t"+ vin+"\t"+ cust_first_name+" "+cust_last_name+"\t\t"+ emp_first_name+" "+emp_last_name;
	}
}