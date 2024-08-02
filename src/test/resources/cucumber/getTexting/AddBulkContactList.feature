@Feature @Feature-AddBulkContactList
Feature: Get Texting - Add Bulk Contact List

  @Scenario-67
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data
    Given User already login with account "uattesting@gmail.com" and password "Password123@"
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template 1000 into pop-up Import File
    And User click button Submit
    Then User see pop-up Skip or Overwrite
    When user click action "skip" on pop-up
    And User click button Submit Next

  @Scenario-68
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data dan terdapat data contact number yang sama
    Given User already login with account "uattesting@gmail.com" and password "Password123@"
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template 1000 Overwrite into pop-up Import File
    When User click button Submit
    Then User see pop-up Skip or Overwrite
    When user click action "overwrite" on pop-up
    And User click button Submit Next