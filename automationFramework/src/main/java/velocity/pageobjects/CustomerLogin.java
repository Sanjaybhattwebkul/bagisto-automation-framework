package velocity.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import bagisto.automationFramework.AbstractComponent;

public class CustomerLogin extends AbstractComponent {
	
	WebDriver driver;
	
	public CustomerLogin(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("div[class*='welcome-content']")).click();
	@FindBy(css="div[class*='welcome-content']")
	WebElement loginpOPuP;
	
	//driver.findElement(By.xpath("//a[@class='theme-btn fs14 fw6'][1]")).click();
	@FindBy(xpath="//a[@class='theme-btn fs14 fw6'][1]")
	WebElement loginPopButton;
	
	@FindBy(name="email")
	WebElement userEmail;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	
	@FindBy(css="input[type='submit']")
	WebElement loginButton;
	
	@Test
	public void goToLoginPage() {
		closeFlashMessage();
		loginpOPuP.click();
		loginPopButton.click();
	}
	
	//@Test(dependsOnMethods= {"goToLoginPage"})
	public LandingPage customerLogin(String[] loginCredentials) throws InterruptedException {
		userEmail.sendKeys(loginCredentials[0]);
		passwordElement.sendKeys(loginCredentials[1]);
		loginButton.click();
		return new LandingPage(driver);
	}
}
