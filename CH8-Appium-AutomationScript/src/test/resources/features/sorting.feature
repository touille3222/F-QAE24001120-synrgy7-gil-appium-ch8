Feature: Sorting

  Scenario: Sorting item low to high price
    Given user login with valid username and password
    And user click on filter button
    When user click on low to high button
    Then items are lined up in order of low price to high price