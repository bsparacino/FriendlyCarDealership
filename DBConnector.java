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
            ResultSet rs = stmt.executeQuery("SELECT * FROM vehicle");

            while (rs.next()) {
                System.out.println(rs.getString("make"));
            }
        } catch (SQLException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
                return;
            }
    }

    public static void main(String [] args){
        DBConnector connector = new DBConnector("p48501e","p48501e","FriendlyGroup5Cars");
        connector.getStuff();
    }
}