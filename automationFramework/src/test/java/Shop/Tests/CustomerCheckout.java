package Shop.Tests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Shop.TestComponents.baseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import velocity.pageobjects.CustomerLogin;
import velocity.pageobjects.LandingPage;
import velocity.pageobjects.ProductListing;

public class CustomerCheckout extends baseTest{
	
	ExtentReports extentObj;
	
	@BeforeSuite
	public void extentReportConfig()
	{
		String path = System.getProperty("user.dir")+"//Reports//report.html"; // Create Report folder and report.html file
		ExtentSparkReporter report = new ExtentSparkReporter(path); //this will create a report.html file inside the REports folder that will graphically representetion of test Result.
		report.config().setReportName("Bagisto Shop Test Extent Report"); // set report Name 
		report.config().setDocumentTitle("Bagisto Shop ExtentReport"); // Set Page title <title>TestNg ExtentReport</title>
		extentObj = new ExtentReports(); // this  will create a extentRepoet by using all configuration  doen by the ExtentSparkReporter class.
		extentObj.attachReporter(report);  // ExtentSparkReporter se kiye gre sare configuration [reportName,fileName,reportName etc.] ye yha p use kr k report banate hai.
		extentObj.setSystemInfo("Full Stack QA", "Sanjay Bhatt Bagisto");
	}
	
	@Test(dataProvider= "getTestData")
	public void placeOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		//String productName = "Sunglasses"; [now productName value will get from HashMap] 
		//String[] loginCredential= {"tom@example.com","tom123"};	[now login Credentials will get from HashMap]
		
		extentObj.createTest("Customer Checkout"); // ExtentReport bnayega or Test Name Inital Test hoga
		
		ProductListing ProductListingObj = launcVelocity();
		CustomerLogin CustomerLoginobj = ProductListingObj.addProductToCart(input.get("productName"));		
		CustomerLoginobj.goToLoginPage();
		LandingPage LandingPageObj = CustomerLoginobj.customerLogin(input);
		LandingPageObj.goToCartPage();
		extentObj.flush();
		
	}     
	
	
	// By using DataProvider the above placeOrder Test should be run for each test data of JSON/HashMap/Object
	@DataProvider
	public Object[][] getTestData() throws IOException {
		// We can use Object,HashMap and JSON file for send data 
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Shop//TestData//TestData.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
	}

}
