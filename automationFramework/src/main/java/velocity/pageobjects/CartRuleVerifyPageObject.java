package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

public class CartRuleVerifyPageObject extends AbstractComponent{
	
	WebDriver driver;
	public CartRuleVerifyPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='misc']/button")
	WebElement updateCartButton;
	
	@FindBy(css="i[class='rango-plus']")
	WebElement plusIcon;
	
	@FindBy(id="discount-detail")
	WebElement discountSection;
	
	@FindBy(xpath="//div[@id='discount-detail']/span[2]")
	WebElement discountAmount;
	
	public void increaseNumber(int number) {
		for(int i=0;i<number;i++) {
			plusIcon.click();
		}
		
	}
	
	public void updateCart() {
		updateCartButton.click();
	}
	
	public boolean isDiscount() {
		
		if(discountSection.isDisplayed()) {
			System.out.println("TestCase passed and Discount is = " +discountAmount.getText());
			return true;
		} else {
			return false;
		}
		
	}

}