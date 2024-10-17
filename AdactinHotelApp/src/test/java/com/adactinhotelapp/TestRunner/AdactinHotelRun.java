package com.adactinhotelapp.TestRunner;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.adactinhotelapp.TestBase.BaseClass;
import com.adactinhotelapp.TestBase.Constants;
import com.adactinhotelapp.TestBase.ObjectFactory;
import com.adactinhotelapp.TestUtility.DriverHelper;
import com.adactinhotelapp.TestUtility.ExcelHelper;
import com.adactinhotelapp.TestUtility.ListenersHelper;

@Listeners(ListenersHelper.class)
public class AdactinHotelRun extends BaseClass {

	ObjectFactory objectFactory;
	ExcelHelper excel;
	SoftAssert softAssert;

	@BeforeTest
	public void launchBrowser() {
		getDriver(Constants.browserName);
		DriverHelper.maximize();
		DriverHelper.implicitlyWait(2);
		DriverHelper.get(Constants.pageURL);
		objectFactory = new ObjectFactory();
		softAssert = new SoftAssert();
		excel = new ExcelHelper(Constants.excelPath, Constants.excelSheetName);
	}

	@Test(priority = 0, description = "This Test is used to get WebPage Title")
	public void printTitle() {
		String actualTitle = DriverHelper.getTitle();
		softAssert.assertEquals(actualTitle, Constants.expectedPageTitle);
		System.out.println(1);
		System.out.println(1);
		System.out.println(1);
		softAssert.assertAll();
	}

	@Test(priority = 1, description = "This Test is used to get WebPage Current URL")
	public void printCurrentUrl() {
		String actualCurrentUrl = DriverHelper.getCurrentUrl();
		softAssert.assertEquals(actualCurrentUrl, Constants.expectedPageUrl);
		System.out.println(2);
		System.out.println(2);
		System.out.println(2);
		softAssert.assertAll();
	}

	@Test(priority = 2, description = "This Test is used to login with account")
	public void verifyLogin() {

		try {
			objectFactory.getInstanceOfLandingPage().enterUserNameField(excel.findValue(0, 0));
			objectFactory.getInstanceOfLandingPage().enterPasswordField(excel.findValue(0, 1));
			objectFactory.getInstanceOfLandingPage().clickLoginButton();
			try {
				WebElement welcomeMessage = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/input"));
				if (welcomeMessage.isDisplayed()) {
					System.out.println(welcomeMessage.getAttribute("value"));
				}
			} catch (NoSuchElementException e) {
				System.err.println("Please Check the Username and Password...");
				Assert.fail("Login Failed...");

			}
			System.out.println(3);
			System.out.println(3);
			System.out.println(3);
		} catch (NoSuchElementException e) {
			System.err.println("Please check the locators...");
			Assert.fail("Test got Failed Due to locator mismatch...");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}



	}

	// @Test(priority = 3, description = "This Test is used to search hotel list",
	// dependsOnMethods = "verifyLogin")
	// public void verifySearchHotel() {
	// objectFactory.getInstanceOfSearchHotelPage().pickDropdownLocation(1);
	// objectFactory.getInstanceOfSearchHotelPage().pickDropdownHotel(1);
	// objectFactory.getInstanceOfSearchHotelPage().pickDropdownRoomType(1);
	// objectFactory.getInstanceOfSearchHotelPage().pickDropdownNumberOfRoom(1);
	// objectFactory.getInstanceOfSearchHotelPage().enterDateInField("10/10/2024");
	// objectFactory.getInstanceOfSearchHotelPage().enterDateOutField("15/10/2024");
	// objectFactory.getInstanceOfSearchHotelPage().pickDropdownAdultsCount(1);
	// objectFactory.getInstanceOfSearchHotelPage().pickDropdownChildrenCount(1);
	// objectFactory.getInstanceOfSearchHotelPage().clickSearchButton();
	// }
	//
	// @Test(priority = 4, description = "This Test is used to verify the radio
	// button status", dependsOnMethods = "verifySearchHotel")
	// public void verifySelectHotelRadioButton() {
	// System.out.println(objectFactory.getInstanceOfSearchHotelPage().isDisplayedRadioButtonSelectHotel());
	// System.out.println(objectFactory.getInstanceOfSearchHotelPage().isEnabledRadioButtonSelectHotel());
	// System.out.println(objectFactory.getInstanceOfSearchHotelPage().isSelectedRadioButtonSelectHotel());
	// objectFactory.getInstanceOfSearchHotelPage().clickRadioButtonSelectHotel();
	// System.out.println(objectFactory.getInstanceOfSearchHotelPage().isSelectedRadioButtonSelectHotel());
	// objectFactory.getInstanceOfSearchHotelPage().clickContinueButton();
	// }
}
