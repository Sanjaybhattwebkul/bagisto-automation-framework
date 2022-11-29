package admin.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import admin.pageobjects.*;
import admin.TestComponents.adminBaseTest;

public class CreateSimpleProduct extends adminBaseTest {
	
	//Make WebDriver static in Base-test
	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void Create() throws IOException {
		CreateProduct CreateProduct = new CreateProduct(driver);		
		CreateProduct.createSimpleProduct();
		
	}
	
}
