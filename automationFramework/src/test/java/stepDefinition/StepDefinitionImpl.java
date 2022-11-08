package stepDefinition;

import java.io.IOException;
import Shop.TestComponents.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import velocity.pageobjects.*;

public class StepDefinitionImpl extends baseTest {
	
	public ProductListing ProductListingObj;
	public CustomerLogin CustomerLoginobj;
	public MiniCarPriceValidate MiniCarPriceValidate;
	
	@Given("I landed on Velocity Page")
	public void I_landed_on_Velocity_Page() throws IOException {
		ProductListingObj = launcVelocity();
	}
	
	@Given("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		CustomerLoginobj = ProductListingObj.addProductToCart(productName);
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_username_and_password(String userName,String Passsword) throws InterruptedException {
		CustomerLoginobj.goToLoginPage();
		
		MiniCarPriceValidate MiniCarPriceValidate = CustomerLoginobj.customerLogin(userName,Passsword);			
		CartPageVerify CartPageVerify = MiniCarPriceValidate.verifyMiniCartPrice();	//verifyMiniCartPrice	
		CartPageVerify.gotoCartPage();

	}
	
	 @Then("{string} message is displayed on ConfirmationPage")
	    public void message_displayed_confirmationPage(String string) {
		 	//String message = confirmMessagePage.getConfirmMessage();
			//Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 	driver.close();
	    }
	
}
