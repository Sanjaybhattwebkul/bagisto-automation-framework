package stepDefinition;

import java.io.IOException;

import Shop.TestComponents.baseTest;
import io.cucumber.java.en.Given;
import velocity.pageobjects.CustomerLogin;
import velocity.pageobjects.LandingPage;
import velocity.pageobjects.ProductListing;

public class StepDefinitionImpl extends baseTest {
	
	public ProductListing ProductListingObj;
	public CustomerLogin CustomerLoginobj;
	public LandingPage LandingPageObj;
	
	@Given("I landed on Velocity Page")
	public void I_landed_on_Velocity_Page() throws IOException {
		ProductListingObj = launcVelocity();
	}
	
	@Given("I add product (.+) to Cart")
	public void I_add_product_productName_to_Cart(String productName) throws InterruptedException {
		CustomerLoginobj = ProductListingObj.addProductToCart(productName);
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String userName,String Passsword) throws InterruptedException {
		CustomerLoginobj.goToLoginPage();
		LandingPageObj = CustomerLoginobj.customerLogin(userName,Passsword);
		LandingPageObj.goToCartPage();
	}
	
}
