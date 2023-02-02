package baseComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLocators extends BaseRepository{
	
	WebDriver driver;
	
	public CustomerLocators(WebDriver driver) {		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector("div[class*='welcome-content']")).click();
	@FindBy(css="div[class*='welcome-content']")
	public WebElement loginPoPup;
	
	//driver.findElement(By.xpath("//a[@class='theme-btn fs14 fw6'][1]")).click();
	@FindBy(xpath="//a[@class='theme-btn fs14 fw6'][1]")
	public  WebElement loginPopButton;
	
	@FindBy(name="email")
	public  WebElement userEmail;
	
	@FindBy(id="password")
	public WebElement passwordElement;	
	
	@FindBy(css="input[type='submit']")
	public WebElement loginButton;
	
	@FindBy(xpath="//li[@title='Address']/a/span")
	public WebElement addressIcon;
	
	@FindBy(css="span[class='account-action']")
	public WebElement addAddressButton;
		
	@FindBy(name="company_name")
	public  WebElement companyName;
	
	@FindBy(id="address_0")
	public  WebElement streetAddress;
	
	@FindBy(id="country")
	public  WebElement countryName;
	
	@FindBy(id="state")
	public WebElement state;
	
	@FindBy(name="city")
	public  WebElement city;
	
	@FindBy(name="postcode")
	public  WebElement postcode;
	
	@FindBy(name="phone")
	public WebElement phone;
	
	
	@FindBy(id="default_address")
	public  WebElement defaultAddress;
	
	@FindBy(css="button[type='submit']")
	public WebElement saveAddress;
}
