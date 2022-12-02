package velocity.pageobjects;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bagisto.automationFramework.AbstractComponent;

public class ProductListing extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductListing(WebDriver driver) {
		super(driver); // initialize driver to parent class constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".card-body")
	List<WebElement> products;

	@FindBy(css=".alert-dismissible")  //alert alert-success 
	WebElement flashMessage;
	
	By getProductsBy = By.cssSelector(".card-body");
	By addToCartButton = By.cssSelector(".btn-add-to-cart");
			
	
	public List<WebElement> getProductList() throws InterruptedException{
		waitForElementToAppear(getProductsBy);
		return (List<WebElement>) products;
	}
	
	public WebElement getProductByName(String productName) throws InterruptedException {
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("span")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public CustomerLogin addProductToCart(String ProductName) throws InterruptedException {
		//System.out.println(ProductName);
		WebElement ProName = getProductByName(ProductName);
		ProName.findElement(addToCartButton).click();
		waitForWebElementToAppear(flashMessage); // waite while flash message is displaying
		Thread.sleep(1000);
		//waiteForElementToDisAppear(); // waite till loader will display
		scrollUp(driver);
		return new CustomerLogin(driver);
	}
	
}
