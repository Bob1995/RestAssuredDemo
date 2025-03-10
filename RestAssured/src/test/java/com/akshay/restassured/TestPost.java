package com.akshay.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestPost {

	private static RequestSpecification requestSpecification = null;

	String payload = "  title: 'foo',\r\n" + "    body: 'bar',\r\n" + "    userId: 1,";

	@Test
	public void tc_02() {
		requestSpecification = RestAssured.given();
		Response response = requestSpecification.log().all().body(payload)
				.post("https://jsonplaceholder.typicode.com/posts");
		// Validating Status code
		System.out.println("Response status code:" + response.statusCode());
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println("Response:"+response.prettyPrint());
	}
}
