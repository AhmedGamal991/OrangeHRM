package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends PageBase {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		if (driver == null) {
			throw new IllegalArgumentException("WebDriver.");
		}
		this.driver = driver;

	}

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
	WebElement addButton;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeNameInput;

	@FindBy(xpath = "//label[text()='Username']/following::input")
	WebElement usernameInput;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement passwordInput;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]")
	WebElement confirmPasswordInput;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	WebElement roleDropdown;

	@FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
	WebElement roleAdmin;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")
	WebElement statusDropdown;

	@FindBy(xpath = "(//div[@role='listbox']//child::div)[2]")
	WebElement statusEnabled;

	@FindBy(css = "button[type='submit']")
	WebElement saveButton;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]") // First
																																	// suggestion
	WebElement firstSuggestion;

	@FindBy(xpath = "//td[text()='No Records Found']")
	WebElement noRecordsFound;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/hr[1]")
	public static List<WebElement> resultRows;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/button[2]")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement searchUsernameInput;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]/i[1]")
	WebElement firstCheckbox;

	@FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[6]/div[1]/button[1]/i[1]")
	WebElement deleteButton;

	@FindBy(xpath = "//body/div[@id='app']/div[3]/div[1]/div[1]/div[1]/div[3]/button[2]")
	WebElement confirmDeleteButton;

	public int getNumberOfRecords() throws InterruptedException {
		Thread.sleep(2000);
		try {
			if (resultRows != null && !resultRows.isEmpty()) {
				System.out.println("Number of records found: " + resultRows.size());
				return resultRows.size();
			} else {
				System.out.println("No records found.");
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void fillUserDetails(String username, String password, String confirmpassword, String employeeName)
			throws InterruptedException {
		clickButton(addButton);
		Thread.sleep(2000);
		setTextElementText(usernameInput, username);
		Thread.sleep(2000);
		setTextElementText(passwordInput, password);
		setTextElementText(confirmPasswordInput, confirmpassword);
		setTextElementText(employeeNameInput, employeeName);
		Thread.sleep(2000);
		sendKeySequence(employeeNameInput, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(1000);
		clickButton(roleDropdown);
		Thread.sleep(1000);
		clickButton(roleAdmin);
		clickButton(statusDropdown);
		clickButton(statusEnabled);
		Thread.sleep(2000);
		clickButton(saveButton);
		Thread.sleep(2000);
	}

	public void searchUser(String username) {
		setTextElementText(searchUsernameInput, username);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		clickButton(searchButton);
		scrollTo();
	}

	public void deleteUser() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
		clickButton(deleteButton);
		Thread.sleep(2000);
		clickButton(confirmDeleteButton);
	}
}
