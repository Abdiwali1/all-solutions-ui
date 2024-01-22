Feature: As a user, I want to create a recurring (repetitive) calendar event

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline:Verify that <userType> see the number “1” by default in the Repeat Every input option.
    When the user logged in as "<userType>"
    And the user navigates to "Activities" to "Calendar Events"
    And the user waits 5 seconds
    And the user clicks create calendar event
    And the user checks Repeat checkbox
    Then the user should be able to see the number 1 by default in the Repeat Every input option
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |


  Scenario Outline:Verify that <userType> see the error message "This value should not be blank." when the Calendar event
  Repeat Every field is cleared (delete the number 1).
    When the user logged in as "<userType>"
    And the user navigates to "Activities" to "Calendar Events"
    And the user waits 5 seconds
    And the user clicks create calendar event
    And the user checks Repeat checkbox
    And the user delete the default value Calendar event Repeat Every field
    Then the user should be able to see the error message as "This value should not be blank."
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |

