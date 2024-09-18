package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {

	private static final Logger logger = LogManager.getLogger(ProductDetailsPage.class);
	private WebDriver browser;

	private By productTitle = By.cssSelector("[data-test='inventory-item-name']");
	private By productDescriptionLocator = By.cssSelector("[data-test='inventory-item-desc']");
	private By backButton = By.id("back-to-products");

	public ProductDetailsPage(WebDriver browser) {
		this.browser = browser;
	}

	public String getProductName() {
		logger.info("Getting product name from product details page");
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
		String productName = browser.findElement(productTitle).getText();
		logger.info("Product name on details page: {}", productName);
		return productName;
	}

	public String getProductDescription() {
		logger.info("Getting product description from product details page");
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(productDescriptionLocator));
		String productDescription = browser.findElement(productDescriptionLocator).getText();
		logger.info("Product description: {}", productDescription);
		return productDescription;
	}

	public void clickBackButton() {
		logger.info("Clicking the back button on product details page");
		browser.findElement(backButton).click();
	}
}