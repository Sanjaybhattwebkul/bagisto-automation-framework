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
	
	public void editSimpleProduct() throws InterruptedException {
		productsName.sendKeys("Automoate Product");
		scrollDown(driver,440);			
		isNew.click();
		isFeatured.click();
		visibleIndividually.click();
		productsStatus.click();
		scrollDown(driver,440);		
		guestCheckout.click();
		descriptionSection.click();
		scrollDown(driver,200);	
		driver.switchTo().frame("short_description_ifr"); // Switch to short description frame
		driver.findElement(By.tagName("p")).sendKeys("Short description By Selenium Automation");
		driver.switchTo().defaultContent(); // Switch to main DOM
		driver.switchTo().frame("description_ifr"); // Switch to description frame
		driver.findElement(By.tagName("p")).sendKeys("This product is created by Selenium Aumatation");
		driver.switchTo().defaultContent();
		scrollDown(driver,800);	
		priceSection.click();
		productsPrice.sendKeys("4500");
		specialPrice.sendKeys("3500");
	}
}
