package Shop.Tests;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Shop.TestComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class test extends baseTest{
	@Test
	public void testCase() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//launcVelocity();
	}
}
