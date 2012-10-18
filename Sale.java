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
	
	public String toString()
	{
		return id +"\t"+ customer_id +"\t"+ employee_id +"\t"+ vehicle_id +"\t"+ tax +"\t"+ fee +"\t"+ price +"\t"+ date;
	}
}