Feature: As a POS Manager, I should be able to view product orders.

  Scenario:
    Given user logs in as "pos_manager"
    When user clicks "Point of Sale" button
    And user clicks "Orders" button
    And user clicks "Order Ref Checkbox" button
    Then All the checkboxes should be checked
    And User should be able to see below options
      | Import |
      | Export |
      | Delete |







