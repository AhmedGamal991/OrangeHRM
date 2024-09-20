package tests;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class Admin_Test extends TestBase {
	HomePage homeObject;
	AdminPage adminObject;
	LoginPage loginObject;

	@Test(priority = 1)
	public void userCanRegisterationSuccssefullay() throws InterruptedException {
		loginObject = new LoginPage(driver);
		loginObject.userLogin("Admin", "admin123");
		homeObject = new HomePage(driver);
		homeObject.AdminTapBtn();
		adminObject = new AdminPage(driver);
		adminObject.fillUserDetails("Falirs-tech", "password123", "password123", "a");

	}

	@Test(priority = 2)
	public void userCanSearchSuccssefullay() throws InterruptedException {
		//loginObject = new LoginPage(driver);
		//loginObject.userLogin("Admin", "admin123");
		//homeObject = new HomePage(driver);
		//homeObject.AdminTapBtn();
		adminObject = new AdminPage(driver);
		adminObject.searchUser("Flairs-tech");

	}
}
