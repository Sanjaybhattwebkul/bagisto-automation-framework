package admin.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

public class LoginRepository extends AbstractComponent{
	WebDriver driver;
	public LoginRepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory TestNG ka part h is se annotation use kr skte h.
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(css="button[class='btn btn-xl btn-primary']")
	WebElement loginButton;
		
	public void adminLogin(String adminEmail, String adminPassword) {				
		email.sendKeys(adminEmail);
		Password.sendKeys(adminPassword);
		loginButton.click();
	}
	
}
