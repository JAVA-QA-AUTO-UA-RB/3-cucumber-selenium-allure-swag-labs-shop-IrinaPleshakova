package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

	private static final Logger logger = LogManager.getLogger(CartPage.class);
	private WebDriver browser;

	private By checkoutButton = By.id("checkout");

	public CartPage(WebDriver browser) {
		this.browser = browser;
	}

	public void clickCheckoutButton() {
		logger.info("Clicking checkout button");
		browser.findElement(checkoutButton).click();
	}

	public void removeProductFromCart(String productName) {
		logger.info("Removing product {} from cart", productName);
		String productId = productName.toLowerCase().replaceAll("\\s+", "-");
		By removeButton = By.id("remove-" + productId);
		browser.findElement(removeButton).click();
		logger.info("Product {} removed from cart", productName);
	}

	public boolean isCartEmpty() {
		By cartItems = By.cssSelector(".cart_item");
		List<WebElement> items = browser.findElements(cartItems);
		boolean isEmpty = items.isEmpty();
		logger.info("Cart empty status: {}", isEmpty);
		return isEmpty;
	}
}