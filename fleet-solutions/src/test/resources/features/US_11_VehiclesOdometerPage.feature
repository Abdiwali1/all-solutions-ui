Feature: As a user, I want to view car odometer info on the Vehicles Odometer page.
  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that Store and Sales managers see the error message “You do not have permission to perform this action.” when they click the Vehicle Odometer module.
    When the user logged in as "<userType>"
    And the user waits 5 seconds
    And the user navigates to "Fleet" to "Vehicle Odometer"
    And the user waits 5 seconds
    Then the user should be able to see message as "You do not have permission to perform this action."

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |




  Scenario: Verify that Drivers see the default page as 1.
    When the user logged in as "driver"
    And the user waits 5 seconds
    And the user navigates to "Fleet" to "Vehicle Odometer"
    And the user waits 5 seconds
    Then the user should be able to see the default page as 1



  Scenario: Verify that Drivers see the View Per Page as 25 by default.
    When the user logged in as "driver"
    And the user waits 5 seconds
    And the user navigates to "Fleet" to "Vehicle Odometer"
    And the user waits 5 seconds
    Then the user should be able to see the View Per Page as 25 by default

