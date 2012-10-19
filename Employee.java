public class Employee
{
	int id;
	String first_name;
	String last_name;
	String gender;
	String dob;
	String address;
	String city;
	String state;
	int zip;
	String position;

	public Employee(int id, String first_name, String last_name, String gender, String dob, String address, String city, String state, int zip, String position)
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = state;
		this.zip = zip;
		this.position = position;
	}
	
	public String toString()
	{
		return id +"\t"+ first_name +"\t\t"+ last_name +"\t\t"+ dob +"\t"+ position +"\t"+ address +"\t"+ city +"\t"+ state +"\t"+ zip;
		
	}
}