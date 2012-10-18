public class Customer
{
	public int id;
	public String first_name;
	public String last_name;
	public String dob;
	public String address;
	public String city;
	public String state;
	public int zip;

	public Customer(int id, String first_name, String last_name, String dob, String address, String city, String state, int zip)
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.address = address;
		this.city = state;
		this.zip = zip;
	}
	
	public String toString()
	{
		return id +"\t"+ first_name +"\t"+ last_name +"\t"+ dob +"\t"+ address +"\t"+ city +"\t"+ state +"\t"+ zip;
		
	}
}