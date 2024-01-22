@login
Feature: As a user, I should be able to Login.
  (There are 5 types of users, POS Manager, Sales Manager, CRM Manager, Inventory Manager, Expenses Manager)


  Background: User is on the login page
    Given user is on the login page


  Scenario Outline: Verify login with different user types
    When user logs in as "<userType>"
    Then user should see "Odoo" in page title
    Examples:
      | userType          |
      | pos_manager       |
      | sales_manager     |
      | crm_manager       |
      | inventory_manager |
      | expenses_manager  |


  Scenario Outline: Verify login with invalid credentials
    When user logs in with invalid "<username>","<password>"
    Then user should see error message "Wrong login/password"
    Examples:
      | username             | password      |
      | posmanager5@info.com | wrongPassword |
      | wrong@UserName.com   | posmanager    |



  Scenario Outline: Verify login with one empty field
    When user logs in with one empty field "<username>","<password>"
    Then user should see alert message "Please fill out this field."
    Examples:
      | username             | password   |
      | posmanager5@info.com |            |
      |                      | posmanager |
