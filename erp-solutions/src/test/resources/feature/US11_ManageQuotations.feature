@quotation
Feature: As POS & Sales Manager, I want to manage quotations on the Sales page.

  Scenario Outline: User selects all quotations on Sales page
    Given user logs in as "<userType>"
    When user clicks "Sales" button
    When user clicks "Quotation Number checkbox" button
    Then All the checkboxes should be checked
    Examples:
      | userType          |
      | pos_manager       |
      | sales_manager     |
   