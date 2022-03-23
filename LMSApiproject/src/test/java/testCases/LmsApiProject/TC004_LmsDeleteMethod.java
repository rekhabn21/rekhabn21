package testCases.LmsApiProject;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Testutils.LmsApi.Constants_LMSAPIpoject;
import Testutils.LmsApi.XLutils;
import Testutils.LmsApi.lmsApiUtils_config;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC004_LmsDeleteMethod {
	
	 @Test (dataProvider = "data_fromexcel")
		
	 public void Lms_Deleteprograms(String ProgramId)
 	{
		 JSONObject data = new JSONObject();
		 data.put("programId",ProgramId);
		 System.out.println("Request JSON body input : " + data.toJSONString());

			Response delete_response =
		 
			  given().auth()
				.basic(lmsApiUtils_config.usrName,lmsApiUtils_config.usrPwd )
				.contentType(ContentType.JSON)
	  	
		  .when()
		  	.delete(lmsApiUtils_config.Base_URL +lmsApiUtils_config.Base_path +"/"+ ProgramId)
		  
		  	.then()
		  		.extract().response();
			Reporter.log(delete_response.asString());
			JsonPath jpath = delete_response.jsonPath();
			
			ResponseBody allrecords = delete_response.getBody();

			System.out.println(delete_response.body().asPrettyString());

			 Integer pg_Id  = allrecords.jsonPath().get("programId");
			 System.out.println( " The first record id is " + pg_Id);
			 
			 SoftAssert get_SA = new SoftAssert();
			 get_SA.assertEquals(pg_Id, ProgramId);
			 
			// validating status code

				int statuscode = delete_response.getStatusCode();
				System.out.println("Status code  is  " + statuscode);

				if (statuscode == 200) {
					assertEquals(statuscode, 200, "Request received successfully");
					System.out.println("Status code is 200 : data is valid");}
				else if (statuscode == 500) {
						assertEquals(statuscode, 500, "Request received successfully");
						System.out.println("Status code is 500 : not found");}
			 
 		}

	
	 @DataProvider(name = "data_fromexcel")
	
	public Object[][] xlData() throws IOException {

	String path = Constants_LMSAPIpoject.excelFileLocation;//
	XLutils testdata = new XLutils(path);

	
	Object[][] testinputarray = null;
	try {
		testinputarray = testdata.getExcelData(path, Constants_LMSAPIpoject.TC004_LMSDeletemethod);
	} catch (Exception e) {
	}
	return testinputarray;
}
}