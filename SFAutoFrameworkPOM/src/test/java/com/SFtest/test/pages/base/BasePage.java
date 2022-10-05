package com.SFtest.test.pages.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SFProject.test.utility.GenerateReports;
import com.SFProject.test.utility.constants;

public class BasePage {
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	public static GenerateReports report=null;

	public  BasePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		report = GenerateReports.getInstance();
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
		report.logTestInfo("page got refreshed");
	}

	public static void entertext(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			report.logTestInfo("text entered in " + objName + "field");
		} else {
			report.logTestFailed("fail" + objName + "element not displayed");

		}
	}

	

	public static void clearElement(WebElement element, String objName) {
		if (element.isDisplayed()) {

			element.clear();
			report.logTestInfo("pass " + objName + "is cleared");

		} else {
			report.logTestFailed("fail" + objName + "element not displayed");

		}
	}

	public static void clickElement(WebElement element, String objName) {
		if (element.isDisplayed()) {

			element.click();
			 report.logTestInfo("pass " + objName + " element clicked");

		} else {
			report.logTestFailed("fail" + objName + "element not clicked");
		}
	}

	public static void enterText(WebElement element, String text, String objName) {
		if (element.isDisplayed()) {
			clearElement(element, objName);
			element.sendKeys(text);
			report.logTestInfo("text entered in " + objName + "field");

		} else {
			report.logTestFailed("fail: \" + objName + \" element not displayed");
		}
	}
	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllbrowser() {
		driver.quit();
	}

	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static void waitUntillVisibilityOf(WebElement locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public static void waitUntilVisible(WebElement element, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntillpresenceOfElement(WebElement locator, String objName) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
		// presenceOfElementLocated condition
		w.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
	}

	public static void waituntillclickable() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(\"//a[contains(text(),'About')]\"")));
	}

	public static void waituntillclickable(WebElement locator, String objname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void switchToWindowOpned(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
		System.out.println("switched to new window");
	}

	public static void moveToElement(WebElement element, String objectName) {
		waitUntilVisible(element, objectName);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		report.logTestInfo("moved to " + objectName);

	}

	public static void selectOptionFromDropDown(WebElement ele, String value) {
		Select drp = new Select(ele);
		List<WebElement> alloptions = drp.getOptions();
		for (WebElement option : alloptions) {
			if (option.getText().equals(value)) {
				option.click();
				break;

			}
		}

	}

	public static WebDriver getDriverInstance() {
		return driver;
	}

	public static void waitUntilVisibilityOf(By locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static String readText(WebElement element, String objectName) {
		waitUntilVisible(element, objectName);
		String hometab = element.getText();
		return hometab;
	}

	public static void waitUntilAlertIsPresent() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitUntilElementToBeClickable(By locator, String objName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static Alert switchToAlert() {
		waitUntilAlertIsPresent();
		return driver.switchTo().alert();
	}

	public static void AcceptAlert(Alert alert) {

		System.out.println("Alert accepted");
		alert.accept();

	}

	public static String getAlertText(Alert alert) {

		return alert.getText();

	}

	public static void dismisAlert() {
		waitUntilAlertIsPresent();
		Alert alert = switchToAlert();
		alert.dismiss();
		System.out.println("Alert dismissed");

	}

	public static void selectByTextData(WebElement element, String text, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		System.out.println(objName + " seelcted " + text);

	}

	public static void selectByIndexData(WebElement element, int index, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
	}

	public static void selectByValueData(WebElement element, String text) {
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
	}

	public static WebElement selectFromList(List<WebElement> list, String text) {
		WebElement country = null;
		for (WebElement i : list) {
			if (i.getText().equalsIgnoreCase(text)) {
				System.out.println("selected=" + i.getText());
				country = i;
				break;
			}

		}
		return country;

	}

	public static String captureWebElementScreenshot(WebElement elementLogo, String filename) {

		File src = elementLogo.getScreenshotAs(OutputType.FILE);
		File dest = new File(constants.SCREENSHOT_PATH + "/" + filename + ".jpg");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException exception) {
			report.logTestFailedWithException(exception);
		}
		return dest.getAbsolutePath();
	}

	public static String captureWebElementScreenshot(WebElement elementLogo) {
		SimpleDateFormat df = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
		Date date = new Date();
		String curDataAndTime = df.format(date);
		File src = elementLogo.getScreenshotAs(OutputType.FILE);
		report.logTestInfo("web element screenshot captured");
		File dest = new File(constants.SCREENSHOT_PATH + "/" + curDataAndTime + ".jpg");

		try {
			FileHandler.copy(src, dest);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return dest.getAbsolutePath();
	}

}
