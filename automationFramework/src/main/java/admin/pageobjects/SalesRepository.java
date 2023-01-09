package admin.pageobjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
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
	List<WebElement> shipButton;
	
	@FindBy(css="a[class*='btn btn-lg btn-primary']:nth-child(2)")
	List<WebElement> invoiceButton;
	
	@FindBy(css="button[class*='btn btn-lg btn-primary']")
	WebElement saveInvoice;

	
	@FindBy(css="select[name*='shipmen']")	
	WebElement selectSource;
	
	@FindBy(css="div[class='page-action'] :first-child")
	WebElement saveShipMentButton;
	
	@FindBy(xpath="//tbody/tr")
	List<WebElement> orderTable;
	
	@FindBy(tagName="tbody")
	WebElement tableBody;
	
	@FindBy(className = "next")
	WebElement nextPage;
	
	By status = By.xpath("//td[@data-value='Status']/span");
	
	
	
	public boolean completeOrderProcess() {
		salesIcon.click();		
		if(isPendingOrder()) {			
			if(createShipping()){
				System.out.println("Shipping Created SucessFully");
			}
			if(createInvoice()) {
				System.out.println("Invoice Created SucessFully");
			}
			return isCreated();
		} else {
			System.out.println("No Pending Order");
			return true;
		}
	}
	
	public Map<String, Integer> checkOrderStatus() {
		
		Map<String, Integer> orderStatus = new HashMap<String, Integer>();
		int i;
		for(i=1; i<11; i++) {
			handlePagination(i);					
			String status = tableBody.findElement(By.xpath("//tr["+i+"]/td[6]/span")).getText();
			if (status.equalsIgnoreCase("Pending")) {						
				orderStatus.put("status", 1);
				orderStatus.put("column", i);	
				break;
			}else{					
				continue;
			}
		}
		return orderStatus;
	}
	
	public boolean isPendingOrder() {
		if (checkOrderStatus().get("status")==1) {
			int column = checkOrderStatus().get("column");
			driver.findElement(By.xpath("//tbody/tr["+column+"]/td[9]/div/a")).click();
			return true;
		}else {
			return false;
		}
		
	}

	public boolean createShipping() {
		if(isPresent(shipButton)) {
			shipButton.get(0).click();
			scrollDown(driver,950);
			selectOptions(selectSource,"Default");
			saveShipMentButton.click();
			return true;
		}else {
			boolean isCreated = createInvoice();
			if(isCreated) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean createInvoice() {
		if (invoiceButton.size()>0) {
			invoiceButton.get(0).click();
			saveInvoice.click();
			return true;
		}else {
			return false;
		}
		
	}
}
