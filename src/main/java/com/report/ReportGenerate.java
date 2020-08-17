package com.report;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportGenerate {
	public String classname;
	public static ExtentReports report;
	public static ExtentTest test;

	public static void createfolder(String path) {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
	}

	public String timestamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd-MMM-yyyy hh-mm-ss aa");
		String s1 = sdf.format(date).toString();
		return s1;
	}

	@BeforeClass
	public void startreport() {
		String filepath = System.getProperty("user.dir")+"/Extent Report/" + timestamp();
		createfolder(filepath);
		report = new ExtentReports(filepath + "/"+classname+".html",true,DisplayOrder.NEWEST_FIRST);
	}
	@AfterSuite
	public void endreport() {
		report.flush();
	}
	@BeforeMethod
	public void methodget(ITestResult method) {
		test = report.startTest(method.getMethod().getMethodName());
	}
	@AfterMethod
	public void methodend() {
		report.endTest(test);
	}
}