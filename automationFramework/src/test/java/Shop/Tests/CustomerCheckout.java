package Shop.Tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Shop.TestComponents.baseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import velocity.pageobjects.CustomerLogin;
import velocity.pageobjects.LandingPage;
import velocity.pageobjects.ProductListing;

public class CustomerCheckout extends baseTest{
	
	@Test(dataProvider= "getTestData")
	public void placeOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		//String productName = "Sunglasses"; [now productName value will get from HashMap] 
		//String[] loginCredential= {"tom@example.com","tom123"};	[now login Credentials will get from HashMap]
		
		ProductListing ProductListingObj = launcVelocity();
		CustomerLogin CustomerLoginobj = ProductListingObj.addProductToCart(input.get("productName"));		
		CustomerLoginobj.goToLoginPage();
		LandingPage LandingPageObj = CustomerLoginobj.customerLogin(input);
		LandingPageObj.goToCartPage();
		
	}     
	
	
	// By using DataProvider the above placeOrder Test should be run for each test data of JSON/HashMap/Object
	@DataProvider
	public Object[][] getTestData() throws IOException {
		// We can use Object,HashMap and JSON file for send data 
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Shop//TestData//TestData.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
	}

}
