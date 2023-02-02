package helpers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;

import baseComponents.BaseRepository;

public class getProductsPrice extends BaseRepository{
	
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
		Class.forName("com.mysql.jdbc.Driver").newInstance();		
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bagisto_automation", "root", "webkul");       
		Statement s = con.createStatement();   
		ResultSet data = s.executeQuery("Select * from "+tableName+" Where product_id  ='"+productID+"' AND customer_group_id='"+customerGroupID+"';");		 
		System.out.println("Select * from "+tableName+" Where product_id  ='"+productID+"' AND customer_group_id='"+customerGroupID+"';");
		return data;
	}
	
}
