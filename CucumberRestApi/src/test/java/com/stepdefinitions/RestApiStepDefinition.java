package com.stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.RestApiRunner.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiStepDefinition {
	
	
	private RequestSpecification request;
    private Response response;
    private String URL;
    
    private String payload ;
	
	@Given("I send a POST request with the following data from the {string} and {int}")
	public void i_send_a_post_request_with_the_following_data_from_the_and(String sheetname, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("C:\\Users\\desktop\\git\\cucumber-rest-api\\CucumberRestApi\\FactoApi\\Cucumberdata1.xlsx", sheetname);
		
		this. URL = testData.get(RowNumber).get("URL");
		this.payload = testData.get(RowNumber).get("payload");//pass
	 
	}
 
@When("pass the  Url")
public void pass_the_url() {

	response=RestAssured.given()

		.baseUri("https://91fjgvixl9.execute-api.ap-south-1.amazonaws.com/testing")
		.contentType(ContentType.JSON).body(payload)

		.when()

		.post(URL)

		.then()

		.extract()

		.response();
	}

	@When("pass the payload")
	public void pass_the_payload() {
		
		String Responsebody = response.getBody().asString();
	   
		System.out.println("response body =====>"+Responsebody);
		
	}


}














/*ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
				reader.getData("/Users/naveenautomationlabs/Desktop/automation.xlsx", sheetName);
		
		String heading = testData.get(rowNumber).get("subjectheading");
		String email = testData.get(rowNumber).get("email");
		String orderRef = testData.get(rowNumber).get("orderref");
		String message = testData.get(rowNumber).get("message");
		
		contactUsPage.fillContactUsForm(heading, email, orderRef, message);*/
