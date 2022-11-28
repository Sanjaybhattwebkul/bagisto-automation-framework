package admin.pageobjects;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bagisto.automationFramework.AbstractComponent;

public class LoginPageObject extends AbstractComponent{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory TestNG ka part h is se annotation use kr skte h.
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(css="button[class='btn btn-xl btn-primary']")
	WebElement loginButton;
	
	public void adminLogin(String adminEmail, String adminPassword) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {		
		System.out.println(getCredentialsFromDB().get(0));
		email.sendKeys(getCredentialsFromDB().get(0));
		Password.sendKeys(adminPassword);
		loginButton.click();
	}
	
	public ArrayList<String> getCredentialsFromDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ArrayList<String> adminCredentials = new ArrayList<String>();
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.println("Driver JDBC loaded!");
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bagisto", "root", "webkul");       
		Statement s = con.createStatement();   
		ResultSet rs = s.executeQuery("Select * from admins Where name ='Example';");
		while(rs.next()) {
			adminCredentials.add(rs.getString("email"));
		   //System.out.println(rs.getString("Name")); 
		   //System.out.println(rs.getString("email")); 
		}  
		return adminCredentials;
	}
	
}
