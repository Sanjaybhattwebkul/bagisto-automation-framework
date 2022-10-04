package bagisto.automationFramework;
import java.io.IOException;
import org.testng.annotations.Test;

import bagistoTestComponents.baseTest;
import velocity.pageobjects.LandingPage;

public class CustomerPlaceOrder extends baseTest{

	@Test
	public void placeOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		LandingPage LandingPageObject = launcVelocity();
		Thread.sleep(2000);
		LandingPageObject.customerLogin("tom@example.com","tom123");
	}

}
