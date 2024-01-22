Feature: As a user, (Store and Sales managers) I want to manage filters on the Vehicle Costs page.

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that <userType> see 3 columns on the Vehicle Costs page.
    When the user logged in as "<userType>"
    And the user waits 2 seconds
    And the user navigates to "Fleet" to "Vehicle Costs"
    And the user waits 5 seconds
    Then the user should be able to see Vehicle Costs columns message as "TYPE,TOTAL PRICE,DATE"

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |



  Scenario Outline: Verify that <userType> can check the first checkbox to select All Vehicle Costs
    When the user logged in as "<userType>"
    And the user waits 2 seconds
    And the user navigates to "Fleet" to "Vehicle Costs"
    And the user waits 5 seconds
    And the user select the all cars
    Then the user should be able to see all the checkboxes as "checked"

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |


