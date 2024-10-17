package com.adactinhotelapp.TestUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersHelper implements ITestListener {

	ExtentReports extentReports;
	ExtentTest test;
	String testName;

	@Override
	public void onStart(ITestContext context) {
		extentReports = ExtentReportsHelper.generateExtentReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		test = extentReports.createTest(testName);
		test.log(Status.INFO, "Test started...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed...");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test failed...");
		DriverHelper.getScreenShot(testName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testName = result.getName();
		test = extentReports.createTest(testName);
		test.log(Status.SKIP, "Test got skipped...");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		// DriverHelper.closeTab();
	}
}
