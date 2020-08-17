package com.rest.assured.RestAssuredProject;

import org.testng.annotations.*;
import com.report.ReportGenerate;
import static io.restassured.RestAssured.baseURI;

public class RestAssuredCommon extends ReportGenerate {

	@BeforeTest
	public void commonURI() {
		try {
			baseURI = "http://localhost:3000";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}