package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.example.pages.*;
import org.example.utils.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {

	private static final Logger logger = LogManager.getLogger(CheckoutSteps.class);
	private WebDriver browser = WebDriverManager.getBrowser();
	private ProductsPage productsPage = new ProductsPage(browser);
	private CartPage cartPage = new CartPage(browser);
	private CheckoutPage checkoutPage = new CheckoutPage(browser);
	private OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(browser);

	@Given("I have added the following products to the cart:")
	public void iHaveAddedTheFollowingProductsToTheCart(DataTable dataTable) {
		List<Map<String, String>> productList = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> product : productList) {
			String productName = product.get("Product Name");
			logger.info("Adding product {} to the cart", productName);
			productsPage.addProductToCart(productName);
		}
		productsPage.clickCartIcon();
		logger.info("Navigated to cart page");
	}

	@Given("I have added a product to the cart")
	public void iHaveAddedAProductToTheCart() {
		logger.info("Adding default product to the cart");
		productsPage.addProductToCart("Sauce Labs Backpack");
		productsPage.clickCartIcon();
		logger.info("Navigated to cart page");
	}

	@And("I proceed to checkout")
	public void iProceedToCheckout() {
		logger.info("Proceeding to checkout");
		cartPage.clickCheckoutButton();
	}

	@When("I enter valid checkout information:")
	public void iEnterValidCheckoutInformation(DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps(String.class, String.class).get(0);
		logger.info("Entering checkout information: {}", data);
		checkoutPage.enterFirstName(data.get("First Name"));
		checkoutPage.enterLastName(data.get("Last Name"));
		checkoutPage.enterPostalCode(data.get("Postal Code"));
		checkoutPage.clickContinueButton();
		logger.info("Checkout information entered");
	}

	@When("I leave the first name field empty")
	public void iLeaveTheFirstNameFieldEmpty() {
		logger.info("Leaving first name field empty");
		checkoutPage.enterFirstName("");
	}

	@When("I enter last name {string} and postal code {string}")
	public void iEnterLastNameAndPostalCode(String lastName, String postalCode) {
		logger.info("Entering last name: {} and postal code: {}", lastName, postalCode);
		checkoutPage.enterLastName(lastName);
		checkoutPage.enterPostalCode(postalCode);
	}

	@And("I click the continue button")
	public void iClickTheContinueButton() {
		logger.info("Clicking the continue button");
		checkoutPage.clickContinueButton();
	}

	@Then("I should see a checkout error message {string}")
	public void iShouldSeeACheckoutErrorMessage(String expectedMessage) {
		logger.info("Verifying checkout error message: {}", expectedMessage);
		String actualMessage = checkoutPage.getErrorMessage();
		Assert.assertEquals(expectedMessage, actualMessage);
		logger.info("Checkout error message verified successfully");
	}

	@When("I finish the checkout process")
	public void iFinishTheCheckoutProcess() {
		logger.info("Finishing the checkout process");
		checkoutPage.clickFinishButton();
	}

	@Then("I should see a confirmation message {string}")
	public void iShouldSeeAConfirmationMessage(String expectedMessage) {
		logger.info("Verifying confirmation message: {}", expectedMessage);
		String actualMessage = orderConfirmationPage.getConfirmationMessage();
		Assert.assertEquals(expectedMessage, actualMessage, "Confirmation message doesn't match!");
		logger.info("Order confirmation verified successfully");
	}

	@When("I remove the product {string} from the cart")
	public void iRemoveTheProductFromTheCart(String productName) {
		logger.info("Removing product {} from the cart during checkout", productName);
		cartPage.removeProductFromCart(productName);
		logger.info("Product {} removed from the cart", productName);
	}

	@Then("the cart should be empty")
	public void theCartShouldBeEmpty() {
		logger.info("Verifying that the cart is empty");
		boolean isCartEmpty = cartPage.isCartEmpty();
		Assert.assertTrue(isCartEmpty, "The cart is not empty");
		logger.info("Cart is empty as expected");
	}

	@And("I click on the shopping cart icon")
	public void iClickOnTheShoppingCartIcon() {
		logger.info("Clicking on the shopping cart icon");
		ProductsPage productsPage = new ProductsPage(browser);
		productsPage.clickCartIcon();
		logger.info("Navigated to the shopping cart page");
	}
}