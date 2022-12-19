package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

public class CartRuleRepository extends AbstractComponent{
	
	WebDriver driver;
	public CartRuleRepository(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='misc']/button")
	WebElement updateCartButton;
	
	@FindBy(id="discount-detail")
	WebElement discountSection;
	
	@FindBy(xpath="//div[@id='discount-detail']/span[2]")
	WebElement discountAmount;
	
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
