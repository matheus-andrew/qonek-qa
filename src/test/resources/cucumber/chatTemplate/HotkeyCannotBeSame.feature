@Feature @QA-280
Feature: Hotkey cannot be same

  Background: User create chat template
    Given User already login
    And User in chat template page
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User input template name with "Promo produk baru spencers"
    When User click button Add Bubble Chat
    When User click and type "Promo produk terbaru tahun ini" in form box Bubble Chat 1
    When User click and type "Produk 1, potongan harga 20ribu" in form box Bubble Chat 2
    When User click button 'Add File' on bubble chat 2
    And User click choose 'Image'
    And User upload image
    Then Chosen image will be added in bubble chat 2 box
    When User click and type "PromoSpencers2024" on form Template Hotkey
    When User click button Create Template
    Then Pop-up will be closed
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button 'Load Existing'
    Then User see dropdown list of Chat Template which already created
    When User choose chat template "Promo produk baru spencers"
    When User edit form Template Name to "Promo baru 2024"
    And User edit form Template Hotkey to "Promobaru2024"
    Then Input form template name will be filled with "Promo baru 2024"
    Then Input form Template Hotkey will be active and filled with "Promobaru2024"
    And Button Create Template will be changed to "Create Template"
    When User click button Create Template
    Then Pop-up will be closed
    And Template will be added in template table list with columns
#      | Template Name   | Hotkey        | Created Time | Guide Book |
      | Promo produk baru spencers | PromoSpencers2024 | [today] | - |
      | Promo baru 2024            | Promobaru2024     | [today] | - |

  @Scenario-21
  Scenario: User edit template which already created previously
    And User see a few template on list template table
    And On right side of table will have column button 'Edit' dan 'Delete'
    When User click button 'Edit' on template name "Promo produk baru spencers"
    Then Show pop-up Edit Chat Template
    And Edit form template name will be filled with "Promo produk baru spencers"
    Then Box bubble chat 1 will be filled with message "Promo produk terbaru tahun ini"
    Then Box bubble chat 2 will be filled with message "[Image] + Produk 1, potongan harga 20ribu"
    Then Input form Template Hotkey will be active and filled with "PromoSpencers2024"
    And User see button 'Save Template'
    And Close pop up and delete chat template

  @Scenario-22
  Scenario: User edit Template Hotkey with hotkey that already exist
    And User see a few template on list template table
    When User click button 'Edit' on template name "Promo baru 2024"
    Then Show pop-up Edit Chat Template
    And User edit form Template Hotkey to "PromoSpencers2024"
    Then Form Template Hotkey will be error with red highlight
    And User will see error message "Hotkeys Already Exist"
    And Close pop up and delete chat template

  @Scenario-23
  Scenario: Template Hotkey error and user still click button Save Template
    And User see a few template on list template table
    When User click button 'Edit' on template name "Promo baru 2024"
    Then Show pop-up Edit Chat Template
    And User edit form Template Hotkey to "PromoSpencers2024"
    Then Form Template Hotkey will be error with red highlight
    And User will see error message "Hotkeys Already Exist"
    When User click button 'Save Template'
    Then Pop-up will not be closed
    And Template cannot be saved
