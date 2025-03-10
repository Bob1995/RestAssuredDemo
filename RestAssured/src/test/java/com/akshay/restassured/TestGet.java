package com.akshay.restassured;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGet {

	private static RequestSpecification requestSpecification = null;

	@Test
	public void tc_01() {
		requestSpecification = RestAssured.given();
		Response response = requestSpecification.log().all().get("https://fake-json-api.mock.beeceptor.com/users");
		// Validating Status code
		System.out.println("Response status code:" + response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		//response
		System.out.println("Response body:" + response.getBody().asString());

		// Fetching response
		System.out.println("Response field:name" + response.getBody().jsonPath().get("name"));
		System.out.print("Response field:Company" + response.getBody().jsonPath().get("company"));

	}

}
