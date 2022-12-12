package velocity.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.productsActions;

public class ProductListing extends productsActions{
	
	WebDriver driver;
	
	public ProductListing(WebDriver driver) {
		super(driver); // initialize driver to parent class constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".alert-dismissible")  //alert alert-success 
	WebElement flashMessage;
	
	By getProductsBy = By.cssSelector(".card-body");
	By addToCartButton = By.cssSelector(".btn-add-to-cart");
			
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
	public CustomerLogin addProductsToCart(int number) throws InterruptedException {		
		addProductTo("CART",number);	
		return new CustomerLogin(driver);
	}
	
}
