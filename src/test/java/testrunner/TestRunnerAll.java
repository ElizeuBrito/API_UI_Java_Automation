package testrunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		
plugin = {"pretty", "json:src/test/java/Cucumber/cucumber-reports.json"},
features= "src/test/java/features",
glue= "steps",
dryRun = false)

public class TestRunnerAll {
	
}