package com.adactinhotelapp.TestBase;

public class Constants {

	static PropertyReader reader = new PropertyReader();

	final public static int longWait = 30;

	final public static int mediumWait = 20;

	final public static int shortWait = 10;

	final public static int longSleep = 3000;

	final public static int mediumSleep = 2000;

	final public static int shortSleep = 1000;

	final public static String expectedPageTitle = "Adactin - Hotel Reservation System";

	final public static String expectedPageUrl = "http://adactinhotelapp.com/";

	final public static String pngFormat = ".png";

	final public static String jpegFormat = ".jpeg";

	final public static String extentReportFileFormat = ".html";

	final public static String chromeBrowser = "chrome";

	final public static String firefoxBrowser = "firefox";

	final public static String edgeBrowser = "edge";

	final public static String excelSheetName = "loginData";

	final public static String extentReportDocumentTitle = "Adactin Hotel Automation";

	final public static String extentReportName = "Adactin Test Automation Results";

	final public static String extentReportTimeFormat = "dd:MM:yyyy hh:mm:ss, EEEE";

	final public static String chromeKey = reader.getProperty("chromeKey");

	final public static String chromeValue = reader.getProperty("chromeValue");

	final public static String edgeKey = reader.getProperty("edgeKey");

	final public static String edgeValue = reader.getProperty("edgeValue");

	final public static String firefoxKey = reader.getProperty("firefoxKey");

	final public static String firefoxValue = reader.getProperty("firefoxValue");

	final public static String excelPath = reader.getProperty("excelPath");

	final public static String screenshotPath = reader.getProperty("screenshotPath");

	final public static String reportPath = reader.getProperty("reportPath");

	final public static String pageURL = reader.getProperty("pageurl");

	final public static String browserName = reader.getProperty("browsername");

	final public static String warningMessage = reader.getProperty("warningMessage");

	final public static String username = reader.getProperty("username");

	final public static String password = reader.getProperty("password");

}
