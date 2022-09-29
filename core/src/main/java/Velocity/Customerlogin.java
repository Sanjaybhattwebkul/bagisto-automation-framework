package Velocity;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Customerlogin extends bagissto.core.testCases{
	
	protected static WebDriver driver= new ChromeDriver();
	 
	@BeforeClass
	public static void configureBrowser() {
		configBrowserExe("/chromedriver"); 		
	}
	
	@Parameters({ "URL" })
	@Test(priority = 0)
	public void openBrowser(String URL) {
		openBrowser(driver,URL);	// URL from testNg.xml file
	}
	
	@Test(dependsOnMethods={"openBrowser", "waite"}, dataProvider="loginTestData" )	 
	public static void Login(String email, String password, String type) {		
		String[] loginLocators = {"div[class*='welcome-content']","//input[@name='email']","//input[@name='password']"};	
		testNgCustomerLogin(driver,loginLocators,email,password,type); // customer Login
		
	}
	
	@AfterMethod
	public static void testMethod(){
		System.out.println("I will run after every method");
	}
	
	@Test
	public static void waite() throws InterruptedException{
		Thread.sleep(2000);
	}
	
	@DataProvider
	public static Object[][] loginTestData() {	
		Object data[][]=new Object[3][3];
		data[0][0]="test@example.com";
		data[0][1]="password";
		data[0][2]="invalid";
		data[1][0]="tom@example.com";
		data[1][1]="tom123";
		data[1][2]="valid";
		return data;		
	}

}
