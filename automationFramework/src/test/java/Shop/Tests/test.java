package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import helpers.productsActions;


public class test extends BaseTest{
	@Test
	public void testCase() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, AWTException {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,400");
		launcVelocity();		
		productsActions ProductActions =  new productsActions(driver);
		ProductActions.addProductsTo("COMPARE",1);
		
	}

	
}
