package Runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\798008\\eclipse-workspace\\Cucumber_Maven_Selenium_PageObjectFactory\\src\\test\\java\\Features\\exceltestcase.feature",
		glue={"stepDefinitions"},
		format= {"pretty","html:test-outout2"},
		monochrome=true,
		dryRun=false
		
		)

public class excelRunner {

}
