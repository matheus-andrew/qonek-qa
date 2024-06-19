@Feature
Feature: Get Texting - Contact List

  @Scenario-46
  Scenario: User menambahkan contact baru secara manual
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    Then Show pop-up Add New Contact
    And Button Save will be grey out
    When User click and type "628512345678" on field Contact Number
    When User click and type "Burhan" on field Contact Name
    And User click button Save
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact | Notes | Label |
      | 628512345678   | Burhan       |       |         |          |      |         |             | -           |       |       |

  @Scenario-47
  Scenario: User mengedit Contact Number dari suatu contact
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "6285238584048" on field Contact Number
    When User click and type "Putri" on field Contact Name
    And User click button Save
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact | Notes | Label |
      | 6285238584048  | Putri        |       |         |          |      |         |             | -           |       |       |
    When User click button Edit on contact "6285238584048"
    Then Show pop-up Edited Contact on Edit Contact
    When User click field Contact Number
    Then Show warning changed contact number
    When User click button Yes on warning changed contact number
    When User click and type "6281234447311" on field Contact Number
    And User click button Save on Edit Contact
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact | Notes | Label |
      | 6281234447311  | Putri        |       |         |          |      |         |             | -           |       |       |

  @Scenario-48
  Scenario: User melakukan initiate chat melalui fungsi Search Chatbox
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "628512345678" on field Contact Number
    When User click and type "Burhan" on field Contact Name
    And User click button Save
    And User in inbox page
    When User click and type "6281234447311" on field input search on sidebar chatbox
    Then Search chat will be filtered into 3 parts if exist
    When User click contact after search
    Then Show pop-up Initiate Chat First
    When User choose WhatsApp Number "6282213288475 - Julia"
    And User click button Start Chat
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - New Session ID Created"
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Ongoing        |
    And Photo profile contact on chatbox will be blue highlighted

  @Scenario-49
  Scenario: User melakukan initiate chat melalui kolom Label pada tabel Contact List
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    And User click icon Open Chatroom on contact "628512345678"
    Then Search chat will be filtered into 3 parts if exist
    When User click contact after search
    Then Show pop-up Initiate Chat First
    When User choose WhatsApp Number "6282213288475 - Julia"
    And User click button Start Chat
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Ongoing        |
    And Photo profile contact on chatbox will be blue highlighted

  @Scenario-50
  Scenario: User melakukan Edit Contact pada kolom Contact Name, Address, Postal Code, dan Notes langsung melalui tabel
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click and changed name "Putri" into "Putri Diana"
    And user click contact "6281234447311" and changed address "Jl. Kertajaya"
    And user click contact "6281234447311" and changed postal code "44102"
    And user click contact "6281234447311" and changed notes "Customer kakap"
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address       | Postal Code | Tag Contact | Notes          | Label |
      | 6281234447311  | Putri Diana  |       |         |          |      | Jl. Kertajaya | 44102       | -           | Customer kakap |       |

  @Scenario-51
  Scenario: User melakukan bulk upload contact dengan Excel Template
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template into pop-up Import File
    When User click button Submit
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth      | Country   | Province   | City     | Address       | Postal Code | Tag Contact | Notes                | Label |
      | 6285910002000  | Pak Doni     | 07/24/1995 | Indonesia | Jawa Timur | Surabaya | Jl. Kertajaya | 991283      | Lapar;Kaya  | Suka minum susu sapi |       |

  @Scenario-52
  Scenario: User melakukan bulk upload contact dengan Sync From WhatsApp
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Sync From WhatsApp when Add Bulk
    When User click input field Choose WhatsApp Number
    And User choose Whatsapp number "6285797187741 - Julia"
    When User click button Next
    Then Pop-up WhatsApp Sync will continue to second step
    When User check contact wanted to be added
    And User click button Submit
    Then Chosen contact will be added to Contact List table

  @Scenario-53
  Scenario: User melakukan bulk upload contact dengan Excel Template dan melakukan overwrite data
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template overwrite into pop-up Import File
    When User click button Submit
    Then Show pop-up Overwrite Data
    When User click button Yes, Overwrite
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth      | Country   | Province   | City     | Address   | Postal Code | Tag Contact | Notes     | Label |
      | 6285910002000  | Pak Nanto    | 07/24/1995 | Indonesia | Jawa Timur | Surabaya | undefined | 991283      | Lapar;Kaya  | undefined |       |

  @Scenario-54
  Scenario: User melakukan Sync From WhatsApp dan melakukan skip overwrite data
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Sync From WhatsApp when Add Bulk
    When User click input field Choose WhatsApp Number
    And User choose Whatsapp number "6285797187741 - Julia"
    When User click button Next
    Then Pop-up WhatsApp Sync will continue to second step
    When User check contact wanted to be added
    And User click button Submit
    Then Show pop-up Overwrite Data
    When User click button Skip

