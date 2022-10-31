package velocity.pageobjects;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bagisto.automationFramework.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory TestNG ka part h is se annotation use kr skte h.
	}
	
	
}
