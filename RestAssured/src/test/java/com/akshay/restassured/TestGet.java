package com.akshay.restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TestGet {

	private static RestAssured restAssured;

	@Test
	public void tc_01() {
		restAssured = new RestAssured();
		Response response = restAssured.when().get("http://dummy.restapiexample.com/api/v1/employees");
		System.out.println("Response status code:" + response.statusCode());
		System.out.println("Response body:"+ response.getBody().asString());
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
