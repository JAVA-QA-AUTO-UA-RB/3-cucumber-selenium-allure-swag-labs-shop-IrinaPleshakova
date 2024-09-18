# Додайте сюди сценарії які перевіряють так званий Checkout Flow, тобто процес оформлення замовлення
  # Вхідною точкою можна вважати момент, коли в корзину додано хоча б один товар, вихідна точка - оформлене замовлення
  # Приклади - можна купити один окремий товар, можна купити декілька товарів в одноиму замовленні
  # Можна додавати і видаляти товари з корзини
  # При успішному оформленні замовлення має відображатися повідомлення про успішне оформлення і т.п.

Feature: Swag Labs Checkout Process

  Background:
    Given I am logged in as a valid user

  Scenario: Successful checkout with valid information
    Given I have added the following products to the cart:
      | Product Name            |
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    And I click on the shopping cart icon
    And I proceed to checkout
    When I enter valid checkout information:
      | First Name  | Last Name  | Postal Code |
      | Irina       | Pleshakova | 12345       |
    And I finish the checkout process
    Then I should see a confirmation message "Thank you for your order!"

  Scenario: Checkout fails with missing first name
    Given I have added a product to the cart
    And I proceed to checkout
    When I leave the first name field empty
    And I enter last name "Pleshakova" and postal code "12345"
    And I click the continue button
    Then I should see a checkout error message "Error: First Name is required"

  Scenario: Remove a product from the cart during checkout
    Given I have added the product "Sauce Labs Backpack" to the cart
    And I click on the shopping cart icon
    When I remove the product "Sauce Labs Backpack" from the cart
    Then the cart should be empty