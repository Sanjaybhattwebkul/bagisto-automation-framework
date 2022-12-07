package velocity.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.getProductsPrice;

public class SearchProduct extends getProductsPrice{

	WebDriver driver;
	public SearchProduct(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="term")
	WebElement searchBox;
	
	@FindBy(xpath="//span[@class='special-price']")
	WebElement productsPrice;
	
	public double searchProduct(String productName) {
		searchBox.sendKeys(productName,Keys.ENTER);
		return getActualPrice(productsPrice.getText());
	}

}
