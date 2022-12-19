package abstraction;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
	@FindBy(xpath = "//div[@id='mini-cart']")
	WebElement cart;
	
	@FindBy(css = "a[class*='navbar-brand']")
	WebElement logo;

	@FindBy(xpath = "//a[@class='close']")
	WebElement flashMessage;

	@FindBy(css = "a[class*='remove-decoration']")
	WebElement viewCart;

	@FindBy(linkText = "View Shopping Cart")
	WebElement viewShoppingCart;	
	
	@FindBy(xpath="//div[contains(@class,'open')]/div/div/div/select")				 
	WebElement monthsDropdown;

	@FindBy(xpath="//div[contains(@class,'open')]/div/span[2]")
	WebElement nextMonth;
	
	@FindBy(xpath="//div[@class='navbar-left']/ul/li[2]")
	protected WebElement salesIcon;
	
	@FindBy(xpath="//div[@class='navbar-left']/ul/li[3]")
	WebElement catalogIcon;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement lastProductID;
	
	@FindBy(css="span[title='Visit Shop']")
	WebElement visitShop;	
	
	@FindBy(css="div[class='alert alert-success']")
	WebElement adminFlashMessage;	
	
	@FindBy(css="i[class='rango-plus']")
	WebElement plusIcon;
	
	@FindBy(id="quantity-changer")
	List<WebElement> quantityBox;
	
	@FindBy(className = "next")
	WebElement nextPage;
}
