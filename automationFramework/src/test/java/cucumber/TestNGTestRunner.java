package cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue="stepDefinition",
monochrome=true, tags = "@Regression", plugin= {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests  {
	
	//features -> Your features files path
	//glue -> your stepDefinition file path
	//Regression -> your .feature file's test name
	//plugin -> Path where you want to create cucumber report
	
}
