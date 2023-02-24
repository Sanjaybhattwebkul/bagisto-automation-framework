package stepDefinition;

import java.awt.AWTException;
import java.io.IOException;

import baseComponent.BaseTest;
import baseComponents.BaseRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import velocity.pageobjects.*;

public class StepDefinitionImpl extends BaseTest {
	
	public HomePageRepository ProductListingObj;
	public CustomerRepository CustomerLoginobj;
	public BaseRepository AbstractObj;
	public CartRepository CartPagobj;
	public CheckoutRepository CheckoutObject;
	
	@Given("I landed on Velocity Page")
	public void I_landed_on_Velocity_Page() throws IOException, AWTException {
		ProductListingObj = launcVelocity();
	}
	
	@Given("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		//CustomerLoginobj = ProductListingObj.addProductToCart(productName);
		ProductListingObj.viewProduct(1);
		ProductListingObj.selectOptions();
		CustomerLoginobj = ProductListingObj.addProductTo("CART",3);
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_username_and_password(String userName,String Passsword) throws InterruptedException {
		CustomerLoginobj.goToLoginPage();	
		CustomerLoginobj.customerLogin(userName,Passsword);	
		AbstractObj  = new BaseRepository(driver);//
		AbstractObj.clickOnCartIcon();
		CartPagobj = AbstractObj.gotoCartPage();		
		CartPagobj.calCulatePrice();
		CheckoutObject = CartPagobj.processToCheckout();
		CheckoutObject.placeOrder();		
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string) {
	 	//String message = confirmMessagePage.getConfirmMessage();
		//Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	 	driver.close();
	}
	
}
