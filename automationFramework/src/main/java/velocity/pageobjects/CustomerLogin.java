package velocity.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	//@FindBy(xpath="")
	
	
	public void login() {
		scrollUp(driver);
		loginpOPuP.click();
		loginPopButton.click();
		
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10)); // Object of WebDriverWaite for explicit waite.
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));		
		/*
		driver.findElement(By.xpath(loginLocators[1])).sendKeys(loginCredentials[0]);		
		driver.findElement(By.xpath(loginLocators[2])).sendKeys(loginCredentials[1]);
		driver.findElement(By.cssSelector("input[type='submit']")).click();	*/
	}
}
