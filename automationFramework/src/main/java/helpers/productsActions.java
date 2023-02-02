package helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponents.BaseRepository;

public class productsActions extends BaseRepository{
	WebDriver driver;
	
	public productsActions(WebDriver driver) {
		super(driver); // initialize driver to parent class constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".alert-dismissible")  //alert alert-success 
	WebElement flashMessage;
	
	@FindBy(css="*[class*='add-to-cart-btn']") //.btn-add-to-cart
	List<WebElement> addToCartButton;
	
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
	List<WebElement> attributeONE;
	
	@FindBy(id="attribute_24")
	List<WebElement> attributeTwo;
	
	@FindBy(css="input[type='checkbox']")
	List<WebElement> checkbox;
	
	@FindBy(xpath="//div[@class='form-group date']/span/input")
	WebElement appointmentDate;
	
	@FindBy(css="div[class='form-group date']")
	List<WebElement> appointmentInfo;
	
	/*
	 * @void
	 * Add Three Products to the cart.
	 */
	public void addProductsTo(String actionType,int count) throws InterruptedException {
		for(int i=0;i<count; i++) {
			
			switch(actionType) {
			  case "CART":
				  addToCartButton.get(i).click();
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
	
	
	
	/*
	 * @WebElement 
	 * Filter products from prducts list using JavaStream.
	 */
	public WebElement getProductCardByProductsName(String productName) throws InterruptedException {
		WebElement prod =	products.stream().filter(product->
		product.findElement(By.cssSelector("span")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}	
	
	public void selectOptions() throws InterruptedException {	
		if(isPresent(attributeONE)) {
			selectByIndex(attributeONE.get(0),1);	
		}
		
		if(isPresent(attributeTwo)) {
			selectByIndex(attributeTwo.get(0),1);	
		}
		if(isPresent(checkbox) && (!checkbox.get(0).isSelected())) {
			checkbox.get(0).click();
		}
		
		if(isPresent(appointmentInfo)) {
			appointmentDate.click();
			handleCalendarDate(getDate("AFTER_DATE","d"),getDate("TODAY_DATE","MMMM"),true); /* Select current date */
		}
		setQuantity("1");	
		scrollUp(driver);
	}	
	
}
