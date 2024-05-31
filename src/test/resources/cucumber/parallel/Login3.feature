@FeatureLogin3
Feature: Feature Login 3

  Scenario: Scenario Number One
    Given User in login page
    When User input username "cc" and password "cc"
    And User click login button
    Then User will see login error message "Enter a valid email and password"