package bagissto.testProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BypassPrivacy {

	public static void main(String[] args) {
		//Create instance of ChromeOptions Class
		ChromeOptions handlingSSL = new ChromeOptions();
		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();				
		WebDriver driver = new ChromeDriver(handlingSSL);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://expired.badssl.com/");
		

	}

}
