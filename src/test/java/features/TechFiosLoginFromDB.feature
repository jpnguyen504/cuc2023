
Feature: TechFios login functionality validation

Background:
Given User is on techfios login page

@DBScenario1
Scenario: User should be able to login with valid credentials
When User enters username from database
When User enters password from database
And User clicks on signin button
Then User should land on Dashboard page