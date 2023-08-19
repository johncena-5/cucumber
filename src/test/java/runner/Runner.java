package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "./src/test/resources/Features", glue = "stepDefination",dryRun = false,tags = "@smoke",
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)

public class Runner extends AbstractTestNGCucumberTests{
	
	
	
	
}
