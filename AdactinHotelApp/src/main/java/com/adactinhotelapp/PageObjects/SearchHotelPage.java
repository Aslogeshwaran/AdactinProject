package com.adactinhotelapp.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.TestBase.BaseClass;
import com.adactinhotelapp.TestUtility.DriverHelper;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "datepick_in")
	WebElement dateInField;

	@FindBy(id = "datepick_out")
	WebElement dateOutField;

	@FindBy(id = "Submit")
	WebElement searchButton;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(id = "location")
	WebElement dropdownLocation;

	@FindBy(id = "hotels")
	WebElement dropdownHotel;

	@FindBy(id = "room_type")
	WebElement dropdownRoomType;

	@FindBy(id = "room_nos")
	WebElement dropdownNumberOfRoom;

	@FindBy(id = "adult_room")
	WebElement dropdownAdultsCount;

	@FindBy(id = "child_room")
	WebElement dropdownChildrenCount;

	@FindBy(xpath = "//input[starts-with(@id,'radiobutton')]")
	WebElement radioButtonSelectHotel;

	public boolean isDisplayedRadioButtonSelectHotel() {
		return DriverHelper.elementIsDisplayed(radioButtonSelectHotel);
	}

	public boolean isEnabledRadioButtonSelectHotel() {
		return DriverHelper.elementIsEnabled(radioButtonSelectHotel);
	}

	public boolean isSelectedRadioButtonSelectHotel() {
		return DriverHelper.elementIsSelected(radioButtonSelectHotel);
	}

	public void clickRadioButtonSelectHotel() {
		DriverHelper.clickElement(radioButtonSelectHotel);
	}

	public void enterDateInField(String date) {
		DriverHelper.sendKeys(dateInField, date);
	}

	public void enterDateOutField(String date) {
		DriverHelper.sendKeys(dateOutField, date);
	}

	public void clickSearchButton() {
		DriverHelper.clickElement(searchButton);
	}

	public void clickContinueButton() {
		DriverHelper.clickElement(continueButton);
	}

	public void pickDropdownLocation(int index) {
		DriverHelper.dropdownByIndex(dropdownLocation, index);
	}

	public void pickDropdownHotel(int index) {
		DriverHelper.dropdownByIndex(dropdownHotel, index);
	}

	public void pickDropdownRoomType(int index) {
		DriverHelper.dropdownByIndex(dropdownRoomType, index);
	}

	public void pickDropdownNumberOfRoom(int index) {
		DriverHelper.dropdownByIndex(dropdownNumberOfRoom, index);
	}

	public void pickDropdownAdultsCount(int index) {
		DriverHelper.dropdownByIndex(dropdownAdultsCount, index);
	}

	public void pickDropdownChildrenCount(int index) {
		DriverHelper.dropdownByIndex(dropdownChildrenCount, index);
	}
}
