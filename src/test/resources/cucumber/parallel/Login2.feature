@FeatureLogin2
Feature: Feature Login 2

  Scenario: Scenario Number One
    Given User in login page
    When User input username "bb" and password "bb"
    And User click login button
    Then User will see login error message "Enter a valid email and password"