package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bagisto.automationFramework.AbstractComponent;

public class MiniCarPriceValidate  extends AbstractComponent{
	WebDriver driver;
	public MiniCarPriceValidate(WebDriver driver) {
		super(driver); //Assign driver to AbstractComponent class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='mini-cart']")
	WebElement catIcon;
	
	@FindBy(xpath="//a[@class='close']")
	WebElement CloseFlashMessage;
	
	
	public void clickOnCartIcon() {
		CloseFlashMessage.click();
		catIcon.click();
	}
}
