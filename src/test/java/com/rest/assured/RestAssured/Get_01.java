package com.rest.assured.RestAssured;

import java.util.*;
import org.testng.annotations.*;
import com.rest.assured.RestAssuredProject.RestAssuredCommon;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Get_01 extends RestAssuredCommon {
	
	@BeforeTest
	public void names() {
		classname = this.getClass().getSimpleName();
	}
	
	@Test
	public void get_01() {
		Response res = given().contentType(ContentType.JSON).header("Content-Type","application/json")
				.when().get("/data");
		System.out.println(res.getBody().asString());
		List<String> jsonbodysize = res.jsonPath().getList("data");
		System.out.println("The Size is : " + jsonbodysize.size());
	}
}