#  @Scenario-55 #49
#  Scenario: User melakukan Refresh data tabel Contact List
#    Given User already login
#    When User click menu Contact
#    Then User will be redirected to page Contact List
#    And user telah menambahkan beberapa data Contact
#    When User klik button “Refresh Data” pada bagian kanan atas halaman Contact List
#    Then Tabel data contact list akan terefresh/terupdate dan menyesuaikan dengan data dari database sistem

  @Scenario-56
  Scenario: User mengexport table contact list ke format excel
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Export All
    Then Show pop-up Export All Confirmation
    When User click button Yes, Im Sure on Export All Confirmation
    Then Contact list will be exported to excel format

  @Scenario-57
  Scenario: User melakukan search pada tabel Contact List
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "628111402222" on field Contact Number
    When User click and type "Kevin" on field Contact Name
    And User click button Save
    When User click and type "Kevin" on field input search
    And User click button Search
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact | Notes | Label |
      | 628111402222   | Kevin        |       |         |          |      |         |             | -           |       |       |
    When User click icon X on field input search

  @Scenario-58
  Scenario: User melakukan Filter by Column - Sort A to Z/Z to A pada tabel contact list
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click icon filter on Contact Name
    And User click Sort A-Z on pop-up filter
    And User click button Set Filter on pop-up filter
    And user click button Apply Filter on page Contact List
#    Then Tabel Contact List akan terfilter dan akan menampilkan data kolom Contact Name berdasarkan urutan nama A ke Z
    When User click icon filter on Contact Name
    And User click Sort Z-A on pop-up filter
    And User click button Set Filter on pop-up filter
    And user click button Apply Filter on page Contact List
#    Then Tabel Contact List akan terfilter dan akan menampilkan data kolom Contact Name berdasarkan urutan nama Z ke A
    When User click button Remove Filter
#    Then Fitur filter akan dibatalkan dan tabel contact list akan kembali seperti semula

  @Scenario-59
  Scenario: User melakukan Filter by Column - Filter by Condition - Text Starts With pada tabel contact list
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click icon filter on Contact Name
    And User click expand Filter by Condition "Name"
    And On field Condition choose "Text Starts With"
    And User type "Putri" on field condition
    And User click button Set Filter on pop-up filter
    And user click button Apply Filter on page Contact List
#    Then Tabel Contact List akan terfilter dan akan menampilkan data kolom Contact Name yang diawali dengan kata “Putri”
    When User click button Remove Filter
#    Then Fitur filter akan dibatalkan dan tabel contact list akan kembali seperti semula

  @Scenario-60 #54
  Scenario: User melakukan Filter by Column - pada tabel contact list
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "628111402222" on field Contact Number
    When User click and type "Kevin" on field Contact Name
    And User click button Save
    When User click button New Contact
    When User click and type "628944021234" on field Contact Number
    When User click and type "Nando" on field Contact Name
    And User click button Save
    And User click icon filter "628111402222,628944021234" on column Checkbox
#    Then Tabel Contact List akan terfilter dan hanya akan menampilkan contact “628111402222 - Kevin” & “628944021234 - Nando” yang telah tercentang

  @Scenario-61
  Scenario: User melakukan mengexport data contact list yang telah terfilter
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click icon filter on Contact Name
    And User click expand Filter by Condition "Name"
    And On field Condition choose "Text Starts With"
    And User type "Putri" on field condition
    And User click button Set Filter on pop-up filter
    And user click button Apply Filter on page Contact List
    When User click button Export All
    Then Show pop-up Export All Confirmation
    When User click button Yes, Im Sure on Export All Confirmation
    Then Contact list will be exported to excel format

  @Scenario-62
  Scenario: User membuka Contact History pada Contact List
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    Then User will be redirected to page Contact History
    And Contact History list will shows all history data
      | Date       | Time  | Session ID   | WhatsApp Number | User Name         | Activity        | From | To |
      | MM/dd/yyyy | HH:mm | Chat Session | 6282213288475   | qa-matt@gmail.com | Expired Session |      |    |

  @Scenario-63
  Scenario: User mengexport data Contact History
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    And User click button Export History
    And User click button Yes, Im Sure on Export History Confirmation
    Then History list will be exported to excel format

  @Scenario-64
  Scenario: User mengexport data Contact History yang telah difilter Filter by Column - Filter by Condition
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    When User click icon filter Activity on Contact History page
    And User click expand Filter by Condition "Activity"
    And On field Condition choose "Text Contains"
    And User type "Start" on field condition
    And User click button Set Filter on pop-up filter
