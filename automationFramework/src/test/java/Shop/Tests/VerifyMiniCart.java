package Shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import Shop.TestComponents.baseTest;
import velocity.pageobjects.*;


public class VerifyMiniCart extends baseTest {

	@Test
	public void VerifyMiniCartPrice() throws InterruptedException, IOException {
		ProductListing ProductListingObj = launcVelocity();
		ProductListingObj.addProductToCart("Sunglasses");
		MiniCarPriceValidate MiniCarobj = new MiniCarPriceValidate(driver);
		MiniCarobj.verifyMiniCartPrice();
	}	
}
