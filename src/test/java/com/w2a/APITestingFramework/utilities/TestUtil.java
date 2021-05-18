package com.w2a.APITestingFramework.utilities;

import org.json.JSONObject;

import com.w2a.APITestingFramework.listeners.ExtentListeners;

public class TestUtil {

	public static boolean jsonHasKey(String json,String key) {
		
		
		JSONObject jsonObject = new JSONObject(json);
		
		//for logs
		ExtentListeners.testReport.get().info("Validating the presence of Key : "+key.toString());
		return jsonObject.has(key);
	}
	
	
	
public static String getJsonKeyValue(String json,String key) {
		
		JSONObject jsonObject = new JSONObject(json);
		
		ExtentListeners.testReport.get().info("Validating the value of Key : "+key);
		
		return jsonObject.get(key).toString();
}

}