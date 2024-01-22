@documentation
Feature: As a user, I should be able to access the documentation page

  Scenario:Verify the “Odoo Documentation” message is displayed in a new window.
    Given user logs in as "pos_manager"
    When user lands on Odoo Documentations Page
    Then user should see "Odoo Documentation" in header
    And user should see below document topics
      | User Docs            |
      | Install and Maintain |
      | Developer            |
      | Contributing         |










