package com.rest.assured.RestAssured;

import java.util.*;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import com.rest.assured.RestAssuredProject.RestAssuredCommon;

import io.restassured.response.Response;

public class Get_Rest_Assured extends RestAssuredCommon {

	@Test
	public void get_01() {
		Response res = given()
				.header("Content-Type","application/json")
				.when()
				.get("/Employee");

		System.out.println(res.getBody().asString());

		System.out.println("The Status Code is : " + res.getStatusCode());

		List<String> list1 = res.jsonPath().getList("detail");
		System.out.println("The Total Size of the JSON body : " + list1.size());

		for(int i=0;i<list1.size();i++) {
			Map<String,Object> map1 = res.jsonPath().getMap("detail["+i+"]");
			System.out.println( i + " : The Key and value : " + map1);
		}
		
		List<String> list2 = res.jsonPath().getList("detail.firstName");
		System.out.println("The FirstName is : " + list2);
	}
}