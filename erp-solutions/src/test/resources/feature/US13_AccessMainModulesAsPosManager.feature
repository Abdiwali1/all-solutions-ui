@mainModule @posmanager
Feature: As a POS manager,  I should be able to access the main modules.

@me
  Scenario Outline:
    When user logs in as "<userType>"
    Then user should be able to access <count> modules
    Examples:
      | userType          | count |
      | pos_manager       | 19    |
      | sales_manager     | 25    |
      | crm_manager       | 16    |
      | inventory_manager | 16    |
      | expenses_manager  | 9    |