package admin.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstraction.AbstractComponent;

public class CatalogPageObject extends AbstractComponent{
	
	WebDriver driver;
	
	public CatalogPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='navbar-left']/ul/li[5]")
	WebElement permotionIcon;
	
	@FindBy(linkText="Add Catalog Rule")
	WebElement addCatalogButton;
	
	@FindBy(id="name")
	WebElement catalogRuleName;
	
	@FindBy(id="description")
	WebElement description;
	
	@FindBy(xpath="//div[@class='control-group'][3]/label[2]/span")
	WebElement status;
	
	@FindBy(id="channels")
	WebElement selectChannels;
	
	@FindBy(id="customer_groups")
	WebElement selectCustomerGroup;
	
	@FindBy(css="input[name='starts_from']")
	WebElement startDate;
	
	@FindBy(css="input[name='ends_till']")
	WebElement endDate;
	
	@FindBy(xpath="//div[@class='accordian'][1]")
	WebElement conditionSection;
	
	@FindBy(xpath="//div[@class='accordian active'][2]/div[2]/div/button")
	WebElement addCondtionButton;
	
	@FindBy(xpath="//div[@class='attribute']/div/select")
	WebElement selectAttribute;
	
	@FindBy(xpath="//div[@class='operator']/div/select")
	WebElement actionType;
	
	@FindBy(xpath="//div[@class='value']/div/div/div/input")
	WebElement value;
	
	@FindBy(xpath="//div[@class='accordian']")
	WebElement actions;
	
	@FindBy(id="action_type")
	WebElement actionName;
	
	@FindBy(id="discount_amount")
	WebElement discountAmount;
	
	@FindBy(xpath="//div[@class='page-action']/button")
	WebElement saveButton;
		
	public void createCatalogRuleFor(String[] catalogRulevalues) throws InterruptedException {
		permotionIcon.click();
		addCatalogButton.click();
		catalogRuleName.sendKeys(catalogRulevalues[0]);
		description.sendKeys(catalogRulevalues[1]);
		status.click();
		scrollDown(driver,500);
		handleMultiSelect(selectChannels,"");
		handleMultiSelect(selectCustomerGroup,"");
		startDate.click();		
		handleCalendarDate(getDate("TODAY_DATE","d"),getDate("TODAY_DATE","MMMM")); /* handling calendar */
		endDate.click();
		handleCalendarDate(getDate("AFTER_DATE","d"),getDate("TODAY_DATE","MMMM")); /* Select current date */
		conditionSection.click();
		scrollDown(driver,200);
		addCondtionButton.click();
		scrollDown(driver,300);
		handleMultiSelect(selectAttribute,catalogRulevalues[2]);
		handleMultiSelect(actionType,catalogRulevalues[3]);
		value.sendKeys(catalogRulevalues[4]);
		actions.click();
		scrollDown(driver,300);
		handleMultiSelect(actionName,catalogRulevalues[5]);
		discountAmount.sendKeys(catalogRulevalues[6]);
		saveButton.click();
		
		
	}
	
	public void handleMultiSelect(WebElement selectBox,String value) {
		Select options = new Select(selectBox);
		if (options.isMultiple()) {			
			options.selectByIndex(0);
			options.selectByIndex(1);
		} else {
			options.selectByVisibleText(value);
		}
	}
}
