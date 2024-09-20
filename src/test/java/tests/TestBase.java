package tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utlitis.Helper;

public class TestBase extends AbstractTestNGCucumberTests {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeSuite
	public static void startWebBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@AfterSuite
	public void stopBrowser() {
        if (driver != null) {
            driver.quit();
        }
	}

	@AfterMethod
	public void screenShotWhenTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("The Test Is Failed! " + " Taking Screenshot..");
			Helper.captureScreenShot(driver, result.getName());
		}
	}
}
