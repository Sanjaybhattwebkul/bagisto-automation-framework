package velocity.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import bagisto.automationFramework.AbstractComponent;

public class MiniCarPriceValidate  extends AbstractComponent{
	WebDriver driver;
	public MiniCarPriceValidate(WebDriver driver) {
		super(driver); //Assign driver to AbstractComponent class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='close']")
	WebElement CloseFlashMessage;
		
	@FindBy(xpath="//span[@class='card-total-price fw6']")
	List<WebElement> productsPrice;
	
	@FindBy(css=".modal-footer h5:nth-child(2)")
	WebElement FormattedPrice;
	
	public CartPriceVerify verifyMiniCartPrice() throws InterruptedException {	
		CloseFlashMessage.click();
		clickOnCartIcon();	
		System.out.println("INSIDE THE VERIFY MINICART METHOD");
		List<WebElement> miniCartmount = (List<WebElement>) productsPrice;		
		int actualAmount=0;
		for(int i=0; i<miniCartmount.size(); i++) {				
			String finalAmount =	removeComma(miniCartmount.get(i).getText().substring(1));// remove , from price
			//convert string to double
			double itemAmount = Double.parseDouble(finalAmount);
			// convert into int
			int intsTotalAmount = (int)itemAmount;				 
			System.out.println(actualAmount+ "+" + intsTotalAmount);			 
			actualAmount =actualAmount + intsTotalAmount;			
		}	
		
		String finalGrandAmount  = removeComma(FormattedPrice.getText().substring(1));		
		System.out.println(finalGrandAmount);		 
		double total = Double.parseDouble(finalGrandAmount);
		int grandTotalAmount = (int)total;	 // convert into int		 
		Assert.assertEquals(grandTotalAmount,actualAmount); // check if(givenAmout==actualAmount);
		System.out.println("Test case is pass");
		return new CartPriceVerify(driver);
	}
	
}
