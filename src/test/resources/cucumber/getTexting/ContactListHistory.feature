@Feature @Feature-ContactListHistory
Feature: Get Texting - Contact List History

  @Scenario-74
  Scenario: Membuka Contact List History setelah melakukan Chatting dengan beberapa Contact
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click menu Contact History
    Then User will be redirected to page Contact List History
    And Will shows table Contact List History
    And Will shows session id for every activity inside Chat Session
    And Will not shows session id for every activity outside Chat Session

  @Scenario-75
  Scenario: Menggunakan fungsi input search
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click menu Contact History
    Then User will be redirected to page Contact List History
    When User type "Chat Session" on field input search Contact List History page
    Then Table Contact List History will be filtered with blue highlighted
    When User click icon X on field input search on Contact List History page

  @Scenario-76
  Scenario: Melakukan export table Contact List History
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click menu Contact History
    Then User will be redirected to page Contact List History
    When User click button Export Table
    And User click button Yes, Im Sure on Export Table Confirmation
    Then Contact List History table will be exported to excel format

  @Scenario-77
  Scenario: Melakukan filter by column dan export table Contact List History
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click menu Contact History
    Then User will be redirected to page Contact List History
    When User click icon filter SessionID on Contact History page
    And User click expand Filter by Value "SessionID"
    And On field filter by value tick only one
    And User click button Set Filter on pop-up filter
#    to close popup filter
    When User click icon filter SessionID on Contact History page
#    end
    When User click button Export Table
    And User click button Yes, Im Sure on Export Table Confirmation
    Then Contact List History table will be exported to excel format
