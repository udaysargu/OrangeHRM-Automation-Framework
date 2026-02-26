package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions
(
		features = "FeatureFiles/AdminLogin.feature",
		glue = "stepdefinitions",
		dryRun = false,
		plugin = {"pretty","html:Test Reports/LoginReport.html"}
	
)
public class AdminLoginTest extends AbstractTestNGCucumberTests 
{
	
	
}