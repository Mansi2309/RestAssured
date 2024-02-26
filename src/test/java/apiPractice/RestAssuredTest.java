package apiPractice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestAssuredTest extends Utils{

	public static String getURL = "https://reqres.in/api/users?page=2";
	public static String authenticationValue = "";
	public static String postURL = "https://reqres.in/api/users";
	public static String putURL = "https://reqres.in/api/users/2";
	public static String deleteURL = "https://reqres.in/api/users/2";
	@Test
	public void verifyGet() {
		Response getApiResponse = jsonClientGet(getURL, authenticationValue);
		System.out.println("Response body: " + getApiResponse.asString());
		System.out.println("Response code: " + getApiResponse.getStatusCode());
		
		if(getApiResponse.getStatusCode() == 200) {
			System.out.println("Api Passed");
		}
	}
	
	@Test
	public void verifyPost() {
		String requestPayload = requestPayload("mansi", "BE");
		Response postApiResponse = jsonClientPost(postURL, requestPayload, authenticationValue);
		System.out.println("Response body: " + postApiResponse.asString());
		System.out.println("Response code: " + postApiResponse.getStatusCode());
		
		if(postApiResponse.getStatusCode() == 200 || postApiResponse.getStatusCode() == 201) {
			System.out.println("Api Passed");
		}
	}
	
	@Test
	public void verifyPut() {
		String requestPayloadPut = requestPayloadPut("Mansi", "BE");
		Response putApiResponse = jsonClientPost(putURL, requestPayloadPut, authenticationValue);
		System.out.println("Response body: " + putApiResponse.asString());
		System.out.println("Response code: " + putApiResponse.getStatusCode());
		
		if(putApiResponse.getStatusCode() == 200 || putApiResponse.getStatusCode() == 201) {
			System.out.println("Api Passed");
		}
	}
	
	@Test
	public void verifyDelete() {
		String requestPayloadDelete = requestPayloadDelete("999");
		Response deleteApiResponse = jsonClientDelete(deleteURL, requestPayloadDelete, authenticationValue);
		System.out.println("Response body: " + deleteApiResponse.asString());
		System.out.println("Response code: " + deleteApiResponse.getStatusCode());
		
		if(deleteApiResponse.getStatusCode() == 204) {
			System.out.println("Api Passed");
		}
	}

}
