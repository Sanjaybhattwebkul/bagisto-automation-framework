package admin.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstraction.AbstractComponent;

public class SalesRepository extends AbstractComponent {
	
	WebDriver driver;
	public SalesRepository(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr[1]/td[9]/div/a")
	 WebElement viewOrder;
	
	@FindBy(css="a[class*='btn btn-lg btn-primary']:nth-child(3)")
	WebElement shipButton;
	
	@FindBy(css="select[name*='shipmen']")	
	WebElement selectSource;
	
	@FindBy(css="div[class='page-action'] :first-child")
	WebElement saveShipMentButton;
	
	public void createShipping() {
		salesIcon.click();
		viewOrder.click();
		shipButton.click();
		scrollDown(driver,950);
		selectOptions(selectSource,"Default");
		saveShipMentButton.click();
	}

}
