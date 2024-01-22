@createUser
Feature: As a Sales Manager, I should be able to create a new customer from "Sales" module.

  Background: User logs in as Sales Manager
    Given user logs in as "sales_manager"

  Scenario: Create a new customer module
    When user clicks "Sales" button
    And user clicks "customer" button
    And user clicks "create" button
    And user writes his name on name box
    And user clicks "save" button
    Then user should see "Test" on product box



  Scenario: Verify any customer can be editable
    When user clicks "Sales" button
    And user clicks "customer" button
    And user clicks any customer module
    Then user able to click edit button


