package Shop.Tests;


import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import velocity.pageobjects.CustomerRepository;

public class AddCustomerAddressTest extends BaseTest{

	@Test(dataProvider = "getTestData")
	public void addCustomerAddress(HashMap<String, String> input) throws IOException, AWTException, InterruptedException 
	{	
		getGlobalData("CustomerData.properties");
		String[] addressValues = {
			prop.getProperty("companyName"),
			prop.getProperty("streetAddress"),
			prop.getProperty("country"),
			prop.getProperty("state"),
			prop.getProperty("city"),
			prop.getProperty("postcode"),
			prop.getProperty("phone"),
		};
		launcVelocity();
		CustomerRepository customer = new CustomerRepository(driver);
		customer.goToLoginPage();
		customer.customerLogin(input.get("email"),input.get("password"));		
		customer.createAddress(addressValues);
	}
	
}
