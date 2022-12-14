package helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(css="a[class*='compare-icon']")
	List<WebElement> productCard;
	
	@FindBy(css=".wishlist-icon")
	List<WebElement> wishlistIcon;
	
	@FindBy(css="a[title='Add product to compare list']")
	List<WebElement> compareIcon;
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@class='product-price']")  ///span[1]
	List<WebElement> priceContainer;
	
	@FindBy(id="attribute_23")
	WebElement attributeONE;
	
	@FindBy(id="attribute_24")
	WebElement attributeTwo;
	
	By configurable  = By.xpath("//*[text()='As low as']");
	
	/*
	 * @void
	 * Add Three Products to the cart.
	 */
	public void addProductTo(String actionType,int count) throws InterruptedException {
		for(int i=0;i<count; i++) {
			
			switch(actionType) {
			  case "CART":
				  if(chechProductType(priceContainer.get(i))) {
					  System.out.println("This is Comfigurable product"+ i);
					  viewProduct(cardButton.get(1));
					  selectVarients(attributeONE,1);
					  selectVarients(attributeTwo,1);
					  addToCartButton.click();	
					  i=count-1;
				  } else {
					  cardButton.get(i).click(); 
				  }
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
			
			//flashMessage.click();
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
	
	/*
	 * @WebElement 
	 * Filter products from prducts list using JavaStream.
	 */
	public WebElement getProductCardByProductsName(String productName) throws InterruptedException {
		WebElement prod =	products.stream().filter(product->
		product.findElement(By.cssSelector("span")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	////span[@class='price-label']
	public boolean chechProductType(WebElement productCard) {			
		List<WebElement> isCOnfigurable = productCard.findElements(configurable);
		System.out.println("Is configurable = " + isCOnfigurable.size());		
		if(isCOnfigurable.size()>0) {
			return true; // Product is Configurable 
		}
		
		return false;
	}	
	
	public void selectVarients(WebElement attribute,int idex) {
		 Select option = new Select(attribute);
		 option.selectByIndex(idex);  
	}
}
