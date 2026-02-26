package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features="FeatureFiles/UserRegister.feature",
		glue="stepdefinitions",
		dryRun=false,
		plugin= {"pretty","html:Test Reports/userregister.html"}
		)
public class UserRegisterTest extends AbstractTestNGCucumberTests {

}
