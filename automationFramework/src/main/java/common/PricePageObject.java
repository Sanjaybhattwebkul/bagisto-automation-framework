package common;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import helpers.getProductsPrice;


public class PricePageObject extends getProductsPrice{

	public WebDriver driver;	
	
	public PricePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public ArrayList<String> getPriceFromBackend(String tableName,int productId,int customerGroupId) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ResultSet  data = getProductPriceFromDB(tableName,productId,customerGroupId);
		ArrayList<String> productsPrice = new ArrayList<String>();
		while(data.next()) {			
			productsPrice.add(data.getString("min_price"));
			productsPrice.add(data.getString("regular_max_price"));		   
		} 
		
		return productsPrice;
	}

}
