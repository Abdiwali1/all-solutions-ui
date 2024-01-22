Feature: As a user, I want to view columns on the Vehicles Model page.


  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify that <userType>s can access the Vehicle Contracts page.
    When the user logged in as "<userType>"
    And the user navigates to "Fleet" to "Vehicles Model"
    Then the user should be able to see below column names
      | MODEL NAME               |
      | MAKE                     |
      | CAN BE REQUESTED         |
      | CVVI                     |
      | CO2 FEE (/MONTH)         |
      | COST (DEPRECIATED)       |
      | TOTAL COST (DEPRECIATED) |
      | CO2 EMISSIONS            |
      | FUEL TYPE                |
      | VENDORS                  |

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |



  Scenario: Verify that Drivers cannot access the Vehicles Model page and see “You do not have permission to perform this action.” message on the screen.
    When the user logged in as "driver"
    And the user navigates to "Fleet" to "Vehicles Model"
    Then the user should be able to see message as "You do not have permission to perform this action."
