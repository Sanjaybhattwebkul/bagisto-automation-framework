package bagissto.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class index extends testCases{

	public static void main(String[] args) throws InterruptedException {
		configBrowserExe("/chromedriver"); //geckodriver
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		openBrowser(driver,"http://192.168.15.237/bagisto-demo/public/");
		scrollDown(driver);
		Thread.sleep(2000);
		String[] cartProducts = {"Men's Polo T-shirt","Sunglasses"}; // products for add to cart.
		addToCart(driver,cartProducts); // add-Product-to-cart
		
	}

}