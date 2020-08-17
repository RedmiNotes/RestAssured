package com.rest.assured.RestAssured;

import java.util.*;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;

import com.relevantcodes.extentreports.LogStatus;
import com.rest.assured.RestAssuredProject.RestAssuredCommon;

import io.restassured.response.Response;

public class Get_Rest_Assured extends RestAssuredCommon {
	
	@BeforeTest
	public void names() {
		classname = this.getClass().getSimpleName();
	}

	@Test
	public void get_01() {
		Response res = given()
				.header("Content-Type","application/json")
				.when()
				.get("/Employee");

		test.log(LogStatus.INFO, "The Json Body is : " + res.getBody().asString());
		System.out.println("The Json Body is : " + res.getBody().asString());

		test.log(LogStatus.INFO, "The Status Code is : " + res.getStatusCode());
		System.out.println("The Status Code is : " + res.getStatusCode());

		List<String> list1 = res.jsonPath().getList("data");
		System.out.println("The Total Size of the JSON body : " + list1.size());
		test.log(LogStatus.INFO, "The Total Size of the JSON body : " + list1.size());

		for(int i=0;i<list1.size();i++) {
			Map<String,Object> map1 = res.jsonPath().getMap("data["+i+"]");
			System.out.println(i + " : The Key and value : " + map1);
			test.log(LogStatus.INFO, i + " : The Key and value : " + map1);
		}
		
		List<String> list2 = res.jsonPath().getList("data.first_name");
		System.out.println("The FirstName is : " + list2);
		test.log(LogStatus.INFO, "The FirstName is : " + list2);
	}
}