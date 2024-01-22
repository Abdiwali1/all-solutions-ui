@repairs
Feature: As a POS manager & Sales manager, I want to access the Repairs page


  Scenario Outline: Verify there are 6 columns to see the repair orders on the Repairs page
    Given user is on the login page
    When user logs in as "<userType>"
    When user clicks "Repairs" button
    Then User should be able to see 6 columns of the quotations
    When User enters "<Repair Reference Number>" on the SearchBox
    Then User should be able to see the result on the list with the "<Repair Reference Number>"

    Examples:
      | userType      |  | Repair Reference Number |
      | pos_manager   |  | RMA/00246               |
      | sales_manager |  | RMA/00230               |