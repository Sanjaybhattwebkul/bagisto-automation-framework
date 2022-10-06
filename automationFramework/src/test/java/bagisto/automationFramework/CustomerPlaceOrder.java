package bagisto.automationFramework;
import org.testng.annotations.Test;
import java.io.IOException;
import bagistoTestComponents.baseTest;
import velocity.pageobjects.ProductListing;

public class CustomerPlaceOrder extends baseTest{
	
	@Test
	public void placeOrder() throws IOException, InterruptedException {
		String productName = "Sunglasses";
		ProductListing ProductListingObj = launcVelocity();
		ProductListingObj.addProductToCart(productName);
		/*
		ProductListing ProductListingObj = LandingPageObject.customerLogin("tom@example.com","tom123");
		LandingPageObject.goToHomePage();*/
		
	}                    

}
