package Shop.Tests;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import bagisto.automationFramework.*;
import Shop.TestComponents.*;
import velocity.pageobjects.*;

public class CustomerCheckout extends baseTest {

	//CustomerplaceOrder(HashMap<String, String> input) // if getting data from json file
	//@Test(dataProvider = "getTestData", retryAnalyzer = Retry.class)
	@Test(dataProvider = "getTestData")
	public void CustomerplaceOrder(String email,String password,String productName) throws IOException, InterruptedException {
		//input.get("productName") if data is getting from json file // productName .json file m key ka name h.
		ProductListing ProductListingObj = launcVelocity();
		CustomerLogin CustomerLoginobj = ProductListingObj.addProductToCart(productName);
		//CustomerLogin CustomerLoginobj = ProductListingObj.addProductToCart(productName);
		CustomerLoginobj.goToLoginPage();
		CustomerLoginobj.customerLogin(email,password);	
		AbstractComponent AbstractObj  = new AbstractComponent(driver);//
		AbstractObj.clickOnCartIcon();
		AbstractObj.gotoCartPage();
		CartPriceVerify CartPagobj = new CartPriceVerify(driver);
		CartPagobj.calCulatePrice();
		
		
		
	}

	// By using DataProvider the above placeOrder Test should be run for each test
	// data of JSON/HashMap/Object
	@DataProvider
	public Object[][] getTestData(){	
		
		return new Object[][] {{"tom@example.com","tom123","Men's Bomber"}};
	}
	
	
	/* if getting the testdata from json file then use this method.
	 * public Object[][] getTestData() throws IOException {
		// We can use Object,HashMap and JSON file for send data
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Shop//TestData//TestData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
		//if in TestData.json file thre will be multiple set of data then then test will multiple time with different-2. data.
		
	}*/

}
