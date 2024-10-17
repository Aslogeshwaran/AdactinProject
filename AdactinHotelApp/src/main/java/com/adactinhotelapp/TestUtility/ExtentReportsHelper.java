package com.adactinhotelapp.TestUtility;

import com.adactinhotelapp.TestBase.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsHelper {

	public static ExtentReports generateExtentReports() {

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				Constants.reportPath + "//extentsparkReport" + System.currentTimeMillis()
						+ Constants.extentReportFileFormat);

		sparkReporter.config().setDocumentTitle(Constants.extentReportDocumentTitle);

		sparkReporter.config().setReportName(Constants.extentReportName);

		sparkReporter.config().setTheme(Theme.DARK);

		sparkReporter.config().setTimeStampFormat(Constants.extentReportTimeFormat);

		ExtentReports extentReports = new ExtentReports();

		extentReports.attachReporter(sparkReporter);

		return extentReports;
	}
}
