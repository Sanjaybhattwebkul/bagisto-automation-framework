package admin.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseComponents.BaseRepository;

public class PromotionsRepository extends BaseRepository{
	
	WebDriver driver;
	
	public PromotionsRepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='navbar-left']/ul/li[5]")
	WebElement permotionIcon;
	
	@FindBy(xpath="//div[@class='tabs']/ul/li[2]")
	WebElement cartRuleTab;
	
	@FindBy(linkText="Add Cart Rule")
	WebElement addCartRuleButton;	
	
	@FindBy(linkText="Add Catalog Rule")
	WebElement addCatalogButton;
	
	@FindBy(id="name")
	WebElement name;
	
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

	public boolean createCatalogRule(String[] catalogRulevalues) throws InterruptedException {
		permotionIcon.click();
		addCatalogButton.click();
		name.sendKeys(catalogRulevalues[0]);
		description.sendKeys(catalogRulevalues[1]);
		status.click();
		scrollDown(driver,500);
		selectOptions(selectChannels,"");
		selectOptions(selectCustomerGroup,"");
		startDate.click();		
		handleCalendarDate(getDate("TODAY_DATE","d"),getDate("TODAY_DATE","MMMM"),false); /* handling calendar */
		endDate.click();
		handleCalendarDate(getDate("AFTER_DATE","d"),getDate("TODAY_DATE","MMMM"),true); /* Select current date */
		conditionSection.click();
		scrollDown(driver,200);
		addCondtionButton.click();
		scrollDown(driver,300);
		selectOptions(selectAttribute,catalogRulevalues[2]);
		selectOptions(actionType,catalogRulevalues[3]);
		value.sendKeys(catalogRulevalues[4]);
		actions.click();
		scrollDown(driver,300);
		selectOptions(actionName,catalogRulevalues[5]);
		discountAmount.sendKeys(catalogRulevalues[6]);
		saveButton.click();
		if(isCreated()) {
			System.out.println("Catalog Rule  Created SuccessFully");
			return true;
		} else {
			return false;
		}
		
		
	}
	
	public boolean createCartRule(String[] cartRuleValues) throws InterruptedException {
		permotionIcon.click();
		cartRuleTab.click();
		addCartRuleButton.click();
		name.sendKeys(cartRuleValues[0]);
		description.sendKeys(cartRuleValues[1]);
		status.click();
		scrollDown(driver,500);
		selectOptions(selectChannels,"");
		selectOptions(selectCustomerGroup,"");
		startDate.click();		
		handleCalendarDate(getDate("TODAY_DATE","d"),getDate("TODAY_DATE","MMMM"),false); /* handling calendar */
		endDate.click();
		handleCalendarDate(getDate("AFTER_DATE","d"),getDate("TODAY_DATE","MMMM"),true); /* Select current date */		
		conditionSection.click();
		scrollDown(driver,200);
		addCondtionButton.click();
		scrollDown(driver,300);
		selectOptions(selectAttribute,cartRuleValues[2]);
		selectOptions(actionType,cartRuleValues[3]);
		value.sendKeys(cartRuleValues[4]);		
		actions.click();
		scrollDown(driver,300);
		selectOptions(actionName,cartRuleValues[5]);
		discountAmount.sendKeys(cartRuleValues[6]);
		saveButton.click();
		if(isCreated()) {
			System.out.println("Cart Rule  Created SuccessFully");
			return true;
		} else {
			return false;
		}
		
	}
}
