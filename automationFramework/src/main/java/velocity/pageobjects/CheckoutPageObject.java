package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.util.Assert;
import bagisto.automationFramework.AbstractComponent;
import org.testng.asserts.*;


public class CheckoutPageObject extends AbstractComponent {
	WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[type='radio']")
	WebElement billingAddress;
	
	@FindBy(id="flatrate_flatrate")
	WebElement shippingMethod;
	
	@FindBy(id="cashondelivery")
	WebElement paymentMethod;
	
	@FindBy(id="checkout-place-order-button")
	WebElement placeOrderButton;
	
	@FindBy(xpath="//div[contains(@class,'order-success-content')]/h1")
	WebElement orderConfirmation;
	
	@FindBy(xpath="//div[contains(@class,'order-success-content')]/p/a")
	WebElement orderID;
	
	public void placeOrder() {
		billingAddress.click();
		scrollDown(driver,550);
		shippingMethod.click();
		paymentMethod.click();
		scrollDown(driver,1000);
		placeOrderButton.click();
		//boolean isorderConfirmed = orderConfirmation.isDisplayed();
		
		//Assert.assertTrue(false);
		
		if(orderConfirmation.isDisplayed()) {
			System.out.println(orderConfirmation.isDisplayed());
			System.out.println(orderConfirmation.getText());
			System.out.println("Your Order ID is "+ orderID.getText());
		}
	}
	
	
}
