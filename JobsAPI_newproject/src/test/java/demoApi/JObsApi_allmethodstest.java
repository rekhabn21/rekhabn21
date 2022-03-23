package demoApi;

import org.testng.Reporter;
import org.testng.annotations.Test;
import RestApi.Utils.restApi_config;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Assert.*;

public class JObsApi_allmethodstest {

	@Test(priority = 1 ,enabled = false)
	public void get_programs() {

		given()
		.when()
		.get("https://jobs123.herokuapp.com/Jobs" )
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all();
	}

/////////----------------------------------------------------------------------------------////////////////		

	//@Test(priority = 2 , enabled = true)
	public void Post_programs() {
		
	//	JSONObject Empdata = new JSONObject(); 
		
		HashMap Empdata = new HashMap();
		Empdata.put("Job Id","11081");
		Empdata.put	("Job Title","SDET"); 
		Empdata.put("Job Location","Parma,Cleveland");
		Empdata.put("Job Company Name","REX Software");
		Empdata.put("Job Type","Permanent");
		Empdata.put("Job Posted time","25 Minutes");
		Empdata.put("Job Description","Testing APIs");
				
					
		Response POSTresponse =		
								
			given()
			.params(Empdata)
			.when()
				.post("https://jobs123.herokuapp.com/Jobs")
			.then()
				.statusCode(200).log().all()
				.extract().response();
		
			System.out.println(POSTresponse.getBody().asString());// print out the response body as string in utput console

			JsonPath jpath = POSTresponse.jsonPath();// to readable format
		
				
	}	
	
//////-------------------------------------------------------------------------------------------------////////		
	
	 @Test(priority = 3, enabled = false)		
	public void Put_programs() {
			
				//JSONObject Empdata = new JSONObject(); 
				
				HashMap Empdata = new HashMap();
				Empdata.put("Job Id","11081");
				Empdata.put	("Job Title","Senior SDET"); 
				Empdata.put("Job Location","Fairview");
				Empdata.put("Job Company Name","Amazon");
				
		Response Putresponse =		
						
				given()
					.params(Empdata)
					
				.when()	
					.put("https://jobs123.herokuapp.com/Jobs")
				.then()
					.statusCode(200).log().all()
					.extract().response();
		
					System.out.println(Putresponse.body().asString());
									
					JsonPath jpath = Putresponse.jsonPath();
					
		}
	
	 @Test(priority = 4, enabled = false)		
		public void Post2_programs() {
	 
		 HashMap Empdata = new HashMap();
			Empdata.put("Job Id","11081");
			Empdata.put	("Job Title","SDET"); 
			Empdata.put("Job Location","Parma,Cleveland");
			Empdata.put("Job Company Name","REX Software");
			Empdata.put("Job Type","Permanent");
			Empdata.put("Job Posted time","25 Minutes");
			Empdata.put("Job Description","Testing APIs");
					
						
			Response POST2response =		
			given()
				.params(Empdata)
				.when()
					.post("https://jobs123.herokuapp.com/Jobs")
				.then()
					.statusCode(409).log().all()
					.extract().response();
			Reporter.log(POST2response.asString());
			System.out.println(POST2response.body().asPrettyString());
	 
	 } 
	 
	 
///////-----------------------------------------------------------------------------------------//////	 

	 @Test(priority = 5 ,enabled = true)
		public void delete_programs() {

			given()
			.when()
			.delete("https://jobs123.herokuapp.com/Jobs/11081" )
			.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
		}

	}