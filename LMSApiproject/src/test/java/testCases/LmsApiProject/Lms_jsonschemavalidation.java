package testCases.LmsApiProject;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testutils.LmsApi.lmsApiUtils_config;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class Lms_jsonschemavalidation {

	@Test
	
	public  void Get_allprograms() {
Response get_response =

	given().auth()
		.basic(lmsApiUtils_config.usrName,lmsApiUtils_config.usrPwd )
	.when()
		.get(lmsApiUtils_config.Base_URL +lmsApiUtils_config.Base_path)
	.then()
			.assertThat()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("lmsjsonschema.json"))
			

	
	
		.log().all()
		.extract().response();

  }
		
	}

