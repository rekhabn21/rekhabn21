package testCases.LmsApiProject;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
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

public class TC002_LmsPostmethod {


@Test(dataProvider="data_fromexcel")
	public void Post_program(String online,String programDescription,String programName)
{ 
		
		System.out.println("Get details from Excel test data");
		
		JSONObject  Programdata = new JSONObject();
		
	//	HashMap<String, Object> ProgramData = new HashMap<String, Object>();
		
	//	Programdata.put( "programId","");
		 Programdata.put( "online"
				 ,online);
		 Programdata.put("programDescription",programDescription);
		 Programdata.put("programName",programName);
		 
		 //System.out.println("Request JSON body : " + Programdata.toJSONString());
		
		Response POSTresponse =		
				
			given().auth()
				.basic(lmsApiUtils_config.usrName,lmsApiUtils_config.usrPwd )
				.contentType(ContentType.JSON)
				.body(Programdata.toJSONString())
			.when()
				.post(lmsApiUtils_config.Base_URL +lmsApiUtils_config.Base_path)
			.then()
			//.log().all()
					.extract().response();
			
			//Reporter.log(POSTresponse.asString());
			JsonPath jpath = POSTresponse.jsonPath();// to readable format

			// validating Jsonpath and Json Body at the first record
			
	ResponseBody allrecords1 = POSTresponse.getBody();

	System.out.println(POSTresponse.body().asPrettyString());
	
	 Integer pg_Id  = allrecords1.jsonPath().get("programId");
	 System.out.println( " The first record id is " + pg_Id);
	
	 String pg_Name  = allrecords1.jsonPath().get("programName");
	 System.out.println(" The program Name in first record is " + pg_Name);

	 String pg_Desc  = allrecords1.jsonPath().get("programDescription");
	 System.out.println(" The program description in first record is "+ pg_Desc);

	 Boolean on_line  = allrecords1.jsonPath().get("online");
	 System.out.println(" The program status in first record is " + on_line);

	SoftAssert get_SA = new SoftAssert();
	 
	// get_SA.assertEquals(pg_Id, programId);
	 get_SA.assertEquals(pg_Name,programName);
	 get_SA.assertEquals(pg_Desc,programDescription);
	 get_SA.assertEquals(on_line.toString(),online);

		// validating status code

		int statuscode = POSTresponse.getStatusCode();
		System.out.println("Status code  is  " + statuscode);

		if (statuscode == 200) {
			assertEquals(statuscode, 200, "Request received successfully");
			System.out.println("Status code is 200 : data is valid");
		} else if (statuscode == 401) {
			assertEquals(statuscode, 401, "Request received successfully");
			System.out.println("Status code is 401 :data is unauthorized");
		} else if (statuscode == 403) {
			assertEquals(statuscode, 403, "Request received successfully");
			System.out.println("Status code is 403 : forbidden");
		}
				else if (statuscode == 404) {
			assertEquals(statuscode, 404, "Request received successfully");
			System.out.println("Status code is 403 : not found");

		}
			 
}	 

	
@DataProvider(name="data_fromexcel")
public Object[][] xlData() throws IOException {
  	
	String Xlfilepath =Constants_LMSAPIpoject.excelFileLocation ;//
	XLutils testdata= new XLutils(Xlfilepath);
	
	//We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
	Object[][] testinputarray = null ;
		try {
		testinputarray = testdata.getExcelData(Xlfilepath,Constants_LMSAPIpoject.TC002_LMSPostmethod);
		} 
		catch (Exception e) {
			}
		return testinputarray;
		}
			}
