package bagissto.testProject;

import java.time.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		
		// check a checkBox
		WebElement checkedCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
		checkedCheckbox.click();	
		Thread.sleep(3000);
		
		// get label of checked checkBox
		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int totalCheckBoxes = allCheckboxes.size();  // get total checkBoxes -> 6
		System.out.println(totalCheckBoxes);
		
		
		boolean isCheckboxChecked = allCheckboxes.stream().anyMatch(checkbox->checkbox.isSelected()); //.equalsIgnoreCase(productName)
		System.out.println("Is any checkbox checked  ? " +isCheckboxChecked);
		
		// TODO BY JAVA STRAM
		//List<Object> originalList = allCheckboxes.stream().map(c -> c.isSelected()).collect(Collectors.toList());
		//boolean isProductMatch = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		
		// TODO Relative locators
		//System.out.println(driver.findElement(with(By.tagName("label")).below(checkedCheckbox)).getText());//find label which is below of the selected checkbooks 
		
	}

}
