Feature: As a user, I want to manage filters on the Marketing page.

  Background: User is already in the log in page
    Given the user is on the login page

  @wip
  Scenario Outline: Verify that <userType> managers see all 5 filter options as checked by default.
    When the user logged in as "<userType>"
    And the user waits 2 seconds
    And the user navigates to "Marketing" to "Campaigns"
    And the user waits 5 seconds
    And  the user clicks the filter icon
    And  the user clicks manage filters button
    Then the user should be able to see all 5 filter options as checked by default

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |


  @wip
  Scenario Outline: Verify that any amount of boxes can be unchecked.
    When the user logged in as "<userType>"
    And the user waits 2 seconds
    And the user navigates to "Marketing" to "Campaigns"
    And the user waits 5 seconds
    And  the user clicks the filter icon
    And  the user clicks manage filters button
    And the user waits 3 seconds
    Then the user should be able to uncheck filter options

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |


