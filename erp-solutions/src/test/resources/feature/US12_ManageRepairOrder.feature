@repairs
Feature: As a POS & Sales Manager, I want to manage repair order on the Repairs page.

  Scenario Outline: Verify users can select all the repair orders by clicking the top checkbox.
    Given user logs in as "<userType>"
    When user clicks "Repairs" button
    When user clicks "Repair Reference checkbox" button
    Then All the checkboxes should be checked
    Examples:
      | userType          |
      | pos_manager       |
      | sales_manager     |