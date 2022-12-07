package common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.SearchProduct;

public class VerifyProductPriceTest extends BaseTest {
	
	@Test(dependsOnGroups={"AdminLoginTest.login"})
	public void verifyPrice() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		PricePageObject priceObj = new PricePageObject(driver);			
		List<String> price =    priceObj.getPriceFromBackend();		
		System.out.println(price.get(0));
		SearchProduct ob = priceObj.visitShop();
	    ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles()); // hold all window handles in array list
	    driver.switchTo().window(allTabs.get(1));  //switch to new tab
	    System.out.println("Page title of new tab: " + driver.getTitle());	      
	    ob.searchProduct("Product-By Selnium Automation");
		
		
	}
}
