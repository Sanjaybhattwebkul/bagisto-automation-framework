package velocity.pageobjects;

import java.util.List;

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
	
	@FindBy(xpath="//a[@class='close']")
	WebElement CloseFlashMessage;
	
	@FindBy(xpath="//div[@id='mini-cart']")
	WebElement catIcon;
	
	@FindBy(xpath="//span[@class='card-total-price fw6']")
	WebElement productsPrice;
	
	public void clickOnCartIcon() {
		CloseFlashMessage.click();
		catIcon.click();
		//List<WebElement> miniCartmount = (List<WebElement>) productsPrice;		
		//int actualAmount=0;
	}
	
	
}
