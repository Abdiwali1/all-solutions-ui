Feature: As a user, I want to learn how to use the pinbar.


  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: Verify that when users click the “Learn how to use this space” link on the  homepage,
  "How To Use Pinbar" and "Use the pin icon on the right top corner of page to create fast access link in the pinbar."
    When the user logged in as "<userType>"
    And the user clicks the pinbar link
    Then the user should be able to see title on home page as "How To Use Pinbar"
    And the user should be able to see explanation on home page as "Use pin icon on the right top corner of page to create fast access link in the pinbar."

    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver




  Scenario Outline: Verify that users see an image on the page.
    When the user logged in as "<userType>"
    And the user clicks the pinbar link
    Then the user should be able to see the image with source "/bundles/oronavigation/images/pinbar-location.jpg" on the help page
    Examples:
      | userType      |
      | Store Manager |
      | Sales Manager |
      | Driver  |