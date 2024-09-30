package org.example.steps;

import io.cucumber.java.en.*;
import org.example.pages.ProductDetailsPage;
import org.example.pages.ProductsPage;
import org.example.utils.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CatalogSteps {

	private static final Logger logger = LogManager.getLogger(CatalogSteps.class);
	private WebDriver browser = WebDriverManager.getBrowser();
	private ProductsPage productsPage = new ProductsPage(browser);
	private ProductDetailsPage productDetailsPage = new ProductDetailsPage(browser);

	@Given("I am on the products page")
	public void iAmOnTheProductsPage() {
		logger.info("Verifying that we are on the products page");
		Assert.assertTrue(productsPage.isProductsTitleDisplayed(), "Products page is not displayed");
		logger.info("Products page is displayed");
	}

	@When("I add the product {string} to the cart")
	public void iAddTheProductToTheCart(String productName) {
		logger.info("Adding product {} to the cart", productName);
		productsPage.addProductToCart(productName);
		logger.info("Product {} added to the cart", productName);
	}

	@Then("the cart icon should display {string}")
	public void theCartIconShouldDisplay(String expectedCount) {
		logger.info("Verifying cart icon displays {}", expectedCount);
		String actualCount = productsPage.getCartItemCount();
		Assert.assertEquals(expectedCount, actualCount);
		logger.info("Cart icon displays {}", actualCount);
	}

	@Given("I have added the product {string} to the cart")
	public void iHaveAddedTheProductToTheCart(String productName) {
		iAmOnTheProductsPage();
		iAddTheProductToTheCart(productName);
	}

	@When("I click on the product {string}")
	public void iClickOnTheProduct(String productName) {
		logger.info("Clicking on product {}", productName);
		productsPage.clickOnProduct(productName);
	}

	@Then("I should see the product details page for {string}")
	public void iShouldSeeTheProductDetailsPageFor(String productName) {
		logger.info("Verifying product details page for {}", productName);
		Assert.assertEquals(productDetailsPage.getProductName(), productName, "Product name does not match");
		logger.info("Product details page for {} is displayed", productName);
	}

	@Then("I should see the product description {string}")
	public void iShouldSeeTheProductDescription(String expectedDescription) {
		logger.info("Verifying product description");
		String actualDescription = productDetailsPage.getProductDescription();
		Assert.assertEquals(actualDescription, expectedDescription, "Product description does not match");
		logger.info("Product description is correct");
	}

	@And("I click the back button")
	public void iClickTheBackButton() {
		logger.info("Clicking the back button on product details page");
		productDetailsPage.clickBackButton();
	}
}
