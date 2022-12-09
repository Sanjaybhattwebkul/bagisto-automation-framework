package admin.Tests;

import org.testng.annotations.Test;

import admin.pageobjects.CatalogPageObject;
import baseComponent.BaseTest;

public class ApplyCataloRuleTest extends BaseTest{

	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void create() throws InterruptedException {
		CatalogPageObject CatalogObj = new CatalogPageObject(driver);
		CatalogObj.createCatalogRuleFor("watch");
	}
}
