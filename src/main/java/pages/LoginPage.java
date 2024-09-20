package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;


	@FindBy(tagName ="button")
	WebElement LogInBut;

	public void userLogin(String userNameInput, String password) throws InterruptedException {
		Thread.sleep(2000);
		setTextElementText(userNameField, userNameInput);
		setTextElementText(passwordField, password);
		Thread.sleep(2000);
		clickButton(LogInBut);
	}
}
