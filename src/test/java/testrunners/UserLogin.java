package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions (
		
		features="FeatureFiles/UserLogin.feature",
		glue="stepdefinitions",
			dryRun= false,
				plugin={"pretty","html:Test Reports/userlogin.html"}
		
		
		)

public class UserLogin extends AbstractTestNGCucumberTests{}
