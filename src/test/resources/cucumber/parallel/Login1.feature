@FeatureLogin1
Feature: Feature Login 1

  Scenario: Scenario Number One
    Given User in login page
    When User input username "aa" and password "aa"
    And User click login button
    Then User will see login error message "Enter a valid email and password"