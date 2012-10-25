public class Customer
{
	public int id;
	public String first_name;
	public String last_name;
	public String gender;
	public String dob;
	public String address;
	public String city;
	public String state;
	public int zip;

	public Customer(int id, String first_name, String last_name, String gender, String dob, String address, String city, String state, int zip)
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public String toString()
	{
		return id +"\t"+ first_name +"\t\t"+ last_name +"\t\t"+ gender +"\t"+ dob +"\t"+ address +"\t"+ city +"\t"+ state +"\t"+ zip;
		
	}
}