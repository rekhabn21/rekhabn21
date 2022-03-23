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

public class TC003_LmsPutMethod {

	@Test(dataProvider = "data_fromexcel")

	public void Lms_Putprogram(String description, String ProgramName, String ProgramId) {

		JSONObject data = new JSONObject();
		data.put("programDescription", description);
		data.put("programName", ProgramName);
		data.put("programId", ProgramId);

	
		System.out.println("Request JSON body input : " + data.toJSONString());

		Response put_response =

				given().auth()
				.basic(lmsApiUtils_config.usrName,lmsApiUtils_config.usrPwd )
					.contentType(ContentType.JSON)
					.body(data.toJSONString())
				.when()
					.put(lmsApiUtils_config.Base_URL +lmsApiUtils_config.Base_path )
				.then()
					.log().all().extract().response();
			
		Reporter.log(put_response.asString());
		JsonPath jpath = put_response.jsonPath();
		
		ResponseBody allrecords1 = put_response.getBody();

		System.out.println(put_response.body().asPrettyString());
		
		 Integer pg_Id  = allrecords1.jsonPath().get("programId");
		 System.out.println( " The first record id is " + pg_Id);
		
		 String pg_Name  = allrecords1.jsonPath().get("programName");
		 System.out.println(" The program Name in first record is " + pg_Name);

		 String pg_Desc  = allrecords1.jsonPath().get("programDescription");
		 System.out.println(" The program description in first record is "+ pg_Desc);
		
		 SoftAssert get_SA = new SoftAssert();
		 
			get_SA.assertEquals(pg_Id, ProgramId);
			 get_SA.assertEquals(pg_Name,ProgramName);
			 get_SA.assertEquals(pg_Desc,description);

				// validating status code

				int statuscode = put_response.getStatusCode();
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

	@DataProvider(name = "data_fromexcel")
	public Object[][] xlData() throws IOException {

		String path = Constants_LMSAPIpoject.excelFileLocation ;//
		XLutils testdata = new XLutils(path);

		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] testinputarray = null;
		try {
			testinputarray = testdata.getExcelData(path, Constants_LMSAPIpoject.TC003_LMSPutmethod);
		} catch (Exception e) {
		}
		return testinputarray;
	}
}
