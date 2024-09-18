package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrderConfirmationPage {

	private static final Logger logger = LogManager.getLogger(OrderConfirmationPage.class);
	private WebDriver browser;

	private By confirmationMessage = By.className("complete-header");

	public OrderConfirmationPage(WebDriver browser) {
		this.browser = browser;
	}

	public String getConfirmationMessage() {
		String message = browser.findElement(confirmationMessage).getText();
		logger.info("Confirmation message: {}", message);
		return message;
	}
}