#    Then Tabel Contact history akan terfilter dan akan menampilkan data kolom Activity yang megnandung kata “Start”
#    And hasil filter menampilkan 2 data contacts
    And User click button Export History
    And User click button Yes, Im Sure on Export History Confirmation
    Then History list will be exported to excel format

  @Scenario-65
  Scenario: User mengedit data Contact melalui panel Detail Contact
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    And User click button Edit Contact on Detail Contact panel
    And User click and type "Alfat yual" on field Contact Name Contact List Detail
    And User click and type "Jl. Kalimantan" on field Address Contact List Detail
    And User click button Save on Contact List Detail
#    Then Contact akan terupdate dengan Contact Name “Alfat yual” dan Address “Jl. Kalimantan”
#    And pada tabel Contact History akan bertambah baris seperti berikut <Date>, <Time>, <Session ID> <WhatsApp Number>, <Username>, <Active>, <From>, dan <To>

  @Scenario-66
  Scenario: User melakukan edit beberapa contact secara sekaligus
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    And User click icon filter "628111402222,628944021234" on column Checkbox
    And User click button Edit Bulk on Contact List Page
    Then Show pop-up Edit Bulk
    When User click and type "Indonesia" on field Country Edit Bulk
    And User click and type "Jawa Timur" on field Province Edit Bulk
    And User click on Tag Edit Bulk and choose "Add"
    And User click and type "Customer Lokal" on field Tag Edit Bulk
    And user click button Save on Edit Bulk
#    And Contact list will be auto updated
#      | Contact Number | Contact Name | Birth | Country   | Province   | City | Address | Postal Code | Tag Contact    | Notes | Label |
#      | 628111402222   | Kevin        |       | Indonesia | Jawa Timur |      |         |             | Customer Lokal |       |       |
#      | 628944021234   | Nando        |       | Indonesia | Jawa Timur |      |         |             | Customer Lokal |       |       |

  @Scenario-67 #61
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template 1000 into pop-up Import File
    Then User see warn upload more than 1000 data

  @Scenario-68
  Scenario: User melakukan bulk upload contact dengan Excel Template yang lebih dari 1000 data dan terdapat data contact number yang sama
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template 1000 Overwrite into pop-up Import File
    Then User see warn upload more than 1000 data
    When User click button Submit
    Then User see pop-up Skip or Overwrite

  @Scenario-69
  Scenario: User menavigasi halaman Contact List dengan pagination
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Add Bulk
    And User choose Import File when Add Bulk
    And User upload excel template 20 into pop-up Import File
    When User click button Submit
    When User click field data view on pagination and choose "10"
    When User click button Next pagination on Contact List
    Then User on page 2 of Contact List
    When User click button Prev pagination on Contact List
    Then User on page 1 of Contact List

  @Scenario-70
  Scenario: User mengganti data view dari pagination Contact List
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    Then User on page 1 of Contact List
    When User click field data view on pagination and choose "50"
    Then Table Contact List will only show 50 row data Contact List
    When User click field data view on pagination and choose "10"
    Then Table Contact List will only show 10 row data Contact List

  @Scenario-71
  Scenario: User menghapus Contact dari tabel Contact List
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "628944021234" on field Contact Number
    When User click and type "Nando" on field Contact Name
    And User click button Save
    When User click button Delete on contact "628944021234"
    Then Show pop-up Delete confirmation
    When User click button Yes, I’m Sure on Delete confirmation

  @Scenario-72
  Scenario: User menghapus beberapa Contact dari tabel Contact List secara sekaligus
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "628111402222" on field Contact Number
    When User click and type "Kevin" on field Contact Name
    And User click button Save
    When User click button New Contact
    When User click and type "628944021234" on field Contact Number
    When User click and type "Nando" on field Contact Name
    And User click button Save
    And User click icon filter "628111402222,628944021234" on column Checkbox
    And user click button Delete Bulk on Contact List page
    Then Show pop-up Delete Bulk confirmation
    When User click button Yes, I’m Sure on Delete Bulk confirmation

  @Scenario-73
  Scenario: User menambahkan Contact yang telah dihapus
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button New Contact
    When User click and type "628111402222" on field Contact Number
    When User click and type "Kevin" on field Contact Name
    And User click button Save
    When User click button New Contact
    When User click and type "628944021234" on field Contact Number
    When User click and type "Nando" on field Contact Name
    And User click button Save
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact | Notes | Label |
      | 628111402222   | Kevin        |       |         |          |      |         |             | -           |       |       |
      | 628944021234   | Nando        |       |         |          |      |         |             | -           |       |       |

  @Scenario-74
  Scenario: Membuka Contact List History setelah melakukan Chatting dengan beberapa Contact
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    Then User will be redirected to page Contact History
    And Contact History list will shows all history data
      | Date       | Time  | Session ID   | WhatsApp Number | User Name         | Activity        | From | To |
      | MM/dd/yyyy | HH:mm | Chat Session | 6282213288475   | qa-matt@gmail.com | Expired Session |      |    |

  @Scenario-75
  Scenario: Menggunakan fungsi input search
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    Then User will be redirected to page Contact History
    When User type "Expired" on input search Contact History
    Then Table Contact List History will be filtered with blue highlighted
    When User click icon X on input search Contact History
    Then Table Contact List History will be back to normal

  @Scenario-76
  Scenario: Melakukan export table Contact List History
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    Then User will be redirected to page Contact History
    When User click button Export History
    And User click button Yes, Im Sure on Export History Confirmation
    Then History list will be exported to excel format

  @Scenario-77
  Scenario: Melakukan filter by column dan export table Contact List History
    Given User already login
    When User click menu Contact
    Then User will be redirected to page Contact List
    When User click button Contact History on contact "6285259027122"
    Then User will be redirected to page Contact History
    When User click icon filter SessionID on Contact History page
    And User click expand Filter by Value "SessionID"
    And On field filter by value tick only one
    And User click button Set Filter on pop-up filter
    When User click button Export History
    And User click button Yes, Im Sure on Export History Confirmation
    Then History list will be exported to excel format

  @Scenario-78
  Scenario: User melakukan Search Entire Database pada input search Chatbox
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    When User click and type "6285259027122" on field input search on sidebar chatbox
    Then Search chat will be filtered into 3 parts if exist
