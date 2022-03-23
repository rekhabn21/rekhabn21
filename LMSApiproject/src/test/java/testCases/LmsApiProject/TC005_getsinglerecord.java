package testCases.LmsApiProject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import Testutils.LmsApi.Constants_LMSAPIpoject;
import Testutils.LmsApi.XLutils;
import Testutils.LmsApi.lmsApiUtils_config;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC005_getsinglerecord {

	
	public  void Get_singlerecord( String programId) {
		 
		
		Response get_response =
		
			given().auth()
				.basic(lmsApiUtils_config.usrName,lmsApiUtils_config.usrPwd )
			.when()
				.get(lmsApiUtils_config.Base_URL +lmsApiUtils_config.Base_path + "/" + programId)
			.then()		
			
				.statusCode(200)
				.log().all()
				.extract().response();
			
			Reporter.log(get_response.asPrettyString());		
					
			JsonPath jpath = get_response.jsonPath();// to readable format
			System.out.println(get_response.body().asString());
			
			
		// validating Jsonpath and Json Body at the first record
			ResponseBody allrecords = get_response.getBody();
					
			 Integer pg_Id  = allrecords.jsonPath().get("programId[0]");
			 System.out.println( " The first record id is " + pg_Id);
			
			 String pg_Name  = allrecords.jsonPath().get("programName[0]");
			 System.out.println(" The program Name in first record is " + pg_Name);

			 String pg_Desc  = allrecords.jsonPath().get("programDescription[0]");
			 System.out.println(" The program description in first record is "+ pg_Desc);

			 Boolean on_line  = allrecords.jsonPath().get("online[0]");
			 System.out.println(" The program status in first record is " + on_line);

			SoftAssert get_SA = new SoftAssert();
			 
			 get_SA.assertEquals(pg_Id,"programId[0]");
			 get_SA.assertEquals(pg_Name,"programName[0]");
			 get_SA.assertEquals(pg_Desc,"programDescription[0]");
			 get_SA.assertEquals(on_line,"onLine[0]");
			 
			
		// validating Status Code
	  
			 int statusCode = get_response.getStatusCode();
			System.out.println( " Status Code  for Get request is :"  + statusCode);
			assertEquals(statusCode, 200);
		
			//statuscode 401,403,404 , unauthorized,forbidden,not found
					
			//validating Status Line
			
			String statusLn =get_response.getStatusLine();	
			System.out.println( " Status line for Get request is :"  + statusLn);
			assertEquals(statusLn, "HTTP/1.1 200 ");
	}

			 @DataProvider(name = "data_fromexcel")
			
			public Object[][] xlData() throws IOException {

			String path = Constants_LMSAPIpoject.excelFileLocation;//
			XLutils testdata = new XLutils(path);

			
			Object[][] testinputarray = null;
			try {
				testinputarray = testdata.getExcelData(path, Constants_LMSAPIpoject.TC005_LMSgetrsinglerecord);
			} catch (Exception e) {
			}
			return testinputarray;
		}
}
