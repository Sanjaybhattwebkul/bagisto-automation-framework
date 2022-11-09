package velocity.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bagisto.automationFramework.AbstractComponent;

public class CartPageVerify extends AbstractComponent{
	
	WebDriver driver;
	public CartPageVerify(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory TestNG ka part h is se annotation use kr skte h.
	}
	
	
	@FindBy(xpath="//div[@class='cart-item-list']/div")
	List<WebElement> cartItemContainer;
		
	By formattedPrice =By.cssSelector("div[class='product-price'] :nth-child(1)"); // 1 product's price	
	
	By plusIcon = By.cssSelector(".increase");	
	
	By quantity = By.id("//input[@id='quantity-changer']"); // get model attribute's value
	
	By totalPrice = By.cssSelector("span[class='card-current-price fw6 mr10']");
	
	// Get Item Container
	public List<WebElement> getAllItems() {
		return cartItemContainer;
	}
	
	//verify price with quantity
	public String calCulatePrice() {
		WebElement Container = (WebElement) getAllItems();
		String Price = Container.findElement(formattedPrice).getText();
		return  Price;
		//System.out.println(Price);
		
	}
	
	
	public void IncreaseQuantity() {
		//TODO  -> Verify Products price. quantity*price
		
		//List<WebElement> itemContainer = getAllItems();		
		//getAllItems().stream().map(data->data.findElement(By.cssSelector(".increase"))).getClass();	
	}
}
