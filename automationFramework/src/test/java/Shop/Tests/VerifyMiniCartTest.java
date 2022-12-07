package Shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.*;


public class VerifyMiniCartTest extends BaseTest {

	@Test
	public void VerifyMiniCartPrice() throws InterruptedException, IOException {
		ProductListing ProductListingObj = launcVelocity();
		ProductListingObj.addProductToCart("Sunglasses");
		MiniCarPriceValidate MiniCarobj = new MiniCarPriceValidate(driver);
		MiniCarobj.verifyMiniCartPrice();
	}	
}
