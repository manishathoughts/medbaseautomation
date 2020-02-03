package cucumber.options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepdefinitions", tags = "@practical", plugin = { "pretty",
		"html:target/cucumber-reports", "json:target/jsonReports/cucumber.json" }, monochrome = true)
public class TestRunner {

}
