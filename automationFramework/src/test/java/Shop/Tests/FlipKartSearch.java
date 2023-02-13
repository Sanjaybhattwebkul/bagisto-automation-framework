package Shop.Tests;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URL;

public class FlipKartSearch {
	
	@Test
	public void flipKartTest() throws ClientProtocolException, IOException 
	{		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.15.86/bagisto/public/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement img = driver.findElement(By.xpath("//div[contains(@class,'advertisement-container-block')][2]/a[1]/img"));
		isBrokenImage(img);
		
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		String input="core i5";
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("input[title*=\"Search\"]")).sendKeys(input, Keys.ENTER);
		List<WebElement> allProducts = driver.findElements(By.cssSelector("div[class=\"_13oc-S\"]"));
		List<WebElement> productsName = driver.findElements(By.cssSelector("div[class=\"_4rR01T\"]"));
		List<WebElement> productPrice = driver.findElements(By.cssSelector("div[class=\"_30jeq3 _1_WHN1\"]"));		
		for (int i = 0; i < allProducts.size(); i++) {				
			String productName = productsName.get(i).getText().toLowerCase();
			if(productName.contains(input)) {
				int price = Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", ""));
				list.add(price);				
			}
		}
		
		if(list.isEmpty()) {
			System.out.println("No record Found for serarchKeyword");
		}else {
			int minimumPrice = Collections.min(list);			
			for (int i = 0; i < allProducts.size(); i++) {
				String name = productsName.get(i).getText().toLowerCase();
				if(name.contains(input)) {
					if(minimumPrice == Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", ""))){					
						System.out.println(productsName.get(i).getText());
						System.out.println(Integer.parseInt(productPrice.get(i).getText().replaceAll("[^a-zA-Z0-9.]", "")));
						break;
					}
				}				
			}
		}*/		
	}
	
	public  static void isBrokenImage(WebElement img) throws ClientProtocolException, IOException
	{
		 HttpClient client = HttpClientBuilder.create().build();
         HttpGet request = new HttpGet(img.getAttribute("src"));
         HttpResponse response = client.execute(request);
         /* For valid images, the HttpStatus will be 200 */
         if (response.getStatusLine().getStatusCode() != 200) {
             System.out.println("True");
        	 System.out.println(img.getAttribute("outerHTML") + " is broken.");
             
         } else {
        	 System.out.println("False"+ response.getStatusLine().getStatusCode());
         }
	}
}
