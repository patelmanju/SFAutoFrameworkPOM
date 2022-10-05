package SFProject.utility.base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import SFProject.utility.CommonUtility;
import SFProject.utility.GenerateReports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceBaseScript {

	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static WebElement usermenu = null;
	public static Logger logger = LogManager.getLogger(SalesforceBaseScript.class);
	public static GenerateReports report = null;

	@BeforeTest
	public static void setupBeforeTest() {
		report = GenerateReports.getInstance();
		report.startExtentReport();
	}

	@Parameters({ "browserName" })
	@BeforeMethod
	public static void setUp(String browserName, Method m) {
		report.startSingleTestReport(m.getName());
		setDriver(browserName);
		CommonUtility CU = new CommonUtility();
		Properties sfDataFile = CU.loadFile("sfData");
		String url = CU.getApplicationProperty("URL", sfDataFile);
		gotoUrl(url);
		waitUntilPageLoads();
	}

	@AfterMethod
	public static void tearDown() {
		report.logTestInfo("after method execution is started");
		closeAllbrowser();
	}

	@AfterTest
	public static void teardownAfterTest() {
		report.endReport();
	}

	public static void setDriver(String browser) {
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		default:
			report.logTestInfo("Enter correct browser name");
			break;

		}
	}

	public static WebDriver getDriverInstense() {
		return driver;
	}
	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	public static void gotoUrl(String url) {
		driver.get(url);
	}
	public static void closeBrowser() {
		driver.close();
	}

	public static void closeAllbrowser() {
		driver.quit();
	}

	

	public static void Testcompletted(String testname) {
		testname = null;
		report.logTestInfo(testname + "completed");

	}
}
