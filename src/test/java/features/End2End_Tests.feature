Feature: OrangeHRM User Management

  Scenario: Add a new user to the system
    Given User navigates to OrangeHRM
    When User logs in with "Admin" and "admin123"
    And User clicks on Admin tab
    And User clicks on Add button and fills the details with "Flairs-tech", "password123", "password123", "a"
    

    Given User navigates to OrangeHRM
    When User logs in with "Admin" and "admin123"
    And User clicks on Admin tab
    And User searches for the new user with "Flairs-tech"
    And User deletes the newly added user
 