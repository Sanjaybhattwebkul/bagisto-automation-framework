package velocity.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import abstraction.AbstractComponent;

public class CheckoutRepository extends AbstractComponent {
	WebDriver driver;
	
	public CheckoutRepository(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[type='radio']")
	WebElement billingAddress;
	
	@FindBy(id="flatrate_flatrate")
	List<WebElement> shippingMethod;
	
	@FindBy(id="cashondelivery")
	WebElement paymentMethod;
	
	@FindBy(id="checkout-place-order-button")
	WebElement placeOrderButton;
	
	@FindBy(xpath="//div[contains(@class,'order-success-content')]/h1")
	WebElement orderConfirmation;
	
	@FindBy(css="div[class*='order-success-content']")
	List<WebElement> confirmationSection;
	
	@FindBy(xpath="//div[contains(@class,'order-success-content')]/p/a")
	WebElement orderID;
	
	public void placeOrder() {
		billingAddress.click();
		scrollDown(driver,550);
		if(shippingMethod.size()>0) {
			shippingMethod.get(0).click();	
		}
		
		paymentMethod.click();
		scrollDown(driver,1000);
		placeOrderButton.click();
		
		if(isPresent(confirmationSection)) {
			
			boolean isOrderConfirmed = orderConfirmation.isDisplayed();
			SoftAssert softAssert = softAsset();			
			softAssert.assertTrue(isOrderConfirmed);
			
			if (isOrderConfirmed) {					
				System.out.println(orderConfirmation.getText());
				System.out.println("Your Order ID is "+ orderID.getText());
				softAssert.assertAll();
			} else {
				
				System.out.println(driver.getCurrentUrl());
			}
		}
		
		
	}
	
	
}
