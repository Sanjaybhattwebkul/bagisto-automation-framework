package admin.Tests;

import org.testng.annotations.Test;
import admin.pageobjects.PromotionsPageObject;
import baseComponent.BaseTest;

public class ApplyCartRule extends BaseTest{
	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void apply() throws InterruptedException {
		String[] catalogRulevalues = {
				"Automated Cart Rule",
				"This Cart Rule Is Created By Selenium Automation",
				"Qty in Cart",
				"Is equal to",
				"2",
				"Fixed Amount",
				"100"
			};
		PromotionsPageObject obj = new PromotionsPageObject(driver);
		obj.create(catalogRulevalues);
	}
		
}
