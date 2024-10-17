package com.adactinhotelapp.TestUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.adactinhotelapp.TestBase.BaseClass;
import com.adactinhotelapp.TestBase.Constants;

public class DriverHelper extends BaseClass {

	static Select select;

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Constants.longWait, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public static void implicitlyWait(int wait) {
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	public static void get(String pageURL) {
		driver.get(pageURL);
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static void closeTab() {
		driver.close();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void sendKeys(WebElement element, String value) {
		element.click();
		element.clear();
		element.sendKeys(value);
	}

	public static void clickElement(WebElement element) {
		element.click();
	}

	public static void clearElement(WebElement element) {
		element.clear();
	}

	public static boolean elementIsDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public static boolean elementIsSelected(WebElement element) {
		return element.isSelected();
	}

	public static boolean elementIsEnabled(WebElement element) {
		return element.isEnabled();
	}

	public static void dropdownByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public static void dropdownByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public static void dropdownByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public static void getScreenShot(String fileName)
	{
		File screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File screenshotTo=new File(Constants.screenshotPath+"\\"+fileName+System.currentTimeMillis()+Constants.pngFormat);
		
		try {
		FileHandler.copy(screenshotAs, screenshotTo);
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		catch(IOException e)
		{
			e.getMessage();
		}
	}
}
