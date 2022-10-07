package bagisto.automationFramework;
import java.io.IOException;
import bagistoTestComponents.baseTest;
import velocity.pageobjects.ProductListing;

public class GuestCheckout extends baseTest {
	
	public void placeOrder() throws IOException, InterruptedException {
		String productName = "Sunglasses";			
		ProductListing ProductListingObj = launcVelocity();
		ProductListingObj.addProductToCart(productName);	
	}

}
