public class Vehicle
{
	int id;
	String vin;
	int invoice_price;
	int sticker_price;
	String new_used;
	int year;
	String make;
	String model;
	String trim;
	int mileage;
	String color;
	String date_in_stock;


	public Vehicle(int id, String vin, int invoice_price, int sticker_price, String new_used, int year, String make, String model, String trim, int mileage, String color, String date_in_stock)
	{
		this.id = id;
		this.vin = vin;
		this.invoice_price = invoice_price;
		this.sticker_price = sticker_price;
		this.new_used = new_used;
		this.year = year;
		this.make = make;
		this.model = model;
		this.trim = trim;
		this.mileage = mileage;
		this.color = color;
		this.date_in_stock = date_in_stock;
	}
	
	public String toString()
	{
		return id +"\t"+ vin +"\t"+ invoice_price +"\t"+ sticker_price +"\t"+ new_used +"\t"+ year +"\t"+ make +"\t"+ model +"\t"+ trim +"\t"+ mileage +"\t"+ color +"\t"+ date_in_stock;
	}
}