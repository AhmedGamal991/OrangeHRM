package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		PageBase.driver = driver;

	}

	@FindBy(partialLinkText = "Admin")

	WebElement adminTab;

	@FindBy(name = "password")
	WebElement passwordLbel;

	@FindBy(tagName = "button")
	WebElement LogInBut;

	public void AdminTapBtn() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(adminTab)); // Wait until the Admin tab is visible
		wait.until(ExpectedConditions.elementToBeClickable(adminTab));
		clickButton(adminTab);

		Thread.sleep(2000);
	}

}
