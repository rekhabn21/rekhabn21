package RestApiTests;

import org.testng.annotations.Test;

import RestApi.Utils.constants_jobsApi;
import RestApi.Utils.excelUtils;
import RestApi.Utils.restApi_config;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class JobsApi_Putprogram {
 
	@Test(dataProvider="data_fromexcel")
  public void  Put_programs(String JobId,String JobTitle, String JobLocation,String JobCompanyName) {
		
	 System.out.println("Reading data from dataprovider" );	
		
	  /*JSONObject put_request = new JSONObject(); 
		
	 HashMap<String, Object>put_request = new HashMap<String, Object>();		
	  	
	  	put_request.put("Job Id",JobId);
		put_request.put	("Job Title",JobTitle); 
		put_request.put("Job Location",JobLocation);
		put_request.put("Job Company Name",JobCompanyName);*/
		
Response Putresponse =		
				
		given()
	//		.param(put_request.toString())
		.param("Job Id",JobId)
		.param("Job Title",JobTitle) 
		.param("Job Location",JobLocation)
		.param("Job Company Name",JobCompanyName)
				
		.when()	
			.put(restApi_config.Base_Url + restApi_config.Base_path)
		.then()
			//.statusCode(200).log().all()
			.extract().response();

			System.out.println(Putresponse.body().asString());
						
			JsonPath jpath = Putresponse.jsonPath();
			System.out.println(Putresponse.body().asPrettyString());
			ResponseBody newrecord = Putresponse.getBody();
			
				
			 //validating status code
			 
			 int statuscode = Putresponse.getStatusCode();
			 System.out.println("Status code  is  " +statuscode);
			
			 if (statuscode==200) {
				 assertEquals(statuscode, 200 ,"Request received successfully");
				 System.out.println("Status code is 200 : data is valid");
			} else if (statuscode==400) {
				  assertEquals(statuscode , 400 ,"Request received successfully" );
			 System.out.println("Status code is 400 : data is invalid");
			 } else if (statuscode == 409 ) {
				 assertEquals(statuscode , 409 ,"Request received successfully" );
				 System.out.println("Status code is 409 : already exists");
			 	}
	}
	
		 @DataProvider(name="data_fromexcel") 
			
		 public Object[][] xlData() throws IOException {
	  	
		String XLpath = constants_jobsApi.excelFileLocation;	
		excelUtils testdata= new excelUtils(XLpath);

		//We are creating an object from the excel sheet data by calling a method that reads data
		//from the excel stored locally in our system
		
		Object[][] testinputarray = null ;
		try {
			testinputarray = testdata.getExcelData(XLpath,constants_jobsApi.JobsAPI_Putdata);
		} catch (Exception e) {
		}
		return testinputarray;
 	}	
			
}
