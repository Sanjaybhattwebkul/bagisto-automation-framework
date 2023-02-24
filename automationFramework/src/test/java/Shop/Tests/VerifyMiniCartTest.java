package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.*;


public class VerifyMiniCartTest extends BaseTest {

	@Test
	public void VerifyMiniCartPrice() throws InterruptedException, IOException, AWTException {
		HomePageRepository ProductListingObj = launcVelocity();
		ProductListingObj.addProductToCart("Sunglasses");
		MiniCarRepository MiniCarobj = new MiniCarRepository(driver);
		MiniCarobj.verifyMiniCartPrice();
	}	
}
