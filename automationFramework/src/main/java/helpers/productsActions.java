package helpers;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

public class productsActions extends AbstractComponent{
	WebDriver driver;
	
	public productsActions(WebDriver driver) {
		super(driver); // initialize driver to parent class constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".alert-dismissible")  //alert alert-success 
	WebElement flashMessage;
	
	@FindBy(css="*[class*='add-to-cart-btn']") //.btn-add-to-cart
	List<WebElement> cardButton;
	
	@FindBy(css="button[class*='buynow']")
	List<WebElement> bynowButton;
	
	@FindBy(css=".a[class*='compare-icon']")
	List<WebElement> productCard;
	
	@FindBy(css=".wishlist-icon")
	List<WebElement> wishlistIcon;
	
	@FindBy(css="a[title='Add product to compare list']")
	List<WebElement> compareIcon;
	
	/*
	 * @void
	 * Add Three Products to the cart.
	 */
	public void addProductTo(String actionType,int count) throws InterruptedException {
		for(int i=0;i<count; i++) {
			
			switch(actionType) {
			  case "CART":
				  cardButton.get(i).click();
			    break;
			  case "COMPARE":
				  mouseOver(productCard.get(i));				  
				  compareIcon.get(i).click();	 			 
				break;
			  case "WISHLIST":				  
				  mouseOver(productCard.get(i));				  
				  wishlistIcon.get(i).click(); 
			    break;
			  case "BUYNOW":					  				  
					bynowButton.get(i).click(); 
				break;
			  default:
			    // TODO some other action
			}
			
			flashMessage.click();
			Thread.sleep(1000);
		}
	}
	
	/*
	 * @void
	 * Perform Mouse over event
	 */
	public void mouseOver(WebElement element) {
		 Actions action = new Actions(driver);
		 action.moveToElement(element).build().perform();
	}
	
	public void viewProduct(WebElement element) {
		element.click();
	}
}
