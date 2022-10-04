package bagisto.automationFramework;
import java.time.Duration;
import org.openqa.selenium.By;
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
		@FindBy(css="[routerlink*='cart']")
		WebElement cart;
		
		public  void waitForElementToAppear(By findBy) {
			WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
			waite.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		
		public void waiteForElementToDisAppear(WebElement element) throws InterruptedException {
			Thread.sleep(1000);
			//WebDriverWait waite = new WebDriverWait(driver,Duration.ofSeconds(5)); 
			//waite.until(ExpectedConditions.invisibilityOf(element));
		}
		
		public void goToCartPage()
		{
			//cart.click();
			//return  new CartPage(driver);
		}
}
