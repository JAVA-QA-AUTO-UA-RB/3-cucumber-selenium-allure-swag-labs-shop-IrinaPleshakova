package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {

	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	private WebDriver browser;

	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("[data-test='error']");

	public LoginPage(WebDriver browser) {
		this.browser = browser;
	}

	public boolean isLoginButtonDisplayed() {
		return browser.findElement(loginButton).isDisplayed();
	}

	public void enterUsername(String username) {
		logger.info("Entering username: {}", username);
		browser.findElement(usernameField).clear();
		browser.findElement(usernameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		logger.info("Entering password");
		browser.findElement(passwordField).clear();
		browser.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		logger.info("Clicking login button");
		browser.findElement(loginButton).click();
	}

	public String getErrorMessage() {
		String message = browser.findElement(errorMessage).getText();
		logger.info("Error message: {}", message);
		return message;
	}
}