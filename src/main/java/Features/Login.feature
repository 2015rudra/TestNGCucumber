Feature: Check Login functionality

Scenario: Verify Login Functionality

Given user launch browser
Then user is on login page
Then user logs into application
Then validate logged in username is displayed
Then user closes browser