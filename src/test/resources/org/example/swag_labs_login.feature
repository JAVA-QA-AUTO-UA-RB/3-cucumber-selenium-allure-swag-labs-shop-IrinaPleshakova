#Feature: Swag Labs User Login

#  Scenario: Log in with correct credentials
#    Given I am somewhere
#    When I do something
#    Then something good has happened
#    And another expected thing has happened
#    But a thing we don't expect didn't happen

    # Перший сценарій дано як приклад
    # Допишіть сюди свої сценарії як відповідають фічі, що зараз тестується (можуть бути як позитивні так і негативні)
    # Приклади сценаріїв: логінізація з існуючим валідним користувачем, логінізація з кредами неіснуючого користувача,
    # логінізація з кредами користувача, який є заблокованим (locked_out_user)
  # Сюди має також увійти сценарії (вилогінювання/виходу/Log out) з сайту, бо ми маємо переконатися що при бажанні користувач може вийти

Feature: Swag Labs User Login and Logout

  Scenario: Successful login with valid credentials
    Given I am on the Swag Labs login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the Swag Labs login page
    When I enter username "invalid_user" and password "invalid_password"
    And I click the login button
    Then I should see a login error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login attempt with locked out user
    Given I am on the Swag Labs login page
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click the login button
    Then I should see a login error message "Epic sadface: Sorry, this user has been locked out."

  Scenario: Logout from the application
    Given I am logged in as a valid user
    When I click the menu button
    And I select "Logout"
    Then I should be redirected to the login page