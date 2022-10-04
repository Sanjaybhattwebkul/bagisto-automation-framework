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
	
	@FindBy(css="card-body")
	List<WebElement> products;
	
	By getProductsBy = By.cssSelector("card-body");
	
	public List<WebElement> getProductList(){
		waitForElementToAppear(getProductsBy);
		return (List<WebElement>) products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector("span")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
}
