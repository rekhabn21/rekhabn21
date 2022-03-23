package RestApiTests;
import org.testng.asserts.SoftAssert;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import org.junit.Assert.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import RestApi.Utils.constants_jobsApi;
import RestApi.Utils.excelUtils;
import RestApi.Utils.excelUtils.*;
import RestApi.Utils.restApi_config;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.HashMap;

public class JobsAPi_Postprograms {
	
@Test(dataProvider="data_fromexcel")
	public void Post_program(String JobId,String JobTitle, String JobLocation,String JobCompanyName, String JobType,String JobPostedtime, String JobDescription){ 
		
		System.out.println("Get details from Excel test data");
		JSONObject  request = new JSONObject();
		request.put("Job Location",JobLocation);
		request.put("Job Id",JobId);
		request.put("Job Company Name",JobCompanyName);
		request.put("Job Posted time",JobPostedtime);
		request.put("Job Description",JobDescription);
		request.put	("Job Title",JobTitle); 
		request.put("Job Type",JobType);
		
			
		System.out.println("Request JSON : " + request.toJSONString());
		
		Response POSTresponse =		
				
			given()
			.param(request.toJSONString())
			/*.param("Job Title",JobTitle)
			.param("Job Location",JobLocation)
			.param("Job Id",JobId)
			.param("Job Company Name",JobCompanyName)
			.param("Job Type",JobType)
			.param("Job Posted time",JobPostedtime)
			.param("Job Description",JobDescription)*/
			.when()
				.post(restApi_config.Base_Url + restApi_config.Base_path)
			.then()
				.log().all()
					.extract().response();
			
			Reporter.log(POSTresponse.asString());
			JsonPath jpath = POSTresponse.jsonPath();// to readable format

			System.out.println(POSTresponse.body().asPrettyString());
		
			 ResponseBody newrecord = POSTresponse.getBody();
		/*	 
			 Integer pgId  = newrecord.jsonPath().get("progamId");
			 System.out.println(Job_id);
			 
			 Boolean pgOnline = newrecord.jsonPath().get("onLine");
			 System.out.println(Job_Title);
			 
			 String location =newrecord.jsonPath().get("Job Location");
			 System.out.println(location);
			 
			
			 String desc =newrecord.jsonPath().get("Job Description");
			 System.out.println(desc);

			 Reporter.log(" Json Path Validation completed successfully");
			 
			SoftAssert postSA = new SoftAssert();	
			postSA.assertEquals( Job_id,JobId);
			postSA.assertEquals(Job_Title,JobTitle);
			postSA.assertEquals(location,JobLocation);
			postSA.assertEquals(Company,JobCompanyName);
			postSA.assertEquals(job,JobType);
			postSA.assertEquals(postTime,JobPostedtime);
			postSA.assertEquals(desc,JobDescription);
			
			 Reporter.log(" Json body Validation completed successfully");
 */
			 //validating status code
			 
			 int statuscode = POSTresponse.getStatusCode();
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
	  	
		String path = constants_jobsApi.excelFileLocation;	
		excelUtils testdata= new excelUtils(path);

		//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
    	Object[][] testinputarray = null ;
		try {
			testinputarray = testdata.getExcelData(path,constants_jobsApi.JobsAPI_Postdata);
		
		} 	
		catch (Exception e) {
				}
		return testinputarray;
		
	}
    


	
}
	

	
					
	
	
	

