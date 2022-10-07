package bagisto.automationFramework;
import org.testng.annotations.Test;
import java.io.IOException;
import bagistoTestComponents.baseTest;
import velocity.pageobjects.CustomerLogin;
import velocity.pageobjects.LandingPage;
import velocity.pageobjects.ProductListing;

public class CustomerCheckout extends baseTest{
	
	@Test
	public void placeOrder() throws IOException, InterruptedException {
		String productName = "Sunglasses";
		String[] loginCredential= {"tom@example.com","tom123"};	
		
		ProductListing ProductListingObj = launcVelocity();
		CustomerLogin CustomerLoginobj = ProductListingObj.addProductToCart(productName);		
		CustomerLoginobj.goToLoginPage();
		LandingPage LandingPageObj = CustomerLoginobj.customerLogin(loginCredential);
		LandingPageObj.goToCartPage();
		
	}                    

}
