package bagisto.automationFramework;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		@FindBy(xpath="//div[@id='mini-cart']")
		WebElement cart;
		
		@FindBy(css="a[class*='navbar-brand']")
		WebElement logo;
		
		@FindBy(xpath="//a[@class='close']")
		WebElement flashMessage;
		
		@FindBy(css="a[class*='remove-decoration']")
		WebElement viewCart;
		
		@FindBy(linkText="View Shopping Cart")
		WebElement viewShoppingCart;
		
		public void clickOnCartIcon() {
			cart.click();
		}
				
		public void gotoCartPage() {
			viewShoppingCart.click();
		}
		
		public  void waitForElementToAppear(By findBy) {
			WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
			waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		
		public static void waitForWebElementToAppear(WebElement findBy) {
			//WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
			//waite.until(ExpectedConditions.visibilityOf(findBy));
		}
		
		public static void scrollDown(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy(0,440)");
		}
		
		public static void scrollUp(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy(0,-900)");
		}
		
		public void waiteForElementToDisAppear() throws InterruptedException {
			Thread.sleep(2000);
			//WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
			//waite.until(ExpectedConditions.invisibilityOf(element));
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
		
}
