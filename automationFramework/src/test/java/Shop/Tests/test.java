package Shop.Tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import Shop.TestComponents.baseTest;
import helpers.productsActions;


public class test extends baseTest{
	@Test
	public void testCase() throws IOException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400");
		launcVelocity();		
		productsActions ProductActions =  new productsActions(driver);
		ProductActions.addProductTo("COMPARE");
	}
}
