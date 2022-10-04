package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	
	@FindBy(css="input[type='submit']")
	WebElement loginButton;
	
	public void customerLogin(String email, String password) {
		System.out.println("i am login page and password= "+password);
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
