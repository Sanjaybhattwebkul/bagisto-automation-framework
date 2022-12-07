package admin.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import admin.pageobjects.*;
import baseComponent.BaseTest;

public class CreateSimpleProductTest extends BaseTest {
	
	//Make WebDriver static in Base-test	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void Create() throws IOException, InterruptedException {
		//fullScreenMode();
		CreateProductPageObject CreateProduct = new CreateProductPageObject(driver);
		EditProductPageObject editProductObj = CreateProduct.createSimpleProduct();	
		editProductObj.editSimpleProduct();
	}
	
}
