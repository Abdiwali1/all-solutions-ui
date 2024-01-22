Feature: As a user, I want to see edit car info icons on the Vehicles page.


  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that "<userType>" see “view, edit, delete” options when they hover the mouse over the 3 dots "..."
    When the user logged in as "<userType>"
    And the user navigates to "Fleet" to "Vehicles"
    Then the user should be able to see options as "view,edit,delete"
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |