package testCases.LmsApiProject;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.gherkin.model.Given;
import Testutils.LmsApi.lmsApiUtils_config;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

public class TC001_LmsgetMethod {
   	
@Test
		public  void Get_allprograms() {
 
	
	Response get_response =
	
		given().auth()
			.basic(lmsApiUtils_config.usrName,lmsApiUtils_config.usrPwd )
		.when()
			.get(lmsApiUtils_config.Base_URL +lmsApiUtils_config.Base_path)
		.then()		
		
			//.log().all()
			.extract().response();
		
		//Reporter.log(get_response.asPrettyString());		
				
		JsonPath jpath = get_response.jsonPath();// to readable format
		//System.out.println(get_response.body().asString());
		
		
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
		

//Json path validation of headers in the output
		System.out.println("\n Headers in the response   ");
//connection: keep-alive 
		String header1 = get_response.getHeader("Connection");
		System.out.println("  Connection :"  + header1);
  
// header 2cache-control:no-cacheno-storemax-age=0must-revalidate  
		String header2 = get_response.getHeader("cache-control");
		System.out.println("  cache-control : "  + header2);
   
// header3content-type: application/json 
		String header3 = get_response.getHeader("content-type");
		System.out.println("  content-type : "  + header3);
   
 //header 4date
		String header4 = get_response.getHeader("date");
		System.out.println("  date : "  + header4);
 
// header5 expires: 0  
		String header5 = get_response.getHeader("expires");
		System.out.println("  expires : "  + header5); 
 
 //header6 pragma : no-cache 
		String header6 = get_response.getHeader("pragma");
		System.out.println("  pragma : "  + header6);
 
   //header7 server: Cowboy 
		String header7 = get_response.getHeader("server");
		System.out.println("  server : "  + header7);

  
// header8 strict-transport-security: max-age=31536000 ; includeSubDomains 
		String header8 = get_response.getHeader("strict-transport-security");
		System.out.println("  strict-transport-security: "  + header8);
 
 //header9 : chunked 
		String header9 = get_response.getHeader("transfer-encoding:");
		System.out.println("  transfer-encoding: : "  + header9);
  
 //header10 :vary
		String header10 = get_response.getHeader(" vary");
		System.out.println("  vary : "  + header10); 

// header11via:1.1 vegur 
		String header11 = get_response.getHeader("via");
		System.out.println("  via : "  + header11);

//header12x-content-type-options:nosniff 
		String header12 = get_response.getHeader("x-content-type-options");
		System.out.println("  x-content-type-options : "  + header12);

//header13x-frame-options:DENY 
		String header13 = get_response.getHeader("x-frame-options");
		System.out.println("  x-frame-options : "  + header13);
 

//header14 x-xss-protection:1; mode=block
		String header14 = get_response.getHeader("x-xss-protection");
		System.out.println("  x-xss-protection : "  + header14);


		SoftAssert headers_sa = new SoftAssert();

		headers_sa.assertEquals("header1" ,"keep-alive");
		headers_sa.assertEquals("header2", "no-cache, no-store, max-age=0, must-revalidate");
		headers_sa.assertEquals("header3", "application/json");
		headers_sa.assertEquals("header4", " ");
		headers_sa.assertEquals("header5",  "0");
		headers_sa.assertEquals("header6", "no-cache");
		headers_sa.assertEquals("header7", "Cowboy");
		headers_sa.assertEquals("header8", "max-age=31536000 ; includeSubDomains");
		headers_sa.assertEquals("header9",  "chunked"); 
		headers_sa.assertEquals("header10","OriginAccess-Control-Request-MethodAccess-Control-Request-Headers");
		headers_sa.assertEquals("header11", "1.1 vegur");
		headers_sa.assertEquals("header12", "nosniff");
		headers_sa.assertEquals("header13", " DENY");
		headers_sa.assertEquals("header14", "1; mode=block");

		System.out.println(" Headers Validation Completed Successfully");
		}

		}



