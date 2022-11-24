package admin.Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import admin.TestComponents.*;
import admin.pageobjects.LoginPageObject;


public class AdminLoginTest extends adminBaseTest {
	@Test(dataProvider = "getTestData")
	public void login(String email,String password) throws IOException {
		LoginPageObject LoginPageObject = launcAdminPanel();
		LoginPageObject.adminLogin(email,password);
		
	}
	
	@DataProvider
	public Object[][] getTestData(){	
		
		return new Object[][] {{"admin@example.com","admin123"}};
	}
}
