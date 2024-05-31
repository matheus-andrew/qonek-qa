@Feature @QA-277
Feature: Edit Chat Template

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
    When User click button Create New Template
    Then Show pop-up Create New Chat Template
    When User click button 'Load Existing'
    Then User see dropdown list of Chat Template which already created
    When User choose chat template "Promo produk"
    When User edit form Template Name to "Promo baru 2024"
    And User edit form Template Hotkey to "Promobaru2024"
    Then Input form template name will be filled with "Promo baru 2024"
    Then Input form Template Hotkey will be active and filled with "Promobaru2024"
    And Button Create Template will be changed to "Create Template"
    When User click button Create Template
    Then Pop-up will be closed
    And Template will be added in template table list with columns
#      | Template Name   | Hotkey        | Created Time | Guide Book |
      | Promo produk    | Promo2024     | [today]      | -          |
      | Promo baru 2024 | Promobaru2024 | [today]      | -          |

  @Scenario-19
  Scenario: User edit template which already created previously
    And User see a few template on list template table
    And On right side of table will have column button 'Edit' dan 'Delete'
    When User click button 'Edit' on template name "Promo produk"
    Then Show pop-up Edit Chat Template
    And Edit form template name will be filled with "Promo produk"
    Then Box bubble chat 1 will be filled with message "Promo produk terbaru tahun ini"
    Then Box bubble chat 2 will be filled with message "[Image] + Produk 1, potongan harga 20ribu"
    Then Input form Template Hotkey will be active and filled with "Promo2024"
    And User see button 'Save Template'
    And Close pop up and delete chat template

  @Scenario-20
  Scenario: User edit template and click button Save
    And User see a few template on list template table
    And On right side of table will have column button 'Edit' dan 'Delete'
    When User click button 'Edit' on template name "Promo produk"
    Then Show pop-up Edit Chat Template
    When User edit form Template Name to "Promo produk baru spencers"
    When User edit form bubble chat 1 with message "Promo produk spencers tahun ini"
    And User edit form Template Hotkey to "PromoSpencers2024"
    And User click button 'Save Template'
    Then Pop-up will be closed
    And Template will be added in list with Template Name "Promo baru 2024" and Template Hotkey "Promobaru2024"
    And Template will be added in template table list with columns
#      | Template Name   | Hotkey        | Created Time | Guide Book |
      | Promo produk baru spencers | PromoSpencers2024 | [today] | - |
      | Promo baru 2024            | Promobaru2024     | [today] | - |
    And User click Delete template on table list