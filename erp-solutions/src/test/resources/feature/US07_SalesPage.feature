@sales
Feature: As a POS & Sales Manager, I should be able to get correct information on the Sales page.

  Scenario Outline: Verify there are 6 columns to see the quotations on the Sales page when the POS managers login.
    Given user is on the login page
    When user logs in as "<userType>"
    When user clicks "Sales" button
    Then User should be able to see 6 columns of the quotations
    When User enters "<Quotation Number>" on the SearchBox
    Then User should be able to see the result on the list with the "<Quotation Number>"

    Examples:
      | userType      |  | Quotation Number |
      | pos_manager   |  | SO004            |
      | sales_manager |  | SO808            |



  
  