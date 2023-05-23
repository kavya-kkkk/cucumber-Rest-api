
Feature:  data from Excel file

  Scenario Outline: Test API with data from Excel file
   
    Given excel data "<SheetName>" and <RowNumber>
     
    When fetch excel data 
    
   

    Examples:
      | SheetName | RowNumber | 
      | Facto    | 0| 
      | Facto    | 1| 
      | Facto    | 2| 
      | Facto    | 3| 


 

 