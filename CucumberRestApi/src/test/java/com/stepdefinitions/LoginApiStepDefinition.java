package com.stepdefinitions;

import org.testng.Assert;
import org.testng.Reporter;

import com.github.scribejava.core.model.Response;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class LoginApiStepDefinition {
	private String  baseUrl;
	
	private String endpoint;
	
	private RequestSpecification httpsrequest ;
	
	 private io.restassured.response.Response response;
	 
    /* private String payload="{\r\n"
		+ "    \"data\": {\r\n"
		+ "        \"user_email\": \"anish.reddy@rhibhus.com\",\r\n"
		+ "        \"user_password\": \"Anish@123\"\r\n"
		+ "    }\r\n"
		+ "}";
	*/
	 
	 
	@Given("the Api base url :{string}")
	public void the_api_base_url(String baseUrl) {
	    
		this.baseUrl =baseUrl;
       
		
	}

	@Given("the login Api  endpoint: {string}")
	public void the_login_api_endpoint(String endpoint) {
		 RestAssured.basePath = endpoint;
		 httpsrequest = RestAssured.given()
		          .contentType("application/json");
	}
	
	@When("i send a POST request with the following payload")
	public void i_send_a_post_request_with_the_following_payload(String payload) {
		response=httpsrequest.body(payload).post(baseUrl + endpoint);
	}

	/*@When("i send a POST request with the following payload")
	public void i_send_a_post_request_with_the_following_payload() {
		
		response=httpsrequest.body(payload).post(baseUrl + endpoint);
		            
	}*/

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer ExpectedStatusCode) {
		int ActualStatusCode = response.getStatusCode();
		Reporter.log("Actual status code is " + "=>" + ActualStatusCode + "=>" + "-AND-" + "expected status code"
				+ "=>" + ExpectedStatusCode);
		Assert.assertEquals(ActualStatusCode, ExpectedStatusCode, "Expected status code is  Incorrect");
	}

	
	@Then("the response payload should be {string}")
	public void the_response_payload_should_be(String ExpectedResponseBody) {
		
		String ActualResponseBody = response.getBody().asString();
		Reporter.log("Actual Response body" + " =>" + ActualResponseBody + "=>" + "Expected Response Body is" + "=>"
				+ ExpectedResponseBody);
		Assert.assertEquals(ActualResponseBody.contains(ExpectedResponseBody), true, "Incorrect Expeted body");
	}

	@Then("the response header content type should be {string}")
	public void the_response_header_content_type_should_be(String ExpectedHeaderContentType) {
		
		String ActualHeaderContentType = response.header("Content-Type");
		Reporter.log("Actual Response body" + " =>" + ActualHeaderContentType + "=>" + "Expected Response Body is"
				+ "=>" + ExpectedHeaderContentType);
		Assert.assertEquals(ActualHeaderContentType.contains(ExpectedHeaderContentType), true,
				"Incorrect  Expected Header ContentType");
	}

	@Then("i validate the login  Rest Api's")
	public void i_validate_the_login_rest_api_s1() {
	    System.out.println("actual response body "+response.getBody().asString());
		System.out.println(" status code is "+ response.getStatusCode());
		System.out.println("status line is "+ response.getStatusLine());
		System.out.println("status line is "+ response.getTime());
		
	}
}

	/*@Given("I send a POST request with the following data from the {string} and <RowNumber>")
	public void i_send_a_post_request_with_the_following_data_from_the_and_row_number(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("I  send a post  request by giving  baseurl,endpoint and payload")
	public void i_send_a_post_request_by_giving_baseurl_endpoint_and_payload() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I validate the  response body")
	public void i_validate_the_response_body() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I validate the status code")
	public void i_validate_the_status_code() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I validate the header content type")
	public void i_validate_the_header_content_type() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the login  Rest Api's")
	public void i_validate_the_login_rest_api_s() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	}*/

