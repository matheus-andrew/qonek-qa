@Feature @QA-163
Feature: Create New Chat Template

  @Scenario-1
  Scenario:  User click button Create New Template
    Given User already login
    And User in chat template page
    And User not yet have Chat Template previously and have "Create New Template" button
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    And Have 2 sides which is 'Editorial Template' and 'Preview Template'
    And Validate attributes on 'Editorial Template' form
    And Validate attributes on 'Preview Template' form

  @Scenario-2
  Scenario: User input template name
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User input template name with "Promo produk"
    Then Input form template name will be filled with "Promo produk"

  @Scenario-3
  Scenario: User input message in bubble chat 1
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click and type "Promo produk terbaru tahun ini" in form box Bubble Chat 1
    Then Box bubble chat 1 will be filled with message "Promo produk terbaru tahun ini"
    And On preview will show bubble chat 1 with message "Promo produk terbaru tahun ini"
    And Close pop up and delete chat template

  @Scenario-4
  Scenario: User add new bubble chat
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button Add Bubble Chat
    Then Will shows new bubble chat 2 on 'Editorial Template'
    And Close pop up and delete chat template

  @Scenario-5
  Scenario: User create message on bubble chat 2
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button Add Bubble Chat
    Then Will shows new bubble chat 2 on 'Editorial Template'
    When User click button 'Add File' on bubble chat 2
    And User click choose 'Image'
    And User upload image
    Then Chosen image will be added in bubble chat 2 box
    When User click and type "test" in form box Bubble Chat 1
    When User click and type "Image yang ditambahkan" in form box Bubble Chat 2
    Then Box bubble chat 2 will be filled with message "Image yang ditambahkan"
    And On preview will show bubble chat 2 with message "Image yang ditambahkan"
    And Close pop up and delete chat template

  @Scenario-6
  Scenario: User add text on bubble chat 2
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button Add Bubble Chat
    Then Will shows new bubble chat 2 on 'Editorial Template'
    When User click and type "test" in form box Bubble Chat 1
    When User click and type "Produk 1, potongan harga 20ribu" in form box Bubble Chat 2
    Then Box bubble chat 2 will be filled with message "Produk 1, potongan harga 20ribu"
    And On preview will show bubble chat 2 with message "Produk 1, potongan harga 20ribu"
    And Close pop up and delete chat template

  @Scenario-7
  Scenario: User change Template Hotkey
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click and type "Promo2024" on form Template Hotkey
    Then Input form Template Hotkey will be active and filled with "Promo2024"
    And Close pop up and delete chat template

  @Scenario-8
  Scenario: User click button Create Template
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User input template name with "Promo produk"
    When User click and type "test" in form box Bubble Chat 1
    When User click and type "Promo2024" on form Template Hotkey
    When User click button Create Template
    Then Pop-up will be closed
    And Template will be added in template table list with columns
#      | Template Name | Hotkey    | Created Time  | Guide Book  |
      | Promo produk  | Promo2024 | [today]       | -           |
    And On right side of table will have column button 'Edit' dan 'Delete'
    And User click Delete template on table list



