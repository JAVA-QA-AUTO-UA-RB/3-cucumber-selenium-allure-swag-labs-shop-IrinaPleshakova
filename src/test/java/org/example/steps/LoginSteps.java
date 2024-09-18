package org.example.steps;

import io.cucumber.java.en.*;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.example.utils.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginSteps {

	private static final Logger logger = LogManager.getLogger(LoginSteps.class);
	private WebDriver browser = WebDriverManager.getBrowser();
	private LoginPage loginPage = new LoginPage(browser);
	private ProductsPage productsPage = new ProductsPage(browser);

	@Given("I am on the Swag Labs login page")
	public void iAmOnTheSwagLabsLoginPage() {
		logger.info("Navigating to Swag Labs login page");
		browser.get("https://www.saucedemo.com/");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
		logger.info("Login page loaded successfully");
	}

	@When("I enter username {string} and password {string}")
	public void iEnterUsernameAndPassword(String username, String password) {
		logger.info("Entering username: {} and password: {}", username, password);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		logger.info("Entered username and password");
	}

	@And("I click the login button")
	public void iClickTheLoginButton() {
		logger.info("Clicking the login button");
		loginPage.clickLoginButton();
	}

	@Then("I should be redirected to the products page")
	public void iShouldBeRedirectedToTheProductsPage() {
		logger.info("Verifying redirection to the products page");
		Assert.assertTrue(productsPage.isProductsTitleDisplayed(), "Products page is not displayed");
		logger.info("Successfully redirected to the products page");
	}

	@Then("I should see a login error message {string}")
	public void iShouldSeeALoginErrorMessage(String expectedMessage) {
		logger.info("Verifying login error message: {}", expectedMessage);
		String actualMessage = loginPage.getErrorMessage();
		Assert.assertEquals(expectedMessage, actualMessage);
		logger.info("Error message verified successfully");
	}

	@Given("I am logged in as a valid user")
	public void iAmLoggedInAsAValidUser() {
		iAmOnTheSwagLabsLoginPage();
		iEnterUsernameAndPassword("standard_user", "secret_sauce");
		iClickTheLoginButton();
		iShouldBeRedirectedToTheProductsPage();
	}

	@Given("I attempt login with invalid user")
	public void iAmLoggedInAsAnInvalidUser() {
		iAmOnTheSwagLabsLoginPage();
		iEnterUsernameAndPassword("invalid_user", "invalid_password");
		iClickTheLoginButton();
		iShouldSeeALoginErrorMessage("Epic sadface: Username and password do not match any user in this service");;
	}

	@Given("I attempt login with locked out user")
	public void iAmLoggedInAsALockedOutUser() {
		iAmOnTheSwagLabsLoginPage();
		iEnterUsernameAndPassword("locked_out_user", "secret_sauce");
		iClickTheLoginButton();
		iShouldSeeALoginErrorMessage("Epic sadface: Sorry, this user has been locked out.");
	}

	@When("I click the menu button")
	public void iClickTheMenuButton() {
		logger.info("Clicking the menu button");
		productsPage.clickMenuButton();
	}

	@And("I select {string}")
	public void iSelect(String option) {
		logger.info("Selecting option: {}", option);
		productsPage.selectMenuOption(option);
	}

	@Then("I should be redirected to the login page")
	public void iShouldBeRedirectedToTheLoginPage() {
		logger.info("Verifying redirection to the login page");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
		logger.info("Successfully redirected to the login page");
	}
}