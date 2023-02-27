package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.ProductListingRepository;

public class ShopByCategory extends BaseTest{
	
	@Test
	public void veryfyListingPage() throws IOException, AWTException 
	{
		launcVelocity();
		ProductListingRepository listingPage = new ProductListingRepository(driver);
		listingPage.listByCategory();		
		Assert.assertTrue(listingPage.verifyPriceFilter());
	}
	
}
