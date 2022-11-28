package jdbc;
import java.io.*;
import java.sql.*;

public class database {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String dbClass = "com.mysql.jdbc.Driver";

		//Class.forName("com.mysql.jdbc.Driver");

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		System.out.println("Driver JDBC loaded!");

		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bagisto", "root", "webkul");       

		Statement s = con.createStatement();     

		ResultSet rs = s.executeQuery("Select * from admins Where name ='Example';");

		while(rs.next())

		{

		   System.out.println(rs.getString("Name")); 
		   System.out.println(rs.getString("email")); 

		}   
	}

}
