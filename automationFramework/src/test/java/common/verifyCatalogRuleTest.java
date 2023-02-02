package common;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseComponent.BaseTest;
import velocity.pageobjects.SearchProductRepository;

public class verifyCatalogRuleTest extends BaseTest {

	@Test
	public void verify() throws IOException, NumberFormatException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, AWTException {
		launcVelocity();
		getGlobalData("GlobalData.properties");	
		PricePageObject priceObj = new PricePageObject(driver);	
		List<String> price =    priceObj.getPriceFromBackend(prop.getProperty("tableName"),Integer.parseInt(prop.getProperty("productId")),Integer.parseInt(prop.getProperty("customerGroupId")));		
		String backendPrice = price.get(0);
		double expectedPrice = priceObj.getActualPrice(backendPrice);
		SearchProductRepository shopObj = new SearchProductRepository(driver);
		double  actualPrice =  shopObj.searchProduct(prop.getProperty("productsName"));
		System.out.println("Actual Price is: "+ actualPrice + "And Expected Price is : "+ expectedPrice);
		Assert.assertEquals(actualPrice, expectedPrice);
	}
}
