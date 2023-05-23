package runner.com;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\desktop\\git\\cucumber-rest-api\\CucumberRestApi\\src\\main\\java\\features\\exceldata.feature",
glue = "step.com",
dryRun=false,
monochrome = true,
plugin= {"pretty","html:target/cucumber-excel-report"}
		
		)


public class runnerexcel {

}
