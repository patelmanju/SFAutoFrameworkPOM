package com.SFtest.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForGotPasswordPage extends LoginPage {
	@FindBy(id ="un")
	WebElement untestbox;
	@FindBy(id ="continue")
	WebElement continuebutton;
	

	public ForGotPasswordPage(WebDriver driver) {
				super(driver);
	}
	public void continuebutton() {
		clickElement(continuebutton, "continue button");
	}
	
	public void enterUserName(String usrname) {
		waitUntilVisible(untestbox, "user name field");
		enterText(untestbox, usrname, "username field");
	}
}
