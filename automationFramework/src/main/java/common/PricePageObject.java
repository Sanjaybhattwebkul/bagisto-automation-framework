package common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import helpers.getProductsPrice;

public class PricePageObject extends getProductsPrice{

	WebDriver driver;
	public PricePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<String> getPriceFromBackend() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		gotoProductsPage();
		int productId = getCreatedProductId();
		ResultSet  data = getProductPriceFromDB("product_price_indices",productId,1);
		ArrayList<String> productsPrice = new ArrayList<String>();
		while(data.next()) {			
			productsPrice.add(data.getString("min_price"));
			productsPrice.add(data.getString("regular_max_price"));		   
		} 
		
		return productsPrice;
	}

}
