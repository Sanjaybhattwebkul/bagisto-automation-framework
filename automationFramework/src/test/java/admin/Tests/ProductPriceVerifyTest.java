package admin.Tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.Test;
import admin.TestComponents.adminBaseTest;
import helpers.ProductPriceVerify;

public class ProductPriceVerifyTest extends adminBaseTest {

	@Test
	public ArrayList<String> priceVerify() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ProductPriceVerify obj = new  ProductPriceVerify(driver);		
		ResultSet  data = obj.getProductPriceFromDB("product_price_indices",17,2);
		ArrayList<String> productsPrice = new ArrayList<String>();
		while(data.next()) {
			System.out.println("Minimum price is =" +data.getString("min_price"));
			System.out.println("Maximum price is =" +data.getString("regular_max_price"));
			productsPrice.add(data.getString("email"));
			productsPrice.add(data.getString("password"));		   
		} 
		
		return productsPrice;
		
	}
}
