package admin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bagisto.automationFramework.AbstractComponent;

public class EditProductPageObject extends AbstractComponent {
	
	public WebDriver driver;
	/*
	 * Assign driver object to PageFactory class AND EditProductPageObject class 
	 */
	public EditProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	WebElement productsName;
	
	@FindBy(xpath="//div[@class='control-group boolean'][1]/label[2]")
	WebElement isNew;
	
	@FindBy(xpath="//div[@class='control-group boolean'][2]/label[2]")
	WebElement isFeatured;
	
	@FindBy(xpath="//div[@class='control-group boolean'][3]/label[2]")
	WebElement visibleIndividually;
	
	@FindBy(xpath="//div[@class='control-group boolean'][4]/label[2]")
	WebElement productsStatus;
	
	@FindBy(xpath="//div[@class='control-group boolean'][5]/label[2]")
	WebElement guestCheckout;
	
	@FindBy(xpath="//div[@class='page-content']/div[2]/div[1]")
	WebElement descriptionSection;
	
	@FindBy(xpath="//div[@class='page-content']/div[4]/div[1]")
	WebElement priceSection;
		
	@FindBy(xpath="//input[@id='price']")
	WebElement productsPrice;
	
	@FindBy(id="special_price")
	WebElement specialPrice;
	
	@FindBy(name="special_price_from")
	WebElement specialPriceFromDate;
	
	@FindBy(name="special_price_to")
	WebElement specialPriceToDate;
	
	@FindBy(xpath="//div[@class='page-content']/div[5]/div[1]")
	WebElement shippingSection;
	
	@FindBy(id="weight")
	WebElement productsWeight;
	
	@FindBy(xpath="//div[@class='page-content']/div[6]/div[1]")
	WebElement inventorySection;
	
	@FindBy(css="input[name*='inventories']")
	WebElement defaultInventory;
	
	@FindBy(xpath="//div[@class='page-content']/div[7]/div[1]")
	WebElement imageSection;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[2]/div[7]/div[2]/div[1]/div[1]/div[1]/label[1]")
	WebElement addImage;
	
	@FindBy(css="label[class='image-item draggable']")
	WebElement selectImage;
	
	@FindBy(xpath="//div[@class='page-action']/button")
	WebElement saveProductButton;

	public void editSimpleProduct() throws InterruptedException {	
		productsName.sendKeys("Product-By Selnium Automation");
		scrollDown(driver,440);			
		isNew.click();
		isFeatured.click();
		visibleIndividually.click();
		productsStatus.click();
		scrollDown(driver,440);		
		guestCheckout.click();
		descriptionSection.click();
		scrollDown(driver,320);	
		driver.switchTo().frame("short_description_ifr"); // Switch to short description frame
		driver.findElement(By.tagName("p")).sendKeys("Short description By Selenium Automation");
		driver.switchTo().defaultContent(); // Switch to main DOM
		driver.switchTo().frame("description_ifr"); // Switch to description frame
		driver.findElement(By.tagName("p")).sendKeys("This product is created by Selenium Aumatation");
		driver.switchTo().defaultContent();
		scrollDown(driver,800);	//descriptionSection.click();
		priceSection.click();
		productsPrice.sendKeys("4500");
		specialPrice.sendKeys("3500");
		specialPriceFromDate.click();
		
		handleCalendarDate(getDate("TODAY_DATE","d"),getDate("TODAY_DATE","MMMM")); /* handling calendar */
		specialPriceToDate.click();
		handleCalendarDate(getDate("AFTER_DATE","d"),getDate("TODAY_DATE","MMMM")); /* Select current date */
		scrollDown(driver,250);	//priceSection.click();
		shippingSection.click();
		scrollDown(driver,450);
		productsWeight.sendKeys("0.6");
		inventorySection.click();
		defaultInventory.sendKeys("450");
		inventorySection.click(); // hide inventory section
		imageSection.click();
		addImage.click();
		System.out.println(selectImage.isDisplayed());
		Thread.sleep(1000);
		System.out.println(selectImage.isDisplayed());
		selectImage.click();
		uploadFile("//home//users//sanjay.bhatt//Downloads//watch2.png");
		Thread.sleep(2000);
		saveProductButton.click();
		
	}
}
