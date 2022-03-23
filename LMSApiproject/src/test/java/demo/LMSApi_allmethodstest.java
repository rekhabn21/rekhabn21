package demo;

import static io.restassured.RestAssured.*;
import org.testng.Reporter;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.assertThat;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class LMSApi_allmethodstest {

	
	@Test (priority=1, enabled =false)
	
	
	public  void Get_allprograms() {//(String ProgramID,String ProgramName, String ProgramDsSc) 

	given().auth().basic("admin", "password")
	.when()
	.get("https://lms-program-rest-service.herokuapp.com/programs")
	.then()
	.statusCode(200)
	.log().all();

					}
	
@Test (priority=2 ,enabled = true)
	
	
	public  void Post_allprograms() {
	

	
		JSONObject Programdata =new JSONObject();
		Programdata.put( "programId", "021822");
		 Programdata.put( "online","true");
		 Programdata.put("programDescription","Full-time");
		 Programdata.put("programName" ,"Java");

		 
		 Response  Post_response =
		 
		given()
		 	.auth().basic("admin", "password")
		 	.contentType(ContentType.JSON)
			.body(Programdata.toJSONString())
			
		.when()
			.post("https://lms-program-rest-service.herokuapp.com" + "/programs")
			
		.then()
			.statusCode(200)
			.extract().response();
		
		 // to print out  response body  in string format
		 System.out.println(Post_response.body().asString());
		 JsonPath jpath = Post_response.jsonPath();
	
		/*  output on console :{"programId":6208,"programName":"Java","programDescription":"Full-time","online":true}
		PASSED: Post_allprograms program id 6208 	 */
}
	

@Test (priority=3 , enabled=false)
 public void lmsGetcreatedProgram() {
	
	  int Id = 6208;
	 		
	given().auth().basic("admin", "password")
	
	.when()
	.get("https://lms-program-rest-service.herokuapp.com" + "/programs/" + Id)
	.then()
	.statusCode(200)
	.header("server", "Cowboy") 
			 
	.log().all();
	 System.out.println( " test pass " + " statusCode(200)");
}
	
		 @Test (priority=4, enabled = false)
	
		 public void Lms_Putprograms(){
		
		// we try to update an existing record with new values
		   
			int Id = 6208;
			
			JSONObject Programdata =new JSONObject();
			Programdata.put("programDescription","new program");
			Programdata.put("programName" ,"Python");
			 
		 Response newresponse= 
					 
			given().auth().basic("admin", "password")
			.contentType(ContentType.JSON)
			.body(Programdata.toJSONString())
			.when()
			.put("https://lms-program-rest-service.herokuapp.com" + "/programs/" + Id)
			.then()
			.statusCode(200)
			.header("server", "Cowboy")
			.extract().response();
			
			 //.assertThat().body("programNAme.programName", "programDescription", "new program",
			  
			 System.out.println( newresponse.body().asString());
			 JsonPath newjpath = newresponse.jsonPath();
		 
	 	}
	
	 @Test (priority=5 , enabled= true)  
 		
	 public void Lms_Deleteprograms()
 	{
	 
		 int Id = 6210;
		  given()
		  	.auth().basic("admin", "password")
		  	.contentType(ContentType.JSON)
	  	
		  .when()
		  	.delete("https://lms-program-rest-service.herokuapp.com" + "/programs/" + Id)
		  
		  	.then()
		  		.statusCode(200)
		  		.log().all();
	 
 		}

	
}







