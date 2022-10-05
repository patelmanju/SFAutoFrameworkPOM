package com.SFProject.test.tests;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SFProject.test.base.SalesforceBaseScript;
import com.SFProject.test.utility.CommonUtility;
import com.SFtest.test.pages.home.HomePage;
import com.SFtest.test.pages.login.ForGotPasswordPage;
import com.SFtest.test.pages.login.LoginPage;

public class AutomationCaseScript extends SalesforceBaseScript {

	@Test
	public static void loginToSalesForceTest5() throws InterruptedException {
		String expected = "Home";
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		String usrname = CU.getApplicationProperty("username", sfDataFile);
		String passwrd = CU.getApplicationProperty("password", sfDataFile);

		LoginPage login = new LoginPage(driver);
		login.login(usrname, passwrd);
		report.logTestInfo("username entered");
		report.logTestInfo("password entered");
		report.logTestInfo("login button clicked");
		HomePage homepage = new HomePage(driver);
		String actual = homepage.GetTextFromHomeElement();
		Assert.assertEquals(expected, actual);

		homepage.clickusermenu();
		report.logTestInfo("usermenu button clicked");

		homepage.clickLogoutButton();
		report.logTestInfo("logout button clicked");
		Testcompletted("loginToSalesForceTest5");
	}

	@Test
	public static void invalidloginToSalesForseTest1() throws InterruptedException {

		LoginPage loginob = new LoginPage(driver);
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		String usrname = CU.getApplicationProperty("username", sfDataFile);

		loginob.enterUserName(usrname);
		report.logTestInfo("username entered");
		report.logTestInfo("testscript execution completed");
		Testcompletted("loginToSalesForceTest1");
	}

	@Test
	public static void loginToSalesForceTest3() throws InterruptedException {
		String expected = "Home";
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		String usrname = CU.getApplicationProperty("username", sfDataFile);
		String passwrd = CU.getApplicationProperty("password", sfDataFile);

		LoginPage login = new LoginPage(driver);
		login.loginwithrememberme(usrname, passwrd);
		report.logTestInfo("username entered");
		report.logTestInfo("password entered");
		report.logTestInfo("remember me checked");
		HomePage homepage = new HomePage(driver);
		String actual = homepage.GetTextFromHomeElement();
		Assert.assertEquals(expected, actual);

		homepage.clickusermenu();
		homepage.clickLogoutButton();

		Testcompletted("loginToSalesForceTest3");
	}

	@Test
	public static void loginToSalesForceTest4a() throws InterruptedException {

		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		String usrname = CU.getApplicationProperty("username", sfDataFile);

		LoginPage login = new LoginPage(driver);
		login.enterUserName(usrname);
		report.logTestInfo("username entered");
		login.clickforgotpassword();
		report.logTestInfo("Forgot password clicked");

		ForGotPasswordPage ForGot = new ForGotPasswordPage(driver);
		ForGot.enterUserName(usrname);
		ForGot.continuebutton();

		Testcompletted("loginToSalesForceTest4a");
	}

	@Test
	public static void invalidloginToSalesForseTest4b() throws InterruptedException {

		LoginPage loginob = new LoginPage(driver);
		loginob.login("123", "12345");
		report.logTestInfo("username entered");
		report.logTestInfo("password entered");
		report.logTestInfo("login button clicked");
		report.logTestInfo("error message displayed");
		report.logTestInfo("testscript execution completed");

		Testcompletted("loginToSalesForceTest4b");
	}

}
