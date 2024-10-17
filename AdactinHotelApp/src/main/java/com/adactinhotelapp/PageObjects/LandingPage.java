package com.adactinhotelapp.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactinhotelapp.TestBase.BaseClass;
import com.adactinhotelapp.TestUtility.DriverHelper;

public class LandingPage extends BaseClass {

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "New User Register Here")
	WebElement registerLink;

	@FindBy(linkText = "Forgot Password?")
	WebElement forgotPasswordLink;

	@FindBy(id = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login")
	WebElement loginButton;

	public void enterUserNameField(String username) {
		DriverHelper.sendKeys(usernameField, username);
	}

	public void enterPasswordField(String password) {
		DriverHelper.sendKeys(passwordField, password);
	}

	public void clickLoginButton() {
		DriverHelper.clickElement(loginButton);
	}

	public void clickRegisterLink() {
		DriverHelper.clickElement(registerLink);
	}

	public void clickForgotPasswordLink() {
		DriverHelper.clickElement(forgotPasswordLink);
	}

}
