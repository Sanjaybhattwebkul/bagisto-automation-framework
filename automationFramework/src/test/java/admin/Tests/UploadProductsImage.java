package admin.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import admin.TestComponents.adminBaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadProductsImage extends adminBaseTest{

	String URL = "https://www.ilovepdf.com/pdf_to_jpg";
	
	@Test
	public void testUpload() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		WebElement element = driver.findElement(By.id("pickfiles"));
		element.click();
		uploadFile("//home//users//sanjay.bhatt//Pictures//Abhay_Resume.pdf");
		Thread.sleep(2000);
	}
}
