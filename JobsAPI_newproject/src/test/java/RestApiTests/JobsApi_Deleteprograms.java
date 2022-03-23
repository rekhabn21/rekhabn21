package RestApiTests;

import org.testng.annotations.Test;

import RestApi.Utils.constants_jobsApi;
import RestApi.Utils.excelUtils;
import RestApi.Utils.restApi_config;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class JobsApi_Deleteprograms {
  @Test(dataProvider="data_fromexcel")
	public void delete_programs(String JobId) {
       
		System.out.println("Get details from Excel test data");

		System.out.println("JobId to be deleted is  :" +JobId);
	  
	  Response Delete_response=
	  
		given()
		.param("Job Id",JobId)
		.when()
		.delete(restApi_config.Base_Url + restApi_config.Base_path )
		.then()
	
		.log().all()
		.extract().response();
	  
	  
	  Reporter.log(Delete_response.asString());
		JsonPath jpath = Delete_response.jsonPath();// to readable format

		System.out.println(Delete_response.body().asPrettyString());
	
		 ResponseBody newrecord = Delete_response.getBody();
	  
	  
	  int statuscode = Delete_response.getStatusCode();
		 System.out.println("Status code  is  " +statuscode);
		
		 if (statuscode==200) {
			 assertEquals(statuscode, 200 ,"Request received successfully");
			 System.out.println("Status code is 200 : data is valid");}
	  
		 if (statuscode==404) {
			 assertEquals(statuscode, 404 ,"Request received successfully");
			 System.out.println("Status code is 404 : Job not found"); }
		  
		  
	}
   

  @DataProvider(name="data_fromexcel")
	public Object[][] xlData() throws IOException {
	  	
		String path = constants_jobsApi.excelFileLocation;
		excelUtils testdata= new excelUtils(path);

		Object[][] testinputarray = null ;
		try {
			testinputarray = testdata.getExcelData(path,constants_jobsApi.JobsAPI_Deletedata);
			} 	
		catch (Exception e) {
			}
		return testinputarray;
  			}
}
	



	

	

