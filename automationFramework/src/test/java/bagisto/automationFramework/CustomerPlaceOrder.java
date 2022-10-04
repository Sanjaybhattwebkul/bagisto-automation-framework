package bagisto.automationFramework;
import java.io.IOException;
import org.testng.annotations.Test;
import bagisto.automationFramework.velocity.LandingPage;
import bagistoTestComponents.baseTest;

public class CustomerPlaceOrder extends baseTest{

	@Test
	public void placeOrder() throws IOException {
		// TODO Auto-generated method stub
		LandingPage LandingPage = launcVelocity();
		LandingPage.customerLogin("tom@example.com","tom123");
	}

}
