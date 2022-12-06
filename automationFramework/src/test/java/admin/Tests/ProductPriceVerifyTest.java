package admin.Tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;
import admin.TestComponents.adminBaseTest;
import helpers.ProductPriceVerify;

public class ProductPriceVerifyTest extends adminBaseTest {

	@Test
	public void priceVerify() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ProductPriceVerify obj = new  ProductPriceVerify(driver);		
		ResultSet  data = obj.getProductPriceFromDB("product_price_indices",17,2);
		while(data.next()) {
			System.out.println(data.getString("min_price"));
			System.out.println(data.getString("regular_max_price"));
			//adminCredentials.add(rs.getString("email"));
			//adminCredentials.add(rs.getString("password"));		   
		} 
		
	}
}
