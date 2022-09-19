package bagissto.core;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class testCases {

	public static void configBrowserExe(String fileName) {
		System.getProperty("webdriver.chrome.driver", "user.dir"+ fileName);
		
	}
	
	public static void openBrowser(WebDriver driver, String URL) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); 
		driver.get(URL);
	}
	
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,440)");
	}
	
	public static void addToCart(WebDriver driver, String[] cartProducts) {
		int j=0;
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='product-name']/span")); // products array	
		System.out.println(products);
		for (int i = 1; i<products.size(); i++) {
			List itemForAddToCart = Arrays.asList(cartProducts); //Convert stringArray to arrayList			
			if (itemForAddToCart.contains(products)) {
				j++;
				//click on add to cart button
				System.out.println("clicked");
				//driver.findElement(By.xpath("//button[@class='btn btn-add-to-cart.small-padding']")).get(i).click();
			}
			
			if(j == cartProducts.length) {
				break;
			}			
		}		
	}
}
