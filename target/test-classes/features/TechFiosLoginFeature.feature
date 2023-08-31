Feature: TechFios login functionality validation

Background:
Given User is on techfios login page

@Scenario1
Scenario: User should be able to login with valid credentials
When User enters username as "demo@techfios.com"
When User enters password as "abc123"
And User clicks on signin button
Then User should land on Dashboard page
