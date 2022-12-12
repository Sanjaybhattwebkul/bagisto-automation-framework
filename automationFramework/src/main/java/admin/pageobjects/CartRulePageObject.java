package admin.pageobjects;

import org.openqa.selenium.WebDriver;

import abstraction.AbstractComponent;

public class CartRulePageObject extends AbstractComponent{
	WebDriver driver;
	
	public CartRulePageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}

}
