package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseComponents.CustomerLocators;

public class CustomerRepository extends CustomerLocators {
	
	WebDriver driver;
	
	public CustomerRepository(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	@Test
	public void goToLoginPage() 
	{
		//closeFlashMessage();
		loginPoPup.click();
		loginPopButton.click();
	}
	
	//@Test(dependsOnMethods= {"goToLoginPage"})
	/*public LandingPage customerLogin(HashMap<String, String> input) throws InterruptedException {
		userEmail.sendKeys(input.get("email"));
		passwordElement.sendKeys(input.get("password"));
		loginButton.click();
		return new LandingPage(driver);
	}
	*/
	
	/*
	 * @return miniCart object
	 */
	public MiniCarRepository customerLogin(String email, String Password) throws InterruptedException 
	{
		userEmail.sendKeys(email);
		passwordElement.sendKeys(Password);
		loginButton.click();
		return new MiniCarRepository(driver);
	}
	
	public void createAddress(String[] addresValues) 
	{
		addressIcon.click();
		addAddressButton.click();
		companyName.sendKeys(addresValues[0]);
		streetAddress.sendKeys(addresValues[1]);
		selectOptions(countryName,addresValues[2]);	
		selectOptions(state,addresValues[3]);
		city.sendKeys(addresValues[4]);
		postcode.sendKeys(addresValues[5]);
		phone.sendKeys(addresValues[6]);
		defaultAddress.click();
		saveAddress.click();
		
	}
	
	
}
