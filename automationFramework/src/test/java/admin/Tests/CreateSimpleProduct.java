package admin.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import admin.pageobjects.*;
import admin.TestComponents.adminBaseTest;
import admin.pageobjects.LoginPageObject;

public class CreateSimpleProduct extends adminBaseTest {
	@Test
	public void Create() throws IOException {
		LoginPageObject LoginPageObject = launcAdminPanel();			
		LoginPageObject.adminLogin("admin@example.com","admin123");
		CreateProduct CreateProduct = new CreateProduct(driver);		
		CreateProduct.createSimpleProduct();
		
	}
	
}
