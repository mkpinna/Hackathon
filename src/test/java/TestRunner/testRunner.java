package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//FeatureFiles/"},
					glue={"stepDefinition"},//This Feature added so that the step definition file run according to the feature files
					plugin= {"pretty","html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true   // to publish report in cucumber server
					//tags="@Smoke", // Whenever you want test the critical functionalities we use smoke test
					//tags="@regression",// Whenever you want to test the new build we will use the regression test
		)
public class testRunner {

}
