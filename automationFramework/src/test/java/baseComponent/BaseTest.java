package baseComponent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import admin.pageobjects.LoginPageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
import velocity.pageobjects.ProductListing;

public class BaseTest {
	
	public static WebDriver driver;
	public String AdminURL; 
	public String ShopURL; 
	public Properties prop;
	public FileInputStream files;
	
	public WebDriver initlizeBrowser() throws IOException, AWTException {
		getGlobalData();
		AdminURL = prop.getProperty("AdminURL");
		ShopURL = prop.getProperty("ShopURL");
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");		
		System.out.println("Browser="+ browserName);		
		if(browserName.equalsIgnoreCase("chromeheadless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOption = new ChromeOptions();
			chromeOption.addArguments("--headless");
			driver = new ChromeDriver(chromeOption);
			
		}else if (browserName.equalsIgnoreCase("chrome")) {	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("fireFox")) {	
			
			System.getProperty("webdriver.gecko.driver", "user.dir"+ "/geckodriver");
			driver = new FirefoxDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			//TODO
			
		} else {
			//TODO
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		fullScreenMode(browserName);
		return driver;
	}
	
	public LoginPageObject launcAdminPanel() throws IOException, AWTException {
		driver = initlizeBrowser();
		goToAdminPanel();
		return new LoginPageObject(driver);
	}
	
	public void fullScreenMode(String mode) throws AWTException {
		if(mode=="chromeheadless") {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F11);	
		} else {
			driver.manage().window().maximize();
		}
			
	}

	public void goToAdminPanel() {
		driver.get(AdminURL);
	}
	
	public ProductListing launcVelocity() throws IOException, AWTException {
		driver = initlizeBrowser();
		goToVelocityShop();
		ProductListing ProductListing = new ProductListing(driver);
		return ProductListing; 
	}

	public void goToVelocityShop() {
		driver.get(ShopURL);
	}
	

	@AfterMethod(enabled = false)
	public void closeBrowser() {
		driver.close();
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
	
	/**
	 * 
	 * This function will take a screenshot of any element and save it to inside Reports directory
	 * 
	 */
	public String getScreenshot(String testClassNmae, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver; //TakesScreenshot IS INTERFACE.
		File source = ss.getScreenshotAs(OutputType.FILE); //getScreenshotAs Is method of TakesScreenshot interface.
		File File = new File(System.getProperty("user.dir") + "//ExtentReport//" + testClassNmae + ".png");
		FileUtils.copyFile(source, File); //copyFile is static method of FileUtils class
		return System.getProperty("user.dir") + "//ExtentReport//" + testClassNmae + ".png";
	}

	/**
	 * 
	 * This method will set any parameter string to the system's clipboard.
	 * 
	 */

	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}

	public static void uploadFile(String fileLocation) {
		try {

			// Setting ClipBoard with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public void getGlobalData() throws IOException {
		prop = new Properties(); // create Properties() object for get GlobalData.properties file
		files = new FileInputStream("/home/users/sanjay.bhatt/www/html/Bagisto-Automation/automationFramework/src/main/java/resources/GlobalData.properties");
		prop.load(files); // load the GlobalData.properties file.
				
	}
}
