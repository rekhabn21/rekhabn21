package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//public class testrunner extends AbstractTestNGCucumberTests {
@RunWith(Cucumber.class) 
@CucumberOptions(features ="./src/test/resources/features",glue= {"StepDefinitions","AppHooks"},
		  monochrome = true,
		  dryRun = false,
		
		  plugin={"pretty","html:target/HtmlReports"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
