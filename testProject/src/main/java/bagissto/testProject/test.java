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
		WebDriverManager.chromedriver().setup();				
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
		for(int i=1;i <= totalCheckBoxes;i++) {
			// Get Current checkBox Div   ////div[@id='discount-checkbox']/div[4]
			WebElement checkBoxContainer = driver.findElement(By.xpath("//div[@id='discount-checkbox']/div["+i+"]"));
			boolean isChecked = checkBoxContainer.findElement(By.cssSelector("input[type='checkbox']")).isSelected();
			
			if(isChecked) {
				System.out.println(i+ "=> This CheckBox IS Checked");
				
				//String CheckBoxLabel = checkBoxContainer.findElement(with(By.tagName("label")).below(CurrentCheckBox)).getText();
				String CheckBoxLabel = checkBoxContainer.findElement(By.tagName("label")).getText();
				System.out.println(i+ "=> CheckBox Is Checked And It's  Label is =>"+CheckBoxLabel);
				
			}else {
				System.out.println(i+ "=> This CheckBox IS Not  Checked");
			}
			
		}
		
		///boolean isCheckboxChecked = allCheckboxes.stream().anyMatch(checkbox->checkbox.isSelected()); //.equalsIgnoreCase(productName)
		//System.out.println("Is any checkbox checked  ? " +isCheckboxChecked);

	}

}
