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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import velocity.pageobjects.ProductListing;

public class baseTest {
	public WebDriver driver;
	public 	String ShopURL; 
	public WebDriver initlizeBrowser() throws IOException {

		// Get GlobalData using Properties class
		Properties prop = new Properties(); // create Properties() object for get GlobalData.properties file
		FileInputStream files = new FileInputStream(
				"/home/users/sanjay.bhatt/www/html/Bagisto-Automation/automationFramework/src/main/java/resources/GlobalData.properties");
		prop.load(files); // load the GlobalData.properties file.
		ShopURL = prop.getProperty("ShopURL");
		//String browserName = prop.getProperty("browser"); // get the browser name from GlobalData.properties file
		
		// If Browser Name is getting from Maven Command the it will take from there else from GlobalData file.
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//System.out.println(System.getProperty("user.dir"+"/geckodriver"));		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless"); // If we want to run testCases in Headless mode			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("fireFox")) {
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/geckodriver");		
			System.getProperty("webdriver.gecko.driver", "user.dir"+ "/geckodriver");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// edge browser // edge browser
		} else {
			System.out.println("I AM ELSE AND BROWSER NAME=" + browserName);

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	
	public ProductListing launcVelocity() throws IOException {

		driver = initlizeBrowser();
		goToVelocityShop(); // open browser/site
		ProductListing ProductListing = new ProductListing(driver);
		return ProductListing; // LandingPage object ko is liye return kiya kyuki loginApplication() function
								// bhi call ho ra hai.
	}

	public void goToVelocityShop() {
		driver.get(ShopURL);
	}

	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}

	// This function will get data from JSON file and return the data in from of
	// HashMap
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json file to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		// String to HashMap- using ackson-databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
		// {map, map}
	}

	public String getScreenshot(String testClassNmae, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver; //TakesScreenshot IS INTERFACE.
		File source = ss.getScreenshotAs(OutputType.FILE); //getScreenshotAs Is method of TakesScreenshot interface.
		File File = new File(System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png");
		FileUtils.copyFile(source, File); //copyFile is static method of FileUtils class
		return System.getProperty("user.dir") + "//Reports//" + testClassNmae + ".png";
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		

	}
}
