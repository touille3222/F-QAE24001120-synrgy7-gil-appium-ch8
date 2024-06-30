Feature: Login

  Scenario: Login with valid username and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click on login button
    Then user is on home page

  Scenario: Login with invalid password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "wrong_pass"
    When user click on login button
    Then error message is showing up