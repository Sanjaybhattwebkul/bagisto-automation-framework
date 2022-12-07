package bagisto.automationFramework;

import java.util.*;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import velocity.pageobjects.CartPriceVerify;
import velocity.pageobjects.SearchProduct;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='mini-cart']")
	WebElement cart;

	@FindBy(css = "a[class*='navbar-brand']")
	WebElement logo;

	@FindBy(xpath = "//a[@class='close']")
	WebElement flashMessage;

	@FindBy(css = "a[class*='remove-decoration']")
	WebElement viewCart;

	@FindBy(linkText = "View Shopping Cart")
	WebElement viewShoppingCart;	
	
	@FindBy(xpath="//div[contains(@class,'open')]/div/div/div/select")				 
	WebElement monthsDropdown;

	@FindBy(xpath="//div[contains(@class,'open')]/div/span[2]")
	WebElement nextMonth;
	
	@FindBy(xpath="//div[@class='navbar-left']/ul/li[3]")
	WebElement catalogIcon;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement lastProductID;
	
	@FindBy(css="span[title='Visit Shop']")
	WebElement visitShop;
	
	/*
	 * @void
	 * Visible miniCart
	 */
	public void clickOnCartIcon() {
		cart.click();
	}
	
	public void gotoProductsPage() {
		catalogIcon.click();
	}

	/*
	 * @Void
	 * Go to shop
	 */
	public SearchProduct visitShop() {
		visitShop.click();
		return new SearchProduct(driver);
	}
	
	/*
	 * @Integer
	 * get Last created  product's ID	
	 */
	public int getCreatedProductId() {
		return Integer.parseInt(lastProductID.getText());
	}
	
	/*
	 * @void
	 * Redirect to cart page
	 */
	public CartPriceVerify gotoCartPage() {
		viewShoppingCart.click();
		return new CartPriceVerify(driver);
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait waite = new WebDriverWait(driver, Duration.ofSeconds(5));
		waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	/*
	 * @void
	 * Explicitly wait for element Appear. 
	 */
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver, Duration.ofSeconds(5));
		waite.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	/*
	 * @void
	 * Scroll Down the DOM
	 */
	public static void scrollDown(WebDriver driver, int to) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + to + ")");
	}

	/*
	 * @void
	 * Scroll UP the DOM
	 */
	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-900)");
	}
	
	/*
	 * @void
	 * Explicitly wait for element disappear. 
	 */
	public void waiteForElementToDisAppear(WebElement element) throws InterruptedException {
		
		 WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5));
		 waite.until(ExpectedConditions.invisibilityOf(element));
	}

	/*
	 * @void
	 * Redirect to shop.
	 */
	public void goToHomePage() {
		logo.click();

	}
	
	/*
	 * @void
	 * Close the flash message
	 */
	public void closeFlashMessage() {
		flashMessage.click();
	}

	/*
	 * @Srting
	 * Remove comma from given string
	 */
	public static String removeComma(String str) {
		return str.replaceAll("[^a-zA-Z0-9.]", ""); // remove , from price
	}

	/*
	 * @String
	 * Get the subTotal from cart-summary secTnion.
	 */
	public String getSubTotalOfCartSummary(WebElement cartSummarySubTotal) {
		return cartSummarySubTotal.getText();
	}

	/*
	 * Handle calendar dates and click on request date for special price apply.
	 */
	public void handleCalendarDate(String date,String currentMonth) throws InterruptedException {
		 Select selectMonth = new Select(monthsDropdown); 	
		 WebElement month = selectMonth.getFirstSelectedOption();
	     String selectedoption = month.getText();
	     boolean  selectedMonthIsCurrentMonth = selectedoption.equalsIgnoreCase(currentMonth);
	     if (! selectedMonthIsCurrentMonth) {
	    	 while (selectedoption != currentMonth) {
				 Thread.sleep(1000);
				 nextMonth.click(); // click on next arrow
			}
	     }
	     
	     handleLastDatesOfMonth(date); // check if next date is greater then last date of months.	     
	     List<WebElement> currentMonthsDates = driver.findElements(By.xpath("//div[contains(@class,'open')]/div[2]/div[2]/div[2]//span[contains(@aria-label,"+currentMonth+")]"));
	     for (int i = 0; i < currentMonthsDates.size(); i++) {
			String text = currentMonthsDates.get(i).getText(); // get text of dateBox
			if (text.equalsIgnoreCase(date)) {								
				currentMonthsDates.get(i).click(); // click on dateBox
				break;
			}
		}
	}
	
	/*
	 * Click on next button if next date if greater then 30 or 31
	 */
	public void handleLastDatesOfMonth(String date) {
		
		if(Integer.parseInt(date) >= 27) {
			nextMonth.click();
		}
	}
	
	/*
	 * Get After Date
	 */
	public String getDate(String rquestType,String formatType) {
		Calendar calendar = Calendar.getInstance();  // get a calendar instance, which defaults to "now"	   	
		Date requestFormat = calendar.getTime();		 
		if(rquestType=="AFTER_DATE") {
			calendar.add(Calendar.DAY_OF_YEAR, 5);
			requestFormat = calendar.getTime();
		}
		
		return  new SimpleDateFormat(formatType).format(requestFormat);
	}
	
	/**
	 * 
	 * This method will set any parameter string to the system's clipboard.
	 * 
	 */
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}
	
	/**
	 * 
	 * Upload the image from local system
	 * 
	 */
	public static void uploadFile(String fileLocation) {
		try {
			// Setting ClipBoard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
