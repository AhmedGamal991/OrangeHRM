package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminSteps {

	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	AdminPage adminObject;
	int initialRecordCount;

	@Given("User navigates to OrangeHRM")
	public void user_navigates_to_orange_hrm() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("User logs in with {string} and {string}")
	public void user_logs_in_with_and(String userNameInput, String password) throws InterruptedException {
		loginPage.userLogin(userNameInput, password);
	}

	@When("User clicks on Admin tab")
	public void user_clicks_on_admin_tab() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.AdminTapBtn();
		adminObject = new AdminPage(driver);
	}

	@When("User clicks on Add button and fills the details with {string}, {string}, {string}, {string}")
	public void user_clicks_on_add_button_and_fills_the_details_with(String username, String password,
			String confirmPassword, String employeeName) throws InterruptedException {
		adminObject.fillUserDetails(username, password, confirmPassword, employeeName);
	}

	@When("User searches for the new user with {string}")
	public void user_searches_for_the_new_user_with(String username) throws InterruptedException {
		adminObject.searchUser("Flairs-tech");
	}

	@When("User deletes the newly added user")
	public void user_deletes_the_newly_added_user() throws InterruptedException {
		adminObject.deleteUser();
	}

}
