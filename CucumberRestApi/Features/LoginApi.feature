Feature: Test API with data from Excel file

  Scenario Outline: Test API with data from Excel file
   
    Given I send a POST request with the following data from the "<SheetName>" and <RowNumber>
     
    When pass the  Url
    
    And pass the payload 

    Examples:
      | SheetName | RowNumber | 
      | Sheet1    | 0  | 
      | Sheet1    | 1| 
