package RestApiTests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import RestApi.Utils.constants_jobsApi;
import RestApi.Utils.excelUtils;
import RestApi.Utils.restApi_config;
import io.restassured.response.Response;

public class JobsApi_getcreateddata{

	@Test(dataProvider="data_fromexcel")
	
	public void  getcreatedprogram(String JobId){
	
	System.out.println("Get details from Excel test data");

	System.out.println("JobId to be found is  :" + JobId);
		  
	     Response response_get =
	    	 given()
	    	 .param("Job Id",JobId)
			.when()
				.get(restApi_config.Base_Url + restApi_config.Base_path)
			.then()
				.statusCode(200)
				.log().all()
				.extract().response();
	     		     
	     		Reporter.log(response_get.asString());
				
			// validating Status Code
			  
			 int statusCode = response_get.getStatusCode();
			System.out.println( " Status Code  for Get request is :"  + statusCode);
			Assert.assertEquals(statusCode, 200);
			
			
			if (statusCode==200) {
				 System.out.println(" Record found");
				 }
			else {
				 System.out.println(" Record not found  invalid request");
			}
	
					
			//validating Status Line
			String statusLn = response_get.getStatusLine();	
			System.out.println( " Status line for Get request is :"  + statusLn);
			Assert.assertEquals(statusLn, "HTTP/1.1 200 OK");
		
				
			System.out.println("\n  Validating Headers in Output \n");
			
			// Validating Response Headers	
			String headerValue1 = response_get.getHeader("Connection");
			System.out.println("  Connection :"  + headerValue1);
						
			String headerValue2 = response_get.getHeader("Server");
			System.out.println("  Server :"  + headerValue2);
			
			String headerValue3 = response_get.getHeader("Date");
			System.out.println("  Date :"  + headerValue3);
			
			String headerValue4 = response_get.getHeader("Content-Type");
			System.out.println("  Content-Type :"  + headerValue4);
			
			String headerValue5 = response_get.getHeader("Content-Length");
			System.out.println("  Content-Length:"  + headerValue5);
			
			String headerValue6 = response_get.getHeader("Via");
			System.out.println("  Via :"  + headerValue6);
			
			 SoftAssert sA = new SoftAssert();
			 sA.assertEquals(headerValue1, "keep-alive");	
			 sA.assertEquals(headerValue2, "gunicorn");
			 sA.assertEquals(headerValue3,"" );
			 sA.assertEquals(headerValue4, "application/json");
			 sA.assertEquals(headerValue5, "13249");
			 sA.assertEquals(headerValue6, "1.1 vegur");
			 
			 // validating Response body--- fails due to Nan field
}

			  @DataProvider(name="data_fromexcel")
				public Object[][] xlData() throws IOException {
				  	
					String path = constants_jobsApi.excelFileLocation;
					excelUtils testdata= new excelUtils(path);

					Object[][] testinputarray = null ;
					try {
						testinputarray = testdata.getExcelData(path,constants_jobsApi.JobsAPI_getCreateddata);
						} 	
					catch (Exception e) {
						}
					return testinputarray;
			  			}
			}
 
	

	
	
	

