#Author:kavyakrishnamurthy@rhibus.com
#Keywords Summary :Login Rest-Api Functional TestCase For Both Positive and Negative 

@LoginAPI
Feature: Login  Rest Api's

@SmokeTestCase
 Scenario: To check that restapi login by giving valid credetials
     Given the Api base url :"https://91fjgvixl9.execute-api.ap-south-1.amazonaws.com/testing" 
     And the login Api  endpoint: "/v1/login"
     When i send a POST request with the following payload
     """
      {
          "data": {
              "user_email": "anish.reddy@rhibhus.com",
              "user_password": "Anish@123"
          }
      }
      """
     Then the response status code should be 200
     And the response payload should be "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." 
     And the response header content type should be "application/json; charset=utf-8"
     Then i validate the login  Rest Api's 


  
 

 
