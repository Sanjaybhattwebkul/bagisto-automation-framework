package Shop.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.CartRuleVerifyPageObject;
import velocity.pageobjects.ProductListing;

public class VeryCartRuleTest extends BaseTest{
	
	@Test
	public void veryfy() throws IOException, InterruptedException {
		ProductListing ProductListingObj = launcVelocity();
		ProductListingObj.addProductsToCart(1);	
		CartRuleVerifyPageObject obj = new CartRuleVerifyPageObject(driver);
		obj.clickOnCartIcon();
		obj.gotoCartPage();	
		obj.increaseNumber(1);
		obj.updateCart();
		Assert.assertTrue(obj.isDiscount());
	}
	
}
