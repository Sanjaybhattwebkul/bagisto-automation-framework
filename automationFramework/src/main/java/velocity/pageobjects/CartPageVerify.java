package velocity.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bagisto.automationFramework.AbstractComponent;

public class CartPageVerify extends AbstractComponent{
	
	WebDriver driver;
	public CartPageVerify(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //PageFactory TestNG ka part h is se annotation use kr skte h.
	}
	
	@FindBy(xpath="//div[@class='order-summary fs16']/div[1]/span[2]")
	WebElement minicartSubtotal; //total cart price in cart summary box
	
	@FindBy(xpath="//div[@class='cart-item-list']/div")
	List<WebElement> cartItemContainer;
	
	@FindBy(xpath="//span[@class='col-4 text-right']")
	WebElement cartSummarySubTotal;
	
	@FindBy(xpath="//div[@id='discount-detail']/span[1]")
	WebElement DiscountContainr;
	
	@FindBy(xpath="//div[@id='discount-detail']/span[2]")
	WebElement discountAmount;
		
	By formattedPrice =By.cssSelector("div[class='product-price'] :nth-child(1)"); // 1 product's price	
	
	By plusIcon = By.cssSelector(".increase");	
	
	By quantity = By.cssSelector("#quantity-changer"); // get model attribute's value
	
	By subTotalPrice = By.cssSelector("div[class='product-price fs18 col-1'] :nth-child(1)");
	
	//verify price with quantity
	public void calCulatePrice() {		
		List<WebElement> itemContainer = cartItemContainer; //Get Item Container
		int oneProductsPrice=0;
		int Qty=0;
		int totalPrice =0;
		int Subtotal = 0;
		String totalDiscountPrice = null;
		List<Integer> subtotal = new ArrayList<>();
		for(WebElement price:itemContainer) {
			oneProductsPrice = getActualPrice(price.findElement(formattedPrice).getText().substring(1));			
			System.out.println("One Products Price = " +oneProductsPrice);				
			Qty = Integer.parseInt(price.findElement(quantity).getAttribute("model"));
		    System.out.println("One Products Quantity = " +Qty);	
			totalPrice = (oneProductsPrice*Qty);
			System.out.println("One Products total Price= " +totalPrice);				
			Subtotal =getActualPrice(price.findElement(subTotalPrice ).getText().substring(1));
			System.out.println("SubTotal= " +Subtotal);				
			Assert.assertEquals(totalPrice,Subtotal); // check if(totalPrice==subTotal);
			subtotal.add(Subtotal); // Add subTotal of each product in arrayList
			totalPrice=0; Subtotal=0; oneProductsPrice=0; Qty=0;			
		}	
		
		double sumOFprices = sumOfEachProductsPrice(subtotal); // sum each price subtotal
		System.out.println("Sum of each products price =" + sumOFprices);
		// get subTotal from cart summary 
		String cartSummaryFormattedSubtotal = getSubTotalOfCartSummary(cartSummarySubTotal);
		int cartSummaryTotalPrice = getActualPrice(cartSummaryFormattedSubtotal);  //convert to integer
		System.out.println("Actual Price ="+cartSummaryTotalPrice+ " And Expected Price = "+sumOFprices);
		// Match cart summary subTotal price and sumOfEachProductsPrice
		Assert.assertEquals(sumOFprices,cartSummaryTotalPrice); // check if(givenAmout==actualAmount);
		
		// Check If discount and verify Price after Discount
		if(checkDiscount()) {
			//TODO  Verify discount price
			totalDiscountPrice = discountAmount.getText();
			
			System.out.println("Total Discount=" +getActualPrice(totalDiscountPrice));
		}else {
			System.out.println("No discunt");
		}
		
		int GrandTotal = (cartSummaryTotalPrice - getActualPrice(totalDiscountPrice));
		System.out.println("GrandTotal="+ GrandTotal);
		
	}
	
	
	public int getActualPrice(String price) {
		int intPrice=0;
		String itemPrice =	removeComma(price);// remove , from price	
		double amount = Double.parseDouble(itemPrice); //convert string to double
		intPrice = (int)amount;  // convert into int	
		return intPrice;
		
	}
	
	public double sumOfEachProductsPrice(List<Integer> subtotal ) {
		double sum = 0;
		for(Integer price : subtotal)
		    sum += price;
		return sum;
	}
	
	public boolean checkDiscount() {
		return DiscountContainr.isDisplayed();
	}
}






