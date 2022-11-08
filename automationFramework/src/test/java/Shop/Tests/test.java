package Shop.Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Shop.TestComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class test extends baseTest{
	@Test
	public void testCase() throws IOException, InterruptedException {
		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();*/
		launcVelocity();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@class='close']")).click();
		driver.findElement(By.xpath("//div[@id='mini-cart']")).click();
	}
}
