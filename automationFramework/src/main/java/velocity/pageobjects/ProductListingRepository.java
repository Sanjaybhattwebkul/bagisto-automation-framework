package velocity.pageobjects;


import java.util.List;
import java.util.stream.Collectors;

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

	public ProductListingRepository(WebDriver driver) 
	{
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

	/*@FindBys({ 
		@FindBy(css = "div.product-price>span:last-child"),
		@FindBy(xpath = "//div[@class='card-body']  //div[@class='product-price']") 
	})
	List<WebElement> productsPrices;*/
	
	
	@FindBy(xpath="//div/span[@class='special-price'] | //div/span[@class='final-price']")
	List<WebElement> productsPrices;
	
	@FindBy(id="price_to") 
	WebElement SelectMaxPrice;
		
	By category = By.xpath("//ul[@class='main-category']/li["+categoryList.size()+"]");
	
	/*
	 * Select last category from category list on top left corner of home page
	 */
	public void listByCategory() {		
		categorySection.click();
		System.out.println(categoryList.size());	
		driver.findElement(category).click();
		
	}

	/*
	 * Verify the selected price of price range filter
	 */
	public boolean verifyPriceFilter() {	
		
		waitForWebElementToAppear(SelectMaxPrice);
		String selectedFilter = SelectMaxPrice.getAttribute("value");
		
		List<WebElement> isPriceMatch = productsPrices.stream()
				.filter(price -> removeComma(price.getText().substring(0, price.getText().length()-3))
				.equalsIgnoreCase(selectedFilter)).collect(Collectors.toList());	
		
		return ((isPriceMatch.size()>0) ? true : false);
	}

}
