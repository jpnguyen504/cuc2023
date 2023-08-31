package steps;

import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DashboardPage;
import pages.Database;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	Database dataBase;

	@Before
	public void setUp() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dataBase = new Database();
	}

	@Given("^User is on techfios login page$")
	public void user_is_on_techfios_login_page() {
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		takeScreenshot(driver);
	}

	@When("^User enters username as \"([^\"]*)\"$")
	public void user_enters_username_as(String username) {
		loginPage.insertUserName(username);
	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String password) {
		loginPage.insertPassword(password);
	}

	@And("^User clicks on signin button$")
	public void user_clicks_on_signin_button() {
		loginPage.clickSigninButton();
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() {
		dashboardPage.validateDashboardPage("Dashboard");
		takeScreenshot(driver);
	}

	@When("^User enters username from database$")
	public void user_enters_username_from_database() throws SQLException {
		System.out.println("Username from DB: " + dataBase.getDataFromDb("username"));
		loginPage.insertUserName(dataBase.getDataFromDb("username"));
	}

	@When("^User enters password from database$")
	public void user_enters_password_from_database() throws SQLException {
		System.out.println("Password from DB: " + dataBase.getDataFromDb("password"));
		loginPage.insertPassword(dataBase.getDataFromDb("password"));
	}
	
//	@When("^User enters username from database list$")
//	public void user_enters_username_from_database_list() throws Throwable {
//		loginPage.insertUserName(dataBase.getDataFromDbAsList("username"));
//	}
//
//	@When("^User enters password from database list$")
//	public void user_enters_password_from_database_list() throws Throwable {
//		
//	}

	@After
	public void tearDown() {
//		driver.close();
		driver.quit();
	}

}
