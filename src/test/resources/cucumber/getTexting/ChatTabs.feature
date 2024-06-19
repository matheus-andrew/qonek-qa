@Feature
Feature: Get Texting - Chat Tabs

  @Scenario-27
  Scenario: Create New Chat tabs
    Given User already login
    And User in inbox page
    When User click button Add New Chat Tabs
    And User click and type "Achmad Ongoing" on form Chat Tabs Name
    And User tick session "OnGoing"
    And User choose "qa-matt@gmail.com" on form User Name
    And User click button 'Create Chat Tabs'
    And On Chat Tabs will added new tab "Achmad Ongoing"

  @Scenario-28
  Scenario: Membuka Chat Tab yang telah dibuat sebelumnya
    Given User already login
    And User in inbox page
    When User click button Add New Chat Tabs
    And User click and type "Achmad Ongoing" on form Chat Tabs Name
    And User tick session "OnGoing"
    And User choose "qa-matt@gmail.com" on form User Name
    And User click button 'Create Chat Tabs'
    And On Chat Tabs will added new tab "Achmad Ongoing"
    When User click tab "Achmad Ongoing"
    Then Chatroom on chatbox will be filtered and showed 'Chat Tab Results' with button 'Close'

  @Scenario-29
  Scenario: Mengedit Chat Tabs yang sudah dibuat
    Given User already login
    And User in inbox page
    And On Chat Tabs will added new tab "Achmad Ongoing"
    When User click tab "Achmad Ongoing" dropdown
    And User click button Edit chat tabs
    And User click and type "Achmad Expired" on form Chat Tabs Name
    And User tick session "Expired"
    And User click button 'Save Chat Tabs'
    And On Chat Tabs will added new tab "Achmad Expired"

  @Scenario-30
  Scenario: Membuka Chat Tabs yang telah diedit
    Given User already login
    And User in inbox page
    And On Chat Tabs will added new tab "Achmad Expired"
    When User click tab "Achmad Expired"
    Then Chatroom on chatbox will be filtered and showed 'Chat Tab Results' with button 'Close'

  @Scenario-31
  Scenario: Menghapus Chat Tabs yang sudah dibuat
    Given User already login
    And User in inbox page
    And On Chat Tabs will added new tab "Achmad Expired"
    When User click tab "Achmad Expired" dropdown
    And User click button Delete chat tabs
    And On Chat Tabs will no longer show tab "Achmad Expired"