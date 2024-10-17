package com.adactinhotelapp.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {

	protected static WebDriver driver;

	public BaseClass() {
		PageFactory.initElements(driver, this);
	}

	public void getDriver(String browserName) {

		if (browserName.equalsIgnoreCase(Constants.chromeBrowser)) {
			System.setProperty(Constants.chromeKey, Constants.chromeValue);
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase(Constants.firefoxBrowser)) {
			System.setProperty(Constants.firefoxKey, Constants.firefoxValue);
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase(Constants.edgeBrowser)) {
			System.setProperty(Constants.edgeKey, Constants.edgeValue);
			driver = new EdgeDriver();
		} else {
			System.err.println(Constants.warningMessage);
			throw new IllegalArgumentException();
		}
	}
}
