@calendar
Feature: As a POS Manager, I should be able to create events on my calendar from "Calendar" module


  Background: User is logged in
    Given user is logged in

  Scenario: User can create event by clicking on time box
    When user clicks "Calendar" button
    Then User should see "Meetings - Odoo" in the title
    When User clicks on desire time and day cell from the table
    Then User should see the pop-up window
    When User should be able to type in desire message
    And User clicks on create button
    Then User should be able to see created event in the calendar

  Scenario: User can see event details when clicking the event on the calendar.
    When User clicks on calendar module
    Then User should be able to see the event
    When User clicks on the event
    Then User should see new window was created
    And User should see the details about event



