package Shop.Tests;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;
import Shop.TestComponents.baseTest;
import helpers.ProductPriceVerify;
import helpers.productsActions;


public class test extends baseTest{
	@Test
	public void testCase() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,400");
		launcVelocity();		
		productsActions ProductActions =  new productsActions(driver);
		ProductActions.addProductTo("COMPARE",1);
		
	}

	
}
