package admin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import bagisto.automationFramework.*;

public class CreateProduct extends AbstractComponent{
	WebDriver driver;
	public CreateProduct(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='navbar-left']/ul/li[3]")
	WebElement catalogIcon;
	
	@FindBy(linkText ="Add Product")
	WebElement addProduct;
	
	@FindBy(id="type")
	WebElement selectProductType;	
	
	@FindBy(id="attribute_family_id")
	WebElement attributeFamily;
	
	@FindBy(id="sku")
	WebElement productSKU;
	
	@FindBy(css="button[class='btn btn-lg btn-primary']")
	WebElement saveProduct;
	
	@FindBy(xpath="//p[text()='Product created successfully.']")
	WebElement successMessage;
	
	By addButton = By.linkText("Add Product");
	By selectType = By.id("type");
	
	public void createSimpleProduct() {
		System.out.println("Create product function started"); 
		catalogIcon.click();
		 waitForElementToAppear(addButton); //explicitly wait
		 addProduct.click();
		 waitForElementToAppear(selectType);
		 selectProductType.click();
		 Select productType = new Select(selectProductType);
		 productType.selectByVisibleText("Simple"); // Select Product Type
		 attributeFamily.click();
		 Select Family = new Select(attributeFamily);
		 Family.selectByVisibleText("Default"); // Select Attribute Family
		 productSKU.sendKeys("mens-tshirt");
		 saveProduct.click();
	}
	
}
