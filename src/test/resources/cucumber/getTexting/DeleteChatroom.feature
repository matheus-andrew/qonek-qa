@Feature
Feature: Get Texting - Delete Chatroom

  @Scenario-44
  Scenario: User menghapus Chatroom
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And Start new chat "Rahmadhany, Julia"
    And The chatroom is handled by user "qa-matt@gmail.com"
    When User click button Delete on top left area chat
    And User click button Yes on confirmation pop-up
    Then Chatroom will be deleted from Chatbox

  @Scenario-45
  Scenario: User menghapus beberapa chatroom/contact secara sekaligus
    Given User already login
    And User in inbox page
    And Start new chat "Rahmadhany, Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
    When User click button 'Check' on chatbox sidebar
    And User check Chatroom from contact "6285259027122"
    And User click button Delete when checking contact
    And User click button Yes on confirmation pop-up
    Then Chatroom will be deleted from Chatbox
