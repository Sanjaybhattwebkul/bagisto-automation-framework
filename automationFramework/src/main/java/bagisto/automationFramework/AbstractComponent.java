package bagisto.automationFramework;

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

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.cssSelector("[routerLink*='cart']")).click();
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

	@FindBy(xpath = "//span[contains(@aria-label,'November ')]")
	List<WebElement> totalDates;
	
	@FindBy(xpath="//div[contains(@class,'open')]/div/div/div/select")
				   //div[@class='flatpickr-calendar hasWeeks animate arrowTop arrowLeft open']/div/div/div/select
	WebElement monthsDropdown;

	public void clickOnCartIcon() {
		cart.click();
	}

	public void gotoCartPage() {
		viewShoppingCart.click();
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait waite = new WebDriverWait(driver, Duration.ofSeconds(5));
		waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait waite = new WebDriverWait(driver, Duration.ofSeconds(5));
		waite.until(ExpectedConditions.visibilityOf(findBy));
	}

	public static void scrollDown(WebDriver driver, int to) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + to + ")");
	}

	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-900)");
	}

	public void waiteForElementToDisAppear() throws InterruptedException {
		Thread.sleep(2000);
		// WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5));
		// waite.until(ExpectedConditions.invisibilityOf(element));
	}

	public void goToHomePage() {
		logo.click();

	}

	public void closeFlashMessage() {
		flashMessage.click();
	}

	public static String removeComma(String str) {
		return str.replaceAll("[^a-zA-Z0-9.]", ""); // remove , from price
	}

	public String getSubTotalOfCartSummary(WebElement cartSummarySubTotal) {
		return cartSummarySubTotal.getText();
	}

	public void handleCalendarDate(String date,String currentMonth) throws InterruptedException {
		monthsDropdown.click();
		Select selectMonth = new Select(monthsDropdown); 	// select the current moth from calendar			
		selectMonth.selectByVisibleText(currentMonth); 	
		
		// Select the given date
		int count = totalDates.size(); // count total dates on calendar
		for (int i = 0; i < count; i++) {
			String text = totalDates.get(i).getText(); // get text of dateBox
			if (text.equalsIgnoreCase(date)) {
				totalDates.get(i).click(); // click on dateBox
				System.out.println(text);
				break;
			}
		}
	}

	/*
	 * Get current date
	 */
	public String getDate(String type) {
		SimpleDateFormat formatter = new SimpleDateFormat(type);
		return formatter.format(new Date());

	}

}
