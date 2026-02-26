package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
	features="FeatureFiles/EmpRegister.feature",
	glue="stepdefinitions",
	dryRun=false,
	plugin= {"pretty","html:Test Reports/EmpregisterReports.html"}
		
		
		)
public class EmpRegisterTest extends AbstractTestNGCucumberTests {

}

