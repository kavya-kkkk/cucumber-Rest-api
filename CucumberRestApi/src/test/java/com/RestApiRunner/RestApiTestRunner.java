package com.RestApiRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features = "C:\\Users\\desktop\\git\\cucumber-rest-api\\CucumberRestApi\\Features\\LoginApi.feature",
      glue = "com.stepdefinitions",
      dryRun=false,
      monochrome = true,
      plugin= {"pretty","html:target/cucumber-Restapi-report"}


		)

public class RestApiTestRunner {
	
	
 
}

                         