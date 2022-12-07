package common;

import java.sql.SQLException;
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
		
		
	}
}
