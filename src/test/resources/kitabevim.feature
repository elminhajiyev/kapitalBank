@books
Feature: Add to Random book to basket
  Scenario: Random book to basket
    Given Go to "https://kitabevim.az"
    When Check homepage is open
    Then Read data from csv file
    Then Fill search field with csv data
    Then Insert Roman to search field
    And Get value from basket count
    And Select random result
    And Add to basket
    And Check basket value again
    And The basket icon is hovered on
    And Goto Basket
    And The amount of the product is increased by "1"
    And Click the refresh basket button
    And It is checked whether the message is displayed
    And Clear Basket
    Then Verify basket is empty
