package MyTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//public class testrunner extends AbstractTestNGCucumberTests {
@RunWith(Cucumber.class) 
@CucumberOptions(features ="./src/test/resources/features",glue= {"StepDefinitions","AppHooks"},
		  monochrome = true,
		  dryRun = true,
		  strict = true,
		  plugin={"pretty","html:target/HtmlReports"}

)
public class TestRunner {

}
