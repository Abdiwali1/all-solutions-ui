Feature: As a user, I want to type into the Description field when I create a calendar event.
  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that <userType> can type messages in to the Description field on the Calendar Events page.

    When the user logged in as "<userType>"
    And the user navigates to "Activities" to "Calendar Events"
    And the user waits 5 seconds
    And the user clicks create calendar event
    And the user text into Description "Attend the daily"
    Then the user should be able to text
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver        |

