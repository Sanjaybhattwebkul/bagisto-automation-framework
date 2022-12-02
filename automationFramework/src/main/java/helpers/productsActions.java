package helpers;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bagisto.automationFramework.AbstractComponent;

public class productsActions extends AbstractComponent{
WebDriver driver;
	
	public productsActions(WebDriver driver) {
		super(driver); // initialize driver to parent class constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".alert-dismissible")  //alert alert-success 
	WebElement flashMessage;
	
	@FindBy(css=".btn-add-to-cart")
	List<WebElement> cardButton;
	
	@FindBy(css=".product-image-container")
	List<WebElement> productCard;
	
	@FindBy(css=".wishlist-icon")
	List<WebElement> wishlistIcon;
	
	@FindBy(css="a[title='Add product to compare list']")
	List<WebElement> compareIcon;
	
	public void addProductTo(String actionType) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		
		for(int i=0;i<3; i++) {
			
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
			  default:
			    // TODO some other action
			}
			
			flashMessage.click();
			Thread.sleep(1000);
		}
	}
	
	public void mouseOver(WebElement element) {
		 Actions action = new Actions(driver);
		  action.moveToElement(element).build().perform();
	}
}
