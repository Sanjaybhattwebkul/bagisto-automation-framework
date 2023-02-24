package velocity.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.productsActions;

public class HomePageRepository extends productsActions{
	
	WebDriver driver;
	
	public HomePageRepository(WebDriver driver) {
		super(driver); // initialize driver to parent class constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".alert-dismissible")  //alert alert-success 
	WebElement flashMessage;
	
	
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> productCard;
	
	/*@FindBy(css="div[class*='card grid-card']")
	List<WebElement> productCard;*/
	
	By productName = By.xpath("//div[contains(@class,'product-name')]/a");
	By getProductsBy = By.cssSelector(".card-body");
	By addToCartButton = By.cssSelector(".btn-add-to-cart");	//button[class*='btn-add-to-cart']
	
	/*
	 * Add Only the given product to the cart.
	 */
	public void addProductToCart(String ProductName) throws InterruptedException {
		//System.out.println(ProductName);
		WebElement ProName = getProductCardByProductsName(ProductName);
		ProName.findElement(addToCartButton).click();
		waitForWebElementToAppear(flashMessage); 
		Thread.sleep(1000);		
		scrollUp(driver);		
	}
	
	/*
	 * @Object
	 * Add Multiple products to the cart.
	 */
	public CustomerRepository addProductTo(String type, int number) throws InterruptedException {		
		addProductsTo(type,number);	
		return new CustomerRepository(driver);
	}
	
	/*
	 * Check if add to cart button enable.
	 */
	public void viewProduct(int i) {
		boolean isInStock = 	productCard.get(i).findElement(addToCartButton).isEnabled();	
		if(i==productCard.size()){
			
			System.out.println("ALL PRODUCTS ARE OUT OF STOCK");
			
		}else if(isInStock) {
			productCard.get(i).findElement(productName).click();
			//System.out.println(productCard.get(i).findElement(productName).getText()+ "Is "+ isInStock);
			
		}  else {			
			i=i+1;
			viewProduct(i);
		}
	}
}
