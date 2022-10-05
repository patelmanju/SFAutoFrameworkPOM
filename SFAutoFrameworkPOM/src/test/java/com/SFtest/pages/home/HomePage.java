package com.SFtest.pages.home;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SFtest.pages.base.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath = "//li[@id='home_Tab']") WebElement Hometab;
	@FindBy(id="userNavLabel") WebElement usermenu;
	@FindBy(xpath ="//a[contains(text(),'Logout')]")  WebElement logout;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String GetTextFromHomeElement() {
		String label = readText(Hometab, "Hometab label");
		String path = captureWebElementScreenshot(Hometab, "HometabImage");
		try {
			report.attachScreeshot(path);
		} catch (IOException e) {
			report.logTestFailedWithException(e);
		}
		return label;
	}
	public void clickusermenu() {
	clickElement(usermenu,"user menu button");
	waitUntillpresenceOfElement(usermenu, "user menu");
		}
	
	public void clickLogoutButton() {
		clickElement(logout, "logout button");
	}
public  void closebrowser() {
	closeAllbrowser();
}
}
