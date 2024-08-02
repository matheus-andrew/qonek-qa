@Feature @Feature-Additional
Feature: Get Texting - Contact List

  @Scenario-23
  Scenario: User melakukan close session pada beberapa chatroom/contact secara sekaligus
    Given User already login
    And Upload contacts needed
    And User in inbox page
    And Start new chat "62811375866, Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
    And Start new chat "628175000557, Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
    When User click button 'Check' on chatbox sidebar
    And User check Chatroom from contact "62811375866,628175000557"
    And User click button 'More' on chatbox sidebar
    And User choose 'Closed Session Selected'
    Then Show pop-up Closed Session Selected
    When User click button Yes, Sure on confirmation pop-up
    Then User open Chatroom "62811375866" from contact "6282213288475"
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended    | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | Close Session  |
    Then User open Chatroom "628175000557" from contact "6282213288475"
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended    | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | Close Session  |

  @Scenario-63
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data dan terdapat data contact number yang sama (Skip)
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

  @Scenario-64
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data dan terdapat data contact number yang sama (Overwrite)
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

  @Scenario-65
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data dan terdapat data contact number yang sama (Merge Data)
    Given User already login with account "uattesting@gmail.com" and password "Password123@"
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template 1000 Overwrite into pop-up Import File
    When User click button Submit
    Then User see pop-up Skip or Overwrite
    When user click action "merge" on pop-up
    And User click button Submit Next

  @Scenario-78
  Scenario: User menghapus pesan yang telah dikirim
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "62811375866 - 62811375866" chatting with "6282213288475 - Julia"
    And User click field input chat dan type "This message will be deleted"
    And User click button 'Send'
    Then Message "This message will be deleted" from user "qa-matt@gmail.com" will be send
    When User do hover on last bubble chat and click dropdown
    And User click delete message
    Then User will see pop-up Delete one chat confirmation
    And User click button Delete Message on confirmation pop-up
    Then Message "You deleted this message." from user "qa-matt@gmail.com" will be send
