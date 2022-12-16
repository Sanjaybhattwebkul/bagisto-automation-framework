package admin.Tests;

import org.testng.annotations.Test;
import admin.pageobjects.PromotionsRepository;
import baseComponent.BaseTest;

public class ApplyCataloRuleTest extends BaseTest{

	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void create() throws InterruptedException {
		String[] catalogRulevalues = {
					"Automated Catalog Rule",
					"This Catalog Rule Is Created By Selenium Automation",
					"Name",
					"Is equal to",
					"watch",
					"Fixed Amount",
					"100"
				};
		
		PromotionsRepository obj = new PromotionsRepository(driver);
		obj.createCatalogRule(catalogRulevalues);
	}
}
