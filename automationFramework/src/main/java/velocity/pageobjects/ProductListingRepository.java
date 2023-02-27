package velocity.pageobjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(css="li[id*='category']")
	List<WebElement> categoryList;

	@FindBy(xpath = "//ul[@class='main-category']/li")
	List<WebElement> categories;

	@FindBys({ 
		@FindBy(className = "product-price"),
		@FindBy(xpath = "//div[@class='card-body']  //div[@class='product-price']") 
	})
	List<WebElement> productsPrices;
	
	@FindBy(id="price_to") 
	WebElement SelectMaxPrice;
		
	//By category = By.xpath("//ul[@class='main-category']/li["+categoryList.size()+"]");
	By category = By.cssSelector("li[id*='category-2']");
							
	
	/*
	 * Select last category from category list on top left corner of home page
	 */
	public void listByCategory() {		
		categorySection.click();
		System.out.println(categoryList.size());	
		driver.findElement(category).click();
		
	}

	/*
	 * Verify the price of price range filter
	 */
	public boolean verifyPriceFilter() {
		
		String selectedFilter = SelectMaxPrice.getAttribute("value")+".00";
		if (productsPrices.stream().anyMatch(selectedFilter::equals)) {
			
			return true;
		} 
		
		return false;
	}

}
