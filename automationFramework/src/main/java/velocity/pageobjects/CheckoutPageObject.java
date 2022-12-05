package velocity.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import bagisto.automationFramework.AbstractComponent;

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
		boolean isOrderConfirmed = orderConfirmation.isDisplayed();
		Assert.assertTrue(isOrderConfirmed);
		if(isOrderConfirmed) {
			System.out.println(orderConfirmation.isDisplayed());
			System.out.println(orderConfirmation.getText());
			System.out.println("Your Order ID is "+ orderID.getText());
		}
	}
	
	
}
