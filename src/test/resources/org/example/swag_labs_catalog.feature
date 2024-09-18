# Додайте сюди сценарії, які перевіряють сторінку зі списком товарів, а також сторінку з деталями товару
# Подумайте, які з них ви покрили б в першу чергу, що важливо користувачу інтенет-магазину? Що важливо власнику інтернет-магазину?

Feature: Product Catalog Functionality

  Background:
    Given I am logged in as a valid user

  Scenario: View product details
    When I click on the product "Sauce Labs Backpack"
    Then I should see the product details page for "Sauce Labs Backpack"

  Scenario: Add a product to the cart from the product details page
    When I add the product "Sauce Labs Backpack" to the cart
    Then the cart icon should display "1"

  Scenario: Navigate back to products list from product details
    When I click on the product "Sauce Labs Backpack"
    And I should see the product details page for "Sauce Labs Backpack"
    And I click the back button
    Then I should be redirected to the products page