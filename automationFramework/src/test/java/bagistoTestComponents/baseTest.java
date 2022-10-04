package bagistoTestComponents;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import velocity.pageobjects.LandingPage;

public class baseTest {
	public WebDriver driver;
	public WebDriver initlizeBrowser() throws IOException {
		
		// Get GlobalData using Properties class
		Properties prop = new Properties(); // create Properties() object for get GlobalData.properties file 
		FileInputStream files = new FileInputStream("/home/users/sanjay.bhatt/www/html/Bagisto-Automation/automationFramework/src/main/java/resources/GlobalData.properties");
		prop.load(files); // load the GlobalData.properties file.
		String browserName = prop.getProperty("browser"); // get the browser name from GlobalData.properties file
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("BROWSER NAME="+browserName);
		} else if(browserName.equalsIgnoreCase("fireFox")) {
				// FireFox 	
		}  else if(browserName.equalsIgnoreCase("edge")) {
			//edge browser 
		} else {
			System.out.println("BROWSER NAME="+browserName);
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}

	public LandingPage launcVelocity() throws IOException {
		
		driver = initlizeBrowser();
		LandingPage LandingPage = new LandingPage(driver);
		LandingPage.goTo();  // open browser/site
		return LandingPage; // LandingPage object ko is liye return kiya kyuki loginApplication() function bhi call  ho ra hai.
	}
}
