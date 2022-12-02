package admin.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import admin.pageobjects.*;
import admin.TestComponents.adminBaseTest;

public class CreateSimpleProductTest extends adminBaseTest {
	
	//Make WebDriver static in Base-test	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void Create() throws IOException, InterruptedException {
		CreateProduct CreateProduct = new CreateProduct(driver);
		EditProductPageObject editProductObj = CreateProduct.createSimpleProduct();	
		editProductObj.editSimpleProduct();
	}
	
}
