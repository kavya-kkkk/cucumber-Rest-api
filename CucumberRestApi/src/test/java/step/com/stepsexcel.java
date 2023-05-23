package step.com;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.RestApiRunner.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepsexcel {
	
	private String name;
	

@Given("excel data {string} and {int}")
public void excel_data_and(String sheetname,Integer RowNumber) throws InvalidFormatException, IOException {
    
	ExcelReader reader = new ExcelReader();
	List<Map<String,String>> testData = 
			reader.getData("C:\\Users\\desktop\\git\\cucumber-rest-api\\CucumberRestApi\\src\\main\\java\\excelread\\project.xlsx", sheetname);
	
	this.name = testData.get(RowNumber).get("name");
 

}

@When("fetch excel data")
public void fetch_excel_data() {
	
	System.out.println("name is "+ name );
    
	
	
}


}
