package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;

import baseComponent.*;
import baseComponents.*;
import velocity.pageobjects.*;

public class CustomerCheckoutTest extends BaseTest {

	//CustomerplaceOrder(String userName ,String Password) // if getting data from object file	
	//@Test(dataProvider = "getTestData", retryAnalyzer = Retry.class)
	@Test(dataProvider = "getTestData", retryAnalyzer = Retry.class)
	public void CustomerplaceOrder(HashMap<String, String> input) throws IOException, InterruptedException, AWTException {
		//input.get("productName") if data is getting from JSON file // productName .json file m key ka name h.
		HomePageRepository ProductListingObj = launcVelocity();
		ProductListingObj.viewProduct(1);
		ProductListingObj.selectOptions();
		CustomerRepository CustomerLoginobj = ProductListingObj.addProductTo("CART",1);		
		CustomerLoginobj.goToLoginPage();
		CustomerLoginobj.customerLogin(input.get("email"),input.get("password"));	
		BaseRepository AbstractObj  = new BaseRepository(driver);//
		AbstractObj.clickOnCartIcon();
		CartRepository CartPagobj = AbstractObj.gotoCartPage();		
		CartPagobj.calCulatePrice();
		CheckoutRepository CheckoutObject = CartPagobj.processToCheckout();
		CheckoutObject.placeOrder();
	}

	
	/*
	 * We can provide the data by using JSON/HashMap/Object
	 */
	/*@DataProvider
	public Object[][] getTestData(){	
		
		return new Object[][] {{"sanjay.bhatt371@webkul.com","admin123","jackaet"}};
	}*/
	
	

}
