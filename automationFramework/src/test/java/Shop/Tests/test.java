package Shop.Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import baseComponent.BaseTest;
import helpers.productsActions;


public class test extends BaseTest{
	@Test
	public void testCase() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");
		driver.manage().window().maximize();
		WebElement button = driver.findElement(By.xpath("//a[contains(@class,'button')][3]"));
		String colorInRGB = button.getCssValue("color");
		String colorInHex = Color.fromString(colorInRGB).asHex();
		
		if(checkColor(colorInHex)) {
			System.out.println("Button is green");
		}else {
			System.out.println("Button is Not green");
		}		
	}
	
	public boolean checkColor(String checkFor) {
		return (checkFor=="#00FF00" ? true : false );
	}

	
}
