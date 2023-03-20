package velocity.pageobjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseComponents.BaseRepository;
import helpers.getProductsPrice;

public class CartRepository extends getProductsPrice{
	
	WebDriver driver;
	public CartRepository(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, driver); //PageFactory TestNG ka part h is se annotation use kr skte h.
		// 1st argument is value and second Parameter is variable
	}
	
	@FindBy(xpath="//div[@class='order-summary fs16']/div[1]/span[2]")
	WebElement minicartSubtotal; //total cart price in cart summary box
	
	@FindBy(xpath="//div[@class='cart-item-list']/div")
	List<WebElement> cartItemContainer;
	
	@FindBy(xpath="//span[@class='col-4 text-right']")
	WebElement cartSummarySubTotal;
	
	@FindBy(id="discount-detail")
	List<WebElement> DiscountContainr;
	
	@FindBy(xpath="//div[@id='discount-detail']/span[2]")
	WebElement discountAmount;
	
	////a[text()='Proceed to checkout']
	@FindBy(xpath="//div[contains(@class,'order-summary-container')]//a[contains(@class,'theme-btn ')]")
	WebElement processToCheckOut;
		
	By formattedPrice =By.cssSelector("div[class='product-price'] :nth-child(1)"); // 1 product's price	
	
	By plusIcon = By.cssSelector(".increase");	
	
	By quantity = By.cssSelector("#quantity-changer"); // get model attribute's value
	
	By subTotalPrice = By.cssSelector("div[class='product-price fs18 col-1'] :nth-child(1)");
	
	//verify price with quantity
	public void calCulatePrice() {		
		List<WebElement> itemContainer = cartItemContainer; //Get Item Container
		double oneProductsPrice=0;
		int Qty=0;
		double totalPrice =0;
		double Subtotal = 0;
		double GrandTotal=0;		
		List<Double> subtotal = new ArrayList<>();
		for (WebElement price:itemContainer) {
			
			oneProductsPrice = getActualPrice(price.findElement(formattedPrice).getText().substring(1));			
			System.out.println("One Products Price = " +oneProductsPrice);		
			Subtotal =getActualPrice(price.findElement(subTotalPrice ).getText().substring(1));
			System.out.println("SubTotal= " +Subtotal);	
			List<WebElement> Quantity = price.findElements(quantity);
			
			if (isElementPresent(Quantity)) {				
				Qty = Integer.parseInt(price.findElement(quantity).getAttribute("model"));
				System.out.println("One Products Quantity = " +Qty);	
				totalPrice = (oneProductsPrice*Qty);				
			} else {
				totalPrice=Subtotal;				
			}
		   
			System.out.println("One Products total Price= " +totalPrice);
			Assert.assertEquals(totalPrice,Subtotal); // check if(totalPrice==subTotal);
			subtotal.add(Subtotal); // Add subTotal of each product in arrayList
			totalPrice=0; Subtotal=0; oneProductsPrice=0; Qty=0;		
		}	
		
		double sumOFprices = sumOfEachProductsPrice(subtotal); // sum each price subtotal
		System.out.println("Sum of each products price =" + sumOFprices);
		// get subTotal from cart summary 
		String cartSummaryFormattedSubtotal = getSubTotalOfCartSummary(cartSummarySubTotal);
		double cartSummaryTotalPrice = getActualPrice(cartSummaryFormattedSubtotal);  //convert to integer
		System.out.println("Actual Price ="+cartSummaryTotalPrice+ " And Expected Price = "+sumOFprices);
		// Match cart summary subTotal price and sumOfEachProductsPrice
		Assert.assertEquals(sumOFprices,cartSummaryTotalPrice); // check if(givenAmout==actualAmount);
		GrandTotal = cartSummaryTotalPrice;
		
		// Check If discount and verify Price after Discount
		if (checkDiscount()) {
			//TODO  Verify discount price		
			System.out.println("Total Discount=" +getActualPrice(discountAmount.getText()));
			GrandTotal = (cartSummaryTotalPrice - getActualPrice(discountAmount.getText()));
		}
		
		System.out.println("GrandTotal="+ GrandTotal);
		
	}
	
	public CheckoutRepository processToCheckout() {
		processToCheckOut.click();
		return new CheckoutRepository(driver);
	}

	public double sumOfEachProductsPrice(List<Double> subtotal ) {
		double sum = 0;
		for (Double price : subtotal)
		    sum += price;
		return sum;
	}
	
	public boolean checkDiscount() {
		return ((isElementPresent(DiscountContainr)) ? true : false);
	}
}






