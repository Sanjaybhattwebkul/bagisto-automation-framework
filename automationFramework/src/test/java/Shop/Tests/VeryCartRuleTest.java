package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.CartRuleRepository;
import velocity.pageobjects.HomePageRepository;

public class VeryCartRuleTest extends BaseTest{
	
	@Test
	public void veryfy() throws IOException, InterruptedException, AWTException {
		HomePageRepository ProductListingObj = launcVelocity();
		ProductListingObj.addProductTo("CART",1);	
		CartRuleRepository obj = new CartRuleRepository(driver);
		obj.clickOnCartIcon();
		obj.gotoCartPage();	
		obj.increaseNumber(3);
		obj.updateCart();
		Assert.assertTrue(obj.isDiscount());
	}
	
}
