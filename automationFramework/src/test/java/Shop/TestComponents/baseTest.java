package Shop.TestComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import velocity.pageobjects.ProductListing;

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
	
	
	public ProductListing launcVelocity() throws IOException {
		
		driver = initlizeBrowser();
		goToVelocityShop();  // open browser/site
		ProductListing ProductListing = new ProductListing(driver);
		return ProductListing; // LandingPage object ko is liye return kiya kyuki loginApplication() function bhi call  ho ra hai.
	}
	
	public void goToVelocityShop() {
		driver.get("http://192.168.15.237/bagisto4.5/public/");
		//scrollDown(driver);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	// This function will get data from JSON file and return the data in from of HashMap 
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//read json file  to string
		String jsonContent = 	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		//String to HashMap- using ackson-databind
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		 return data;
		//{map, map}
	}
}
