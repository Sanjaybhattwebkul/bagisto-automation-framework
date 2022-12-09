package common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.SearchProduct;

public class VerifyProductPriceTest extends BaseTest {
	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void verifyPrice() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {		
		PricePageObject priceObj = new PricePageObject(driver);	
		priceObj.gotoProductsPage();
		int productId = priceObj.getCreatedProductId();
		List<String> price =    priceObj.getPriceFromBackend(productId,1);		
		String backendPrice = price.get(0);
		double expectedPrice = priceObj.getActualPrice(backendPrice);
		SearchProduct ob = priceObj.visitShop();
	    ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles()); // hold all window handles in array list
	    driver.switchTo().window(allTabs.get(1));  //switch to new tab
	    System.out.println("Page title of new tab: " + driver.getTitle());	      
	    double  actualPrice =  ob.searchProduct("Product-By Selnium Automation");
	    System.out.println("Actual Price is : "+ expectedPrice);
	    System.out.println("Actual Price is : "+ actualPrice);
	    Assert.assertEquals(expectedPrice,actualPrice);
	    System.out.println("Test Casse Passed");	 	
	}
}
