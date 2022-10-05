package com.SFtest.test.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SFtest.test.pages.base.BasePage;

public class LoginPage extends BasePage {
	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "Login")
	WebElement loginButton;
	@FindBy(xpath = "//input[@id='rememberUn']")
	WebElement RememberMe;
	@FindBy(id="forgot_password_link")
	WebElement ForgotPassword;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUserName(String usrname) {
		waitUntilVisible(username, "user name field");
		enterText(username, usrname, "username field");
	}

	public void enterPassword(String passWrd) {
		enterText(password, passWrd, "password field");

	}

	public void clickLoginButton() {
		clickElement(loginButton, "login button");
	}
	public void clickrememberme() {
		clickElement(RememberMe, "remember me checked");
	}
	public void clickforgotpassword() {
		clickElement(ForgotPassword, "Forgot password clicked");
	}

	public void login(String usrname, String passWrd) {
		enterUserName(usrname);
		enterPassword(passWrd);
		clickLoginButton();
	}
	public void loginwithrememberme(String usrname, String passWrd) {
		enterUserName(usrname);
		enterPassword(passWrd);
		clickrememberme();
		clickLoginButton();
	}
	public  void closebrowser() {
		closebrowser();
	}

}
