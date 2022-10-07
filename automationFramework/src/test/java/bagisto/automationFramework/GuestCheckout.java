package bagisto.automationFramework;
import java.io.IOException;

import org.testng.annotations.Test;
import bagistoTestComponents.baseTest;
import velocity.pageobjects.ProductListing;

public class GuestCheckout extends baseTest {
	
	@Test
	public void placeOrder() throws IOException, InterruptedException {
		String productName = "Sunglasses";			
		ProductListing ProductListingObj = launcVelocity();
		ProductListingObj.addProductToCart(productName);	
	}

}
