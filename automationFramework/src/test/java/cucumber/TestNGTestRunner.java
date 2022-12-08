package cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features="src/test/java/cucumber",
					glue="stepDefinition",
					monochrome=true, 
					tags = "@CustomerCheckout",
					plugin= {"html:target/cucumber.html"}
				)


public class TestNGTestRunner extends AbstractTestNGCucumberTests  {
	
	//features -> Your features files path
	//glue -> your stepDefinition file path
	//tags -> your .feature file's test name
	//Plugin -> Path where you want to create cucumber report
	//monochrome -> True, it means display the console output in a proper readable format 
	//monochrome -> false, it means console output is not as readable as it should be.
	
}
