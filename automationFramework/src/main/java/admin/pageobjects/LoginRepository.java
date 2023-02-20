package admin.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseComponents.BaseRepository;

public class LoginRepository extends BaseRepository{
	WebDriver driver;
	public LoginRepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory TestNG ka part h is se annotation use kr skte h.
	}
	
	@FindBy(how = How.CSS, using = "#email") 
	WebElement email;
	
	@FindAll(@FindBy(how = How.CSS, using = "#password"))
	WebElement Password;
	
	@FindBy(css="button[class='btn btn-xl btn-primary']")
	WebElement loginButton;
	
	public void adminLogin(String adminEmail, String adminPassword) {				
		email.sendKeys(adminEmail);
		Password.sendKeys(adminPassword);
		loginButton.click();
	}
	
}
