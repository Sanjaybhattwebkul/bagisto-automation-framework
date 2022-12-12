package admin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

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
	
	//@FindBy(css="iframe[id='short_description_ifr']")
	@FindBy(xpath="//iframe[@id='short_description_ifr']")
	WebElement shortDescriptionIframe;
	
	@FindBy(id="short_description")
	WebElement shortDescriptionTextarea;
	
	@FindBy(xpath="//iframe[@id='description_ifr']")
	WebElement descriptionIframe;
	
	@FindBy(id="description")
	WebElement DescriptionTextarea;
	
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

	public void editSimpleProduct(String[] productsAttributes) throws InterruptedException {	
		productsName.sendKeys(productsAttributes[0]);
		scrollDown(driver,440);			
		isNew.click();
		isFeatured.click();
		visibleIndividually.click();
		productsStatus.click();
		scrollDown(driver,440);		
		guestCheckout.click();
		descriptionSection.click();
		scrollDown(driver,320);	
		
		if (shortDescriptionIframe.isEnabled()) {
			switchToFrame(productsAttributes[1],productsAttributes[2]);				
			backToMainPage();			
		} else {
			shortDescriptionTextarea.sendKeys(productsAttributes[2]);
		}
		
		if (descriptionIframe.isEnabled()) {
			switchToFrame(productsAttributes[3],productsAttributes[4]);				
			backToMainPage();		
		} else {
			DescriptionTextarea.sendKeys(productsAttributes[4]);
		}
		scrollDown(driver,800);	//descriptionSection.click();
		priceSection.click();
		productsPrice.sendKeys(productsAttributes[5]);
		specialPrice.sendKeys(productsAttributes[6]);
		specialPriceFromDate.click();		
		handleCalendarDate(getDate("TODAY_DATE","d"),getDate("TODAY_DATE","MMMM")); /* handling calendar */
		specialPriceToDate.click();
		handleCalendarDate(getDate("AFTER_DATE","d"),getDate("TODAY_DATE","MMMM")); /* Select current date */
		scrollDown(driver,250);	//priceSection.click();
		shippingSection.click();
		scrollDown(driver,450);
		productsWeight.sendKeys(productsAttributes[7]);
		inventorySection.click();
		defaultInventory.sendKeys(productsAttributes[8]);		
		imageSection.click();
		addImage.click();
		System.out.println(selectImage.isDisplayed());
		Thread.sleep(1000);
		System.out.println(selectImage.isDisplayed());
		selectImage.click();
		uploadFile(productsAttributes[9]);
		Thread.sleep(2000);
		saveProductButton.click();
		
	}
	
	public void switchToFrame(String frameId,String value) {
		driver.switchTo().frame(frameId); // Switch to short description frame
		driver.findElement(By.tagName("p")).sendKeys(value);
	}
	
	public void backToMainPage() {
		driver.switchTo().defaultContent(); 
	}
}
