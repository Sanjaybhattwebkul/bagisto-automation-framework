package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import abstraction.*;
import baseComponent.*;
import velocity.pageobjects.*;

public class CustomerCheckoutTest extends BaseTest {

	//CustomerplaceOrder(String userName ,String Password) // if getting data from object file	
	//@Test(dataProvider = "getTestData", retryAnalyzer = Retry.class)
	@Test(dataProvider = "getTestData", retryAnalyzer = Retry.class)
	public void CustomerplaceOrder(HashMap<String, String> input) throws IOException, InterruptedException, AWTException {
		//input.get("productName") if data is getting from JSON file // productName .json file m key ka name h.
		ProductListingRepository ProductListingObj = launcVelocity();
		ProductListingObj.viewProduct(1);
		ProductListingObj.selectOptions();
		CustomerLoginRepository CustomerLoginobj = ProductListingObj.addProductTo("CART",1);		
		CustomerLoginobj.goToLoginPage();
		CustomerLoginobj.customerLogin(input.get("email"),input.get("password"));	
		AbstractComponent AbstractObj  = new AbstractComponent(driver);//
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
	
	/*
	 * Getting the test data from JSON file then use this method. 
	 */
	@DataProvider
	public Object[][] getTestData() throws IOException {
		// We can use Object,HashMap and JSON file for send data
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Shop//TestData//TestData.json");
		return new Object[][] { { data.get(0) } }; // data.get(0) mtlb .JSON File ka 0th set of data.
		//if in TestData.json file thre will be multiple set of data then then test will run multiple time with different-2. data.
		
	}

}
