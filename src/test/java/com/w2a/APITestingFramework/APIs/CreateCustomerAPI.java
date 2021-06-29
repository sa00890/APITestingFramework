package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setup.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {
	//branch cdef
	public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String,String> data) {
		////Hi Its me
		//Are you okay
		//checking rebase
		//finally
		
		//Automation Code
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
							.formParam("name",  data.get("name"))		
							.formParam("email", data.get("email"))
							.formParam("description", data.get("description"))
							.formParam("address[postal_code]",data.get("address[postal_code]"))
							.post(config.getProperty("customerAPIEndPoint"));
		//Can you handle this..stash
			//wasnt satisfied made the change again	
		////Yes I can handle it ofcourse
			return response;
		
	}

	public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String,String> data) {

		  Response response = given().auth().basic(config.getProperty("invalidSecretKey"), "")
				  			  .formParam("name", data.get("name"))
				  			  .formParam("email",data.get("email"))
				  			  .formParam("description",data.get("description"))
		                    //.formParam("address[postal_code]","001")
				  			  .post(config.getProperty("customerAPIEndPoint"));

			return response;
		
	}

}
