Feature: As a user, I want to filter customers’ info on the Accounts page.

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that <userType> see 8 filter items on the Accounts page
    When the user logged in as "<userType>"
    And the user waits 2 seconds
    And the user navigates to "Customers" to "Accounts"
    And the user waits 5 seconds
    And  the user clicks the filter icon
    Then the user should be able to see account columns message as "Account Name,Contact Name,Contact Email,Contact Phone,Owner,Business Unit,Created At,Updated At"

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |




