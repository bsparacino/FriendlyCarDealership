/**
 * File: DBConnector.java
 * David Wheeler
 * 
 * Communicates between the database 
 * and the command line interface
 */

import java.sql.*;

public class DBConnector {
    
    Connection connection = null;

    public DBConnector(String project, String username, String password){

        try {
 
            Class.forName("org.postgresql.Driver");
 
       	} catch (ClassNotFoundException e) {
 
            System.out.println("Where is your PostgreSQL JDBC Driver? "
		   + "Include in your library path!");
            e.printStackTrace();
            return;
 
       	}

        try { 
            connection = DriverManager.getConnection(
                         "jdbc:postgresql://127.0.0.1:5432/" + project,
                         username,password);
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }
    }

    public void getStuff(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name FROM customer");

            while (rs.next()) {
                System.out.println(rs.getString("first_name"));
            }
        } catch (SQLException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
                return;
            }
    }

    public void insertCustomer(String first_name, String last_name, 
                               String dob, String address, 
                               String city, String state,
                               int zip){

        try {
            String query = "INSERT INTO customer (first_name,last_name, dob, address," + 
                                          "city, state, zip) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, dob);
            pstmt.setString(4, address);
            pstmt.setString(5, city);
            pstmt.setString(6, state);
            pstmt.setInt(7, zip);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    public static void main(String [] args){
        DBConnector connector = new DBConnector("p48501e","p48501e","FriendlyGroup5Cars");
        connector.getStuff();
        connector.insertCustomer(
              "David", "Wheeler", "1990-05-13", "242 Farnum Ln", "Rochester", "NY", 14623);
        connector.getStuff();
    }
}