package bagisto.automationFramework.velocity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, driver);
	}
	
	@FindBy(name="email")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	
	@FindBy(xpath="input[type='submit']")
	WebElement loginButton;
	
	public void customerLogin(String email,String password) {
		userEmail.sendKeys(email);
		passwordElement.sendKeys(password);
		loginButton.click();
		
		//create object of CatalogProduct class and can access by calling any function of LandingPage class. 
		//return  new CatalogProduct(driver);
	}
	
	public void goTo()
	{
		driver.get("http://192.168.15.237/sanjay-bagisto/public/customer/login");
	}
}
