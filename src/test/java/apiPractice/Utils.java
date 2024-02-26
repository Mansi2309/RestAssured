package apiPractice;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public Response jsonClientGet(String url, String authValue) {
		Response response = null;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Authorization", authValue);
		response = httpRequest.get(url);
		try {
			if (response.statusCode() != 200) {
				System.out.println("Error: Response code is : " + response.statusCode());
			}
		} catch (final Exception e) {
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}

	public Response jsonClientPost(String url, String payload, String authValue) {
		Response response = null;
		RequestSpecification httpReuest = RestAssured.given();
		httpReuest.header("Content-Type", "application/json");
		httpReuest.body(payload);
		httpReuest.header("Authentication", authValue);
		response = httpReuest.post(url);
		try {
			if (response.statusCode() != 200 && response.statusCode() != 201) {
				System.out.println("Error in api : " + response.getStatusCode());
			}
		} catch (final Exception e) {
			throw new RuntimeException("Failed and code is : " + response.getStatusCode());
		}
		return response;
	}

	public String requestPayload(String name, String job) {
		JSONObject mainObj = new JSONObject();
		mainObj.put("name", name);
		mainObj.put("job", job);
		return mainObj.toString();
	}

	public Response jsonClientPut(String url, String payload, String authVal) {
		Response response = null;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(payload);
		httpRequest.header("Authentication", authVal);
		response = httpRequest.put(url);
		try {
			if (response.statusCode() != 200 && response.statusCode() != 201) {
				System.out.println("Error in api code is: " + response.statusCode());
			}
		} catch (final Exception e) {
			throw new RuntimeException("Error : " + response.statusCode());
		}
		return response;
	}

	public String requestPayloadPut(String name, String job) {
		JSONObject mainObj = new JSONObject();
		mainObj.put("name", name);
		mainObj.put("job", job);
		return mainObj.toString();
	}

	public Response jsonClientDelete(String url, String payload, String authVal) {
		Response response = null;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(payload);
		httpRequest.header("Authentication", authVal);
		response = httpRequest.delete(url);
		try {
			if (response.statusCode() != 200 && response.statusCode() != 204) {
				System.out.println("Failed : RestAssured error code : " + response.statusCode());
			} else {
				System.out
						.println("Passed : Deleted Successfully: RestAssured response code : " + response.statusCode());
			}
		} catch (final Exception e) {
			throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
		}
		return response;
	}

	public String requestPayloadDelete(String id) {
		JSONObject mainObj = new JSONObject();
		mainObj.put("id", id);
		return mainObj.toString();
	}
}
