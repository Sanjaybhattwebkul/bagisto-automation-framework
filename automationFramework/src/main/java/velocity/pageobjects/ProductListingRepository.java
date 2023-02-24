package velocity.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseComponents.BaseRepository;

public class ProductListingRepository extends BaseRepository {

	WebDriver driver;

	public ProductListingRepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(how = How.ID, using = "main-category"))
	WebElement categorySection;

	@FindBy(xpath = "//ul[@class='main-category']/li")
	List<WebElement> categories;

	@FindBys({ 
			@FindBy(className = "product-price"),
			@FindBy(xpath = "//div[@class='card-body']  //div[@class='product-price']") 
	})
	List<WebElement> productsPrices;

	/*
	 * Select last category from category list on top left corner of home page
	 */
	public void listByCategory() {
		categorySection.click();
		driver.findElement(By.xpath("//ul[@class='main-category']/li[" + categories.size() + "]")).click();

	}

	/*
	 * Verify the price of price range filter
	 */
	public void verifyPriceFilter() {
		for (WebElement price : productsPrices) {
			price.getText();
			System.out.println(price.getText());
		}

	}

}
