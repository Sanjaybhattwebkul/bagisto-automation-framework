package admin.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import baseComponents.*;

public class CreateProductRepository extends BaseRepository{
	WebDriver driver;
	public CreateProductRepository(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
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
	
	@FindBy(xpath="//tbody/tr[1]/td[11]/div/a[1]")
	WebElement editIcon;
	
	By addButton = By.linkText("Add Product");
	By selectType = By.id("type");
	
	public EditProductRepository createSimpleProduct(String[] productsDetails) { 
		 gotoProductsPage();
		 waitForElementToAppear(addButton); //explicitly wait
		 addProduct.click();
		 waitForElementToAppear(selectType);
		 selectProductType.click();
		 selectOptions(selectProductType,productsDetails[0]); 		 
		 attributeFamily.click();
		 selectOptions(attributeFamily,productsDetails[1]);		 
		 productSKU.sendKeys(productsDetails[2]);		
		 saveProduct.click();
		 if(isCreated()) {	
			 System.out.println("Product Created SuccessFully");
			 return new EditProductRepository(driver);
			}
		return null; 
		
	}
	
	public EditProductRepository edit() {
		gotoProductsPage();
		waitForElementToAppear(addButton);
		editIcon.click();
		return new EditProductRepository(driver);
	}
	
}
