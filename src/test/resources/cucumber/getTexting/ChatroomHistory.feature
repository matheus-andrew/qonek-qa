@Feature
Feature: Get Texting - Chatroom History

  @Scenario-32
  Scenario: Open Chatroom History
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Chatroom History' on Detail Chat Session panel
    Then Chatroom History will be opened
    And Chatroom History have input search, button Filter, and button Sort by Date
    And Chatroom History have box Chat Session ID with status "Expired"
    And Chatroom History have box Chat Session ID with status "Close Session"

  @Scenario-33
  Scenario: Open Chat Session History
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Chatroom History' on Detail Chat Session panel
    Then Chatroom History will be opened
    And Chatroom History have box Chat Session ID with status "Expired"
    When User click box Chat Session ID with status "Expired"
    Then Chatroom Session History will be opened
    And Will shows pop-up Chat Session ID "Expired"
    And Chatroom Session History have information
      | Contact    | Room Created       | Whatsapp Number        | User Name         | Session Created    | Session Ended      |
      | rahmadhany | MM/dd/yyyy - HH.mm | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy - HH.mm | MM/dd/yyyy - HH.mm |

  @Scenario-34
  Scenario: Klik button Sort by Date
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Chatroom History' on Detail Chat Session panel
    And User click button Sort by Date
    Then Chatroom History will be sorted by Date

  @Scenario-41
  Scenario: Melakukan Filter pada Chatroom History
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Chatroom History' on Detail Chat Session panel
    Then Chatroom History will be opened
    And Chatroom History have box Chat Session ID with status "Expired"
    And Chatroom History have box Chat Session ID with status "Close Session"
    When User click button Filter on Chatroom History
    And User tick session "Closed" on Chatroom History
    And User click button 'Apply Filter' on Chatroom History
    Then Chatroom History will be filtered and showed 'Filter Results' with button 'Reset Filter'
    And Chatroom History have box Chat Session ID with status "Close Session"

  @Scenario-42
  Scenario: Menutup panel Chatroom History
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Chatroom History' on Detail Chat Session panel
    Then Chatroom History will be opened
    When User click button Back on Chatroom History
    Then Chatroom History will be closed and redirect to Detail Chat Session
