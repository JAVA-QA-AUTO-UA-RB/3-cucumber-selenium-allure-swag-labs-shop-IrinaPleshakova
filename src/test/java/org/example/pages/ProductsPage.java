package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

	private static final Logger logger = LogManager.getLogger(ProductsPage.class);
	private WebDriver browser;

	private By productsTitle = By.cssSelector(".title");
	private By cartIcon = By.id("shopping_cart_container");
	private By menuButton = By.id("react-burger-menu-btn");

	public ProductsPage(WebDriver browser) {
		this.browser = browser;
	}

	public boolean isProductsTitleDisplayed() {
		return browser.findElement(productsTitle).isDisplayed();
	}

	public void addProductToCart(String productName) {
		logger.info("Adding product {} to cart", productName);
		String productId = productName.toLowerCase().replaceAll("\\s+", "-");
		By addToCartButton = By.xpath("//button[contains(@data-test, 'add-to-cart-" + productId + "')]");
		browser.findElement(addToCartButton).click();
	}

	public String getCartItemCount() {
		try {
			return browser.findElement(By.className("shopping_cart_badge")).getText();
		} catch (Exception e) {
			return "0";
		}
	}

	public void clickCartIcon() {
		logger.info("Clicking on cart icon");
		browser.findElement(cartIcon).click();
	}

	public void clickOnProduct(String productName) {
		logger.info("Clicking on product {}", productName);
		By productLink = By.xpath("//div[@data-test='inventory-item-name' and text()='" + productName + "']");
		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(productLink));
		browser.findElement(productLink).click();
	}

	public void clickMenuButton() {
		logger.info("Clicking the menu button");
		browser.findElement(menuButton).click();
	}

	public void selectMenuOption(String option) {
		logger.info("Selecting menu option {}", option);

		WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
		By menuPanel = By.cssSelector(".bm-menu-wrap");
		wait.until(ExpectedConditions.attributeToBe(menuPanel, "aria-hidden", "false"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuPanel));
		logger.info("Burger menu is visible");

		switch (option.toLowerCase()) {
			case "logout":
				By logoutButton = By.id("logout_sidebar_link");
				wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
				browser.findElement(logoutButton).click();
				logger.info("Clicked on Logout button");
				break;
			case "about":
				By aboutButton = By.id("about_sidebar_link");
				wait.until(ExpectedConditions.elementToBeClickable(aboutButton));
				browser.findElement(aboutButton).click();
				logger.info("Clicked on About button");
				break;
			default:
				throw new IllegalArgumentException("Unknown option: " + option);
		}
	}
}