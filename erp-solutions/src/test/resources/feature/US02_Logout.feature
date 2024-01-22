@logout
Feature: As a user, I should be able to log out.

  Scenario: Validate user can logout
    Given user is logged in
    When user clicks on logout button
    Then validate user is on the login page