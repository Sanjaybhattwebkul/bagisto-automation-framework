package Shop.Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import Shop.TestComponents.baseTest;
import helpers.productsActions;


public class test extends baseTest{
	@Test
	public void testCase() throws IOException, InterruptedException {
		
		launcVelocity();		
		productsActions ProductActions =  new productsActions(driver);
		ProductActions.addProductTo("COMPARE");
	}
}
