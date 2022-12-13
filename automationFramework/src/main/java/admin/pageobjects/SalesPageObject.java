package admin.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

public class SalesPageObject extends AbstractComponent {
	
	WebDriver driver;
	public SalesPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void createShipping() {
		salesIcon.click();
		viewOrder.click();
		shipButton.click();
		scrollDown(driver,950);
	}

}
