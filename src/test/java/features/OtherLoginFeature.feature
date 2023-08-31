Feature: TechFios login functionality validation

Background:
Given User is on techfios login page

@OtherScenario1
Scenario Outline: User should be able to login with valid credentials
When User enters username as "<username>"
When User enters password as "<password>"
And User clicks on signin button
Then User should land on Dashboard page

Examples: 
|username|password|
|demo@techfios.com|abc123|
|demo1@techfios.com|abc123|
|demo@techfios.com|abc124|
|demo1@techfios.com|abc124|