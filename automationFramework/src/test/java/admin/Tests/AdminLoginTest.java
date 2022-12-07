package admin.Tests;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import admin.pageobjects.LoginPageObject;
import baseComponent.BaseTest;


public class AdminLoginTest extends BaseTest {
	
	/**
	 * 
	 * We can call this method for testNG annotation from another class by its group name 
	 * 
	 */
	@Test(dataProvider = "getTestData",groups={"AdminLoginTest.login"})
	public void login(String password) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		LoginPageObject LoginPageObject = launcAdminPanel();
		System.out.println("db_Email="+getCredentialsFromDB().get(0));	
		LoginPageObject.adminLogin(getCredentialsFromDB().get(0),password);
		
	}
	
	/**
	 * 
	 * This Method is using @DataProvider annotation of testNG and provide data to login function.
	 * 
	 */
	@DataProvider
	public Object[][] getTestData(){			
		return new Object[][] {{"admin123"}};
	}
	
	/**
	 * 
	 * This method will get data from database and send to AdminLoginTest function.
	 * 
	 */

	@SuppressWarnings("deprecation")
	public ArrayList<String> getCredentialsFromDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<String> adminCredentials = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Driver JDBC loaded!");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bagisto", "root", "webkul");       
		Statement s = con.createStatement();   
		ResultSet rs = s.executeQuery("Select * from admins Where name ='Example';");
		while(rs.next()) {
			adminCredentials.add(rs.getString("email"));
			adminCredentials.add(rs.getString("password"));		   
		}  
		return adminCredentials;
	}
}
