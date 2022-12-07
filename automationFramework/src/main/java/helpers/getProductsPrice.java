package helpers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;
import bagisto.automationFramework.AbstractComponent;

public class getProductsPrice extends AbstractComponent{
	
	WebDriver driver;
	public getProductsPrice(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
	}
	
	/*
	 * @ResultSet
	 * get data from database
	 */
	public ResultSet getProductPriceFromDB(String tableName,int productID,int customerGroupID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		System.out.println("Select * from "+tableName+" Where product_id  ='"+productID+"' AND customer_group_id='"+customerGroupID+"';");
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Driver JDBC loaded!");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bagisto_automation", "root", "webkul");       
		Statement s = con.createStatement();   
		ResultSet data = s.executeQuery("Select * from "+tableName+" Where product_id  ='"+productID+"' AND customer_group_id='"+customerGroupID+"';");		 
		return data;
	}
	
	/*
	 * @double
	 * Remove $ and , from the price and return the actual price
	 */
	public double getActualPrice(String price) {
		double amount=0;
		String itemPrice =	removeComma(price);// remove , from price	
		amount = Double.parseDouble(itemPrice); //convert string to double
		return amount;
		
	}
}
