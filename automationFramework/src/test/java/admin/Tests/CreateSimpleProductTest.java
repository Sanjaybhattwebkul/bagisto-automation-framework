package admin.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import admin.pageobjects.*;
import baseComponent.BaseTest;

public class CreateSimpleProductTest extends BaseTest {
	
	//Make WebDriver static in Base-test	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void Createproduct() throws IOException, InterruptedException {
		//fullScreenMode();
		getGlobalData();		
		String[] productsValues = {
				prop.getProperty("createdProductsName"),
				prop.getProperty("shortDecriptionFrameID"),
				prop.getProperty("shortDecriptionText"),
				prop.getProperty("DecriptionFrameID"),
				prop.getProperty("DecriptionText"),
				prop.getProperty("productsPrice"),
				prop.getProperty("productSpecialPrice"),
				prop.getProperty("productsWeight"),
				prop.getProperty("defaultInventory"),
				prop.getProperty("productImagePath")
			};
		
		String[] productsDetails = {
				prop.getProperty("createProductType"),
				prop.getProperty("attributeFamily"),
				prop.getProperty("createProductSKU")
			};
		CreateProductRepository CreateProduct = new CreateProductRepository(driver);
		EditProductRepository editProductObj = CreateProduct.createSimpleProduct(productsDetails);	
		boolean created = editProductObj.editSimpleProduct(productsValues);
		Assert.assertTrue(created);
	}
	
}
