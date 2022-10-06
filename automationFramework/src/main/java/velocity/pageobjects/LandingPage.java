package velocity.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bagisto.automationFramework.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	
	@FindBy(css="input[type='submit']")
	WebElement loginButton;
	
	@FindBy(css="a[class*='navbar-brand']")
	WebElement logo;
	
	public ProductListing customerLogin(String email, String password) {
		System.out.println("i am login page and password= "+password);
		userEmail.sendKeys(email);
		passwordElement.sendKeys(password);
		loginButton.click();
		return new ProductListing(driver);
	}

	public void goToHomePage() {
		logo.click();
		
	}
}
