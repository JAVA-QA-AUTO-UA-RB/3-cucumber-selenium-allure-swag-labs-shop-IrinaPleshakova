package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckoutPage {

	private static final Logger logger = LogManager.getLogger(CheckoutPage.class);
	private WebDriver browser;

	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By postalCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By finishButton = By.id("finish");
	private By errorMessage = By.cssSelector("[data-test='error']");

	public CheckoutPage(WebDriver browser) {
		this.browser = browser;
	}

	public void enterFirstName(String firstName) {
		logger.info("Entering first name: {}", firstName);
		browser.findElement(firstNameField).clear();
		browser.findElement(firstNameField).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		logger.info("Entering last name: {}", lastName);
		browser.findElement(lastNameField).clear();
		browser.findElement(lastNameField).sendKeys(lastName);
	}

	public void enterPostalCode(String postalCode) {
		logger.info("Entering postal code: {}", postalCode);
		browser.findElement(postalCodeField).clear();
		browser.findElement(postalCodeField).sendKeys(postalCode);
	}

	public void clickContinueButton() {
		logger.info("Clicking continue button");
		browser.findElement(continueButton).click();
	}

	public void clickFinishButton() {
		logger.info("Clicking finish button");
		browser.findElement(finishButton).click();
	}

	public String getErrorMessage() {
		String message = browser.findElement(errorMessage).getText();
		logger.info("Error message: {}", message);
		return message;
	}
}