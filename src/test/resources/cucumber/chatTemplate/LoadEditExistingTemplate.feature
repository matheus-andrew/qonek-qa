@Feature @QA-276
Feature: Load & Edit Existing Template Edit Bubble Chat

  Background: User create chat template
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User input template name with "Promo produk"
    When User click button Add Bubble Chat
    When User click and type "Promo produk terbaru tahun ini" in form box Bubble Chat 1
    When User click and type "Produk 1, potongan harga 20ribu" in form box Bubble Chat 2
    When User click button 'Add File' on bubble chat 2
    And User click choose 'Image'
    And User upload image
    Then Chosen image will be added in bubble chat 2 box
    When User click and type "Promo2024" on form Template Hotkey
    When User click button Create Template
    Then Pop-up will be closed
    And Template will be added in template table list with columns
    #      | Template Name | Hotkey    | Created Time  | Guide Book  |
      | Promo produk  | Promo2024 | [today]       | -           |
    And On right side of table will have column button 'Edit' dan 'Delete'

  @Scenario-9
  Scenario:  User load template which previously created
    Given  User already created chat template "Promo produk"
    And User see button “New Template” on top right page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    And Have 2 sides which is 'Editorial Template' and 'Preview Template'
    And Validate attributes on 'Editorial Template' form
    And Validate attributes on 'Preview Template' form
    And Close pop up and delete chat template

  @Scenario-10
  Scenario: User click button "Load Existing"
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button 'Load Existing'
    Then User see dropdown list of Chat Template which already created
    And Close pop up and delete chat template

  @Scenario-11
  Scenario: User choose Chat Template
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button 'Load Existing'
    Then User see dropdown list of Chat Template which already created
    When User choose chat template "Promo produk"
    Then Input form template name will be filled with "Promo produk"
    Then Box bubble chat 1 will be filled with message "Promo produk terbaru tahun ini"
    Then Box bubble chat 2 will be filled with message "[Image] + Produk 1, potongan harga 20ribu"
    Then Input form Template Hotkey will be active and filled with "Promo2024"
    And Button Create Template will be changed to "Edit Template"
    And Close pop up and delete chat template

  @Scenario-12
  Scenario: User edit isi Chat Template
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button 'Load Existing'
    Then User see dropdown list of Chat Template which already created
    When User choose chat template "Promo produk"
    When User edit form bubble chat 1 with message "Promo terbaru tahun 2024"
    Then Box bubble chat 1 will be filled with message "Promo terbaru tahun 2024"
    And On preview will show bubble chat 1 with message "Promo terbaru tahun 2024"
    And Close pop up and delete chat template

  @Scenario-13
  Scenario: User click button “Edit Template”
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button 'Load Existing'
    Then User see dropdown list of Chat Template which already created
    When User choose chat template "Promo produk"
    When User edit form bubble chat 1 with message "Promo terbaru tahun 2024"
    When User click button Edit Template
    Then Pop-up will be closed
    And Template "Promo produk" will be updated with bubble chat 1 message is "Promo terbaru tahun 2024"
    And Close pop up and delete chat template
