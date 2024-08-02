@Feature @Feature-UnansweredChat
Feature: Get Texting - Unanswered Chat

  @Scenario-43
  Scenario: Open Unanswered Chat
    Given User already login
    And User in inbox page
    And Check if there is any unanswered chat
    And Sidebar chat have button Unanswered Chat on bottom Chatbox panel
    When User click button Unanswered Chat
    Then Unanswered Chat panel will be shown
    And All chatroom will only shown Unanswered Chat
