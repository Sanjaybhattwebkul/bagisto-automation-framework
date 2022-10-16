package Shop.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Shop.TestComponents.Retry;
import Shop.TestComponents.baseTest;
import velocity.pageobjects.CustomerLogin;
import velocity.pageobjects.LandingPage;
import velocity.pageobjects.ProductListing;

public class CustomerCheckout extends baseTest {

	@Test(dataProvider = "getTestData", retryAnalyzer = Retry.class)
	public void CustomerplaceOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// String productName = "Sunglasses"; [now productName value will get from
		// HashMap]
		// String[] loginCredential= {"tom@example.com","tom123"}; [now login
		// Credentials will get from HashMap]

		// extentObj.createTest("Customer Checkout"); // ExtentReport bnayega or Test
		// Name Inital Test hoga
		// extentObj.createTest ab Listeners ka use kr k call hoga

		ProductListing ProductListingObj = launcVelocity();
		CustomerLogin CustomerLoginobj = ProductListingObj.addProductToCart(input.get("productName"));
		CustomerLoginobj.goToLoginPage();
		LandingPage LandingPageObj = CustomerLoginobj.customerLogin(input);
		LandingPageObj.goToCartPage();
		// extentObj.flush();

	}

	// By using DataProvider the above placeOrder Test should be run for each test
	// data of JSON/HashMap/Object
	@DataProvider
	public Object[][] getTestData() throws IOException {
		// We can use Object,HashMap and JSON file for send data
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//Shop//TestData//TestData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