#    When User click contact after search
#    And terdapat button “Search Entire Database”
#    When User klik button “Search Entire Database”
#    Then Akan muncul pop-up Entire Database Results dan menampilkan seluruh data yang lebih lampau
#    Then Search chat will be filtered into 3 parts if exist
#    Then Show pop-up Initiate Chat First
#    When User choose WhatsApp Number "6282213288475 - Julia"
#    And User click button Start Chat
#    When User click field input chat dan type "Halo"
#    And User click button 'Send'
#    Then Message "Halo" from user "qa-matt@gmail.com" will be send
#    And On Detail Chat Session shows information
#      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended | Status Session |
#      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Ongoing        |
#    And Photo profile contact on chatbox will be blue highlighted

  @Scenario-79
  Scenario: User menambahkan Contact baru pada Search Entire Database
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    When User click and type "6285555522221" on field input search on sidebar chatbox
    Then Search chat will found nothing
#    When User klik button “Search Entire Database”
#    Then Akan muncul pop-up Entire Database Results dan tidak menampilkan hasil apapun
#    When User klik tab “Contacts”
#    And user klik “Create New Chatroom “6285555522221””
#    Then Akan muncul pop-up Initiate Chat First
#    And menampilkan daftar WhatsApp Number yang telah terconnect
#    When User pilih WhatsApp Number “6285797187741 - Julia”
#    And user klik button “Start First”
#    Then Akan terbentuk suatu chatroom kosong antara Contact “6285555522221” dengan WhatsApp Number “6285797187741 - Julia”
#    When User klik field input chat dan mengetikkan pesan “Halo”
#    And user klik button “Send”
#    Then Pesan “Halo” dari user Achmadyual akan terkirim
#    And akan terbentuk suatu Chat Session baru
#    And pada bagian Detail Chat Session akan menampilkan informasi <WhatsApp>, <Username>, <Room Created>, <Session Created>, <Session Ended>, <Status Session>
#    And Foto profil contact pada Chatbox akan terhighlight berwarna biru dan berstatus “OnGoing”
#    And contact “6285555522221” akan ditambahkan ke tabel Contact List
