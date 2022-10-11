package Shop.Tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Shop.TestComponents.baseTest;

import java.io.IOException;
import java.util.HashMap;

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
	
	
	// By using DataProvider the above placeOrder Test should be run for each test data of HashMap
	@DataProvider
	public Object[][] getTestData() {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email","tom@example.com");
		map.put("password","tom123");
		map.put("productName", "Sunglasses");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email","user@example.com");
		map1.put("password","admin123");
		map1.put("productName", "Men's Bomber");
		
		return new Object[][] {{map},{map1}};
	}

}
