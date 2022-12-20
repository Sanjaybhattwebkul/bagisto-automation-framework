package common;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.SearchProductRepository;

public class ProductPriceTest extends BaseTest {
	
	/*
	 * This test will verify the products price with the database
	 */
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void verify() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException {		
		PricePageObject priceObj = new PricePageObject(driver);	
		priceObj.gotoProductsPage();
		int productId = priceObj.getCreatedProductId();
		getGlobalData();	
		List<String> price =    priceObj.getPriceFromBackend(prop.getProperty("tableName"),productId,Integer.parseInt(prop.getProperty("customerGroupId")));		
		String backendPrice = price.get(0);
		double expectedPrice = priceObj.getActualPrice(backendPrice);
		SearchProductRepository shopObj = priceObj.visitShop();
	    ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles()); // hold all window handles in array list
	    driver.switchTo().window(allTabs.get(1));  //switch to new tab
	    System.out.println("Page title of new tab: " + driver.getTitle());	      
	    double  actualPrice =  shopObj.searchProduct("Product-By Selnium Automation");
	    System.out.println("Actual Price is : "+ expectedPrice);
	    System.out.println("Actual Price is : "+ actualPrice);
	    Assert.assertEquals(expectedPrice,actualPrice);
	    System.out.println("Test Casse Passed");	 	
	}
}
