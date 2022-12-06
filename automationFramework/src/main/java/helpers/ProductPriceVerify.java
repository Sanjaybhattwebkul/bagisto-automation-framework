package helpers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bagisto.automationFramework.AbstractComponent;

public class ProductPriceVerify extends AbstractComponent{
	
	WebDriver driver;
	public ProductPriceVerify(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement lastProductID;
	
	/*
	 * @String
	 * get Last created  product's ID	
	 */
	public String getCreatedProductId() {
		return lastProductID.getText();
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

}
