package tests;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class Login_Test extends TestBase {
	HomePage homepage;
	AdminPage adminObject;
	LoginPage userLogIn;

	@Test(priority = 1)
	public void UserCanLogin() throws InterruptedException {
		userLogIn = new LoginPage(driver);
		userLogIn.userLogin("Admin", "admin123");
		homepage = new HomePage(driver);
		homepage.AdminTapBtn();
		adminObject = new AdminPage(driver);
		adminObject.fillUserDetails("Peter Mac Anderson", "Falirs Tech", "pasword123", "pasword123");
		
	}
	@Test(priority = 1)
	public void UserCandelte() throws InterruptedException {
		userLogIn = new LoginPage(driver);
		userLogIn.userLogin("Admin", "admin123");
		homepage = new HomePage(driver);
		homepage.AdminTapBtn();
		adminObject = new AdminPage(driver);
		adminObject.searchUser("Flairs-tech");
		adminObject.deleteUser();
		
	}
}
