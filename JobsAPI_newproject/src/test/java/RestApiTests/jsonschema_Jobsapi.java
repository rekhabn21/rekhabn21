package RestApiTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import RestApi.Utils.restApi_config;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class jsonschema_Jobsapi {
	
		
		  @Test public void get_programs()  {
			  Response response_get =
	    	 given()
			.when()
				.get(restApi_config.Base_Url + restApi_config.Base_path)
			.then()

				.statusCode(200)
				.log().all()
				.extract().response();
			  
		String responseStr = response_get.getBody().asString();
		 assertThat("Json schema", responseStr.replaceAll("NaN","null"),
				matchesJsonSchemaInClasspath("JobsAPISchema.json"));
	     	
		 
		  }

		
		}


	

