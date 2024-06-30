Feature: Checkout

  Scenario: Checkout two items
    Given user login with valid username and password
    And user add to cart first item
    And user add to cart second item
    And user click on cart button
    And user click on checkout button
    And user input first name last name and postal code
    And user click on continue button
    When user click on finish button
    Then user is on complete page