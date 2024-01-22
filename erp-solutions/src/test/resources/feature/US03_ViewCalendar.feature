@calendar
Feature: As a user, I want to see the calendar page as daily, weekly (as a default) and monthly.

  Background: User is on the login page
    Given user is on the login page


  Scenario Outline:Verify users see the calendar as a daily
    When user logs in as "<userType>"
    Then User should see "<account_Name>" on the page
    When User clicks on calendar module
    Then User should be able to see Day module
    When User clicks on Day module
    Then User should be able to see Day header
    And User should be able to see time column

    Examples:
      | userType          | account_Name       |
      | pos_manager       | POSManager50       |
      | sales_manager     | SalesManager6      |
      | crm_manager       | EventsCRMManager10 |
      | inventory_manager | InventoryManager11 |
      | expenses_manager  | ExpensesManager10  |


  Scenario Outline:Verify users see the calendar as a weekly
    When user logs in as "<userType>"
    Then User should see "<account_Name>" on the page
    When User clicks on calendar module
    Then User should be able to see Week module
    And User should be able to see Days of the Week
    And User should be able to see time column

    Examples:
      | userType          | account_Name       |
      | pos_manager       | POSManager50       |
      | sales_manager     | SalesManager6      |
      | crm_manager       | EventsCRMManager10 |
      | inventory_manager | InventoryManager11 |
      | expenses_manager  | ExpensesManager10  |


  Scenario Outline:Verify users see the calendar as a monthly
    When user logs in as "<userType>"
    Then User should see "<account_Name>" on the page
    When User clicks on calendar module
    Then User should be able to see Month module
    When  User clicks on Month module
    Then User should be able to see Days of the month
    And User should be able to see Dates of the month in a table

    Examples:
      | userType          | account_Name       |
      | pos_manager       | POSManager50       |
      | sales_manager     | SalesManager6      |
      | crm_manager       | EventsCRMManager10 |
      | inventory_manager | InventoryManager11 |
      | expenses_manager  | ExpensesManager10  |