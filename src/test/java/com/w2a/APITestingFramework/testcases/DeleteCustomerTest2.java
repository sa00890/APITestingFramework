package com.w2a.APITestingFramework.testcases;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreateCustomerAPI;
import com.w2a.APITestingFramework.APIs.DeleteCustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setup.BaseTest;
import com.w2a.APITestingFramework.utilities.DataUtil;
import com.w2a.APITestingFramework.utilities.TestUtil;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteCustomerTest2 extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "data")
	public void validateDeleteCustomerAPI(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidId(data);
		
		response.prettyPrint();
		//customizing logs
		ExtentListeners.testReport.get().info(data.toString());
		
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
		
		//JsonPath json = response.jsonPath();
		
		/*
		 * String actualId = json.get("id").toString();
		 * 
		 * Assert.assertEquals(actualId,data.get("id"),"ID not matching");
		 */
		
		/*JSONObject jsonObject = new JSONObject(response.asString());
		
		//checking whether response has key id
		Assert.assertTrue(jsonObject.has("id"),"ID key is not present in the Json response body");*/
		
		//checking whether response has key id
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"ID key is not present in the Json response body");
		
		//checking what value does the key id have
		//Assert.assertEquals(jsonObject.get("id").toString(), data.get("id"),"ID not matching"); 
		
		//checking what value does the key id have
		String actual_id = TestUtil.getJsonKeyValue(response.asString(), "id");
		Assert.assertEquals(actual_id,data.get("id"),"ID not matching"); 

	}

	

}
