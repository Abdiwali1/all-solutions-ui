Feature: As a user, I should see error messages when I enter an invalid integer number into the calendar Repeat Every input box.

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that <userType> see error messages when enter invalid integers.
  If enter less than 1 —> users should see "The value have not to be less than 1."
  If enter more than 99 —> users should see "The value have not to be more than 99."
    When the user logged in as "<userType>"
    And the user navigates to "Activities" to "Calendar Events"
    And the user waits 5 seconds
    And the user clicks create calendar event
    And the user checks Repeat checkbox
    And the user enter the value 134 Calendar event Repeat Every field
    Then the user should be able to see the error message as "The value have not to be more than 99."
    And the user enter the value -2 Calendar event Repeat Every field
    Then the user should be able to see the error message as "The value have not to be less than 1."
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |

