@Feature
Feature: Get Texting

  @Scenario-1
  Scenario: Terdapat Contact melakukan chatting ke WhatsApp Number dan user mengirim pesan
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    And The chatroom is handled by user "qa-matt@gmail.com"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
#    And proses terkirim pesan melalui status “Sending” dengan icon jam, kemudian status “Send” dengan centang 1 berwarna hitam, kemudian status “Received” dengan centang 2 berwarna hitam, dan status “Read” dengan centang 2 berwarna biru.

  @Scenario-2
  Scenario: User mengirim pesan dengan image
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When [chat-page] User click button 'Attach' on the left side of field input chat
    And [chat-page] User click choose 'Image'
    And [chat-page] User upload image
    Then Image will be added on field input chat
    And Button 'Attach' icon will be changed to '+'
    When User click and type "Gambar 1" on input field caption
    And [chat-page] User upload image
    Then Image will be added on field input chat in order number 2
    When User click image order number 2 and type "Gambar 2" on input field caption
    And User click button 'Send'
    Then Image will be sent with caption "Gambar 1"
    And Image will be sent with caption "Gambar 2"

  @Scenario-3
  Scenario: User mengirim pesan dengan file
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When [chat-page] User click button 'Attach' on the left side of field input chat
    And [chat-page] User click choose 'File'
    And [chat-page] User upload file
    Then File will be added on field input chat
    And Button 'Attach' icon will be changed to '+'
    When User click and type "File dokumen 1" on input field caption
    And [chat-page] User upload file
    Then File will be added on field input chat in order number 2
    When User click file order number 2 and type "File dokumen 2" on input field caption
    And User click button 'Send'
    Then File will be sent with caption "File dokumen 1"
    And File will be sent with caption "File dokumen 2"

  @Scenario-4
  Scenario: User mengirim pesan dengan Emoji
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click field input chat dan type "Halo "
    When [chat-page] User click button 'Emoji' on the left side of field input chat
    And [chat-page] User choose wanted emoji
    And User click button 'Send'
    Then Message "Halo 😀" from user "qa-matt@gmail.com" will be send

  @Scenario-5
  Scenario: Otomatis menyimpan contact pada fitur Contact List setelah Chatting
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click menu Contact
    Then User will be redirected to page Contact List
    And Contact "6285259027122 - Rahmadhany" will automatically saved

  @Scenario-6
  Scenario: User menambahkan tag pada Contact
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Add Tag' on Detail Chatroom panel
    And User click and type "New Customer" on field search tag
    And User click create a new tag
    Then Tag "New Customer" will be added on Contact "6285259027122 - Rahmadhany"
    And On middle chatroom will shows "qa-matt@gmail.com Added Tag New Customer"

  @Scenario-7
  Scenario: Data contact list auto update after adding tag
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    And Tag "New Customer" will be added on Contact "6285259027122 - Rahmadhany"
    When User click menu Contact
    Then User will be redirected to page Contact List
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact  | Notes | Label |
      | 6285259027122  | Rahmadhany   |       |         |          |      |         |             | New Customer |       |       |

  @Scenario-8
  Scenario: User menambahkan notes pada Contact
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click expand Notes on Detail Chatroom panel
    And User click and type "Catatan untuk customer" on field notes
    Then Notes "Catatan untuk customer" will be added akan on contact
    And On middle chatroom will shows "qa-matt@gmail.com Added Notes"
    When User click icon info on records
    Then Show pop-up Added Notes
    And Show table has column From and To
      | From | To                     |
      | Null | Catatan untuk customer |

  @Scenario-9
  Scenario: Data contact list auto update
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click expand Notes on Detail Chatroom panel
    And User click and type "Catatan untuk customer" on field notes
    When User click menu Contact
    Then User will be redirected to page Contact List
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact  | Notes                  | Label |
      | 6285259027122  | Rahmadhany   |       |         |          |      |         |             | New Customer | Catatan untuk customer |       |

  @Scenario-10
  Scenario: User mengaktifkan toggle important notes
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click expand Notes on Detail Chatroom panel
    And User click and type "Catatan untuk customer" on field notes
    And User click toggle 'Important'
    Then Notes will be blue highlighted
    And On middle chatroom will shows "qa-matt@gmail.com Activated Toggle Important Note"

  @Scenario-11
  Scenario: Data contact list auto update
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click expand Notes on Detail Chatroom panel
    And User click and type "Catatan untuk customer" on field notes
    And User click toggle 'Important'
    When User click menu Contact
    Then User will be redirected to page Contact List
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact  | Notes                  | Label |
      | 6285259027122  | Rahmadhany   |       |         |          |      |         |             | New Customer | Catatan untuk customer |       |
    And [contact-page] Column Notes on contact number "6285259027122" will be blue highlighted

  @Scenario-12
  Scenario: User mengedit Notes
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click expand Notes on Detail Chatroom panel
    And User click and type "Catatan untuk customer" on field notes
    And User click toggle 'Important'
    And User click and type "Catatan untuk customer dan penting" on field notes
    And On middle chatroom will shows "qa-matt@gmail.com Updated Notes"
    When User click icon info on records
    Then Show pop-up Added Notes
    And Show table has column From and To
      | From                   | To                                 |
      | Catatan untuk customer | Catatan untuk customer dan penting |

  @Scenario-13
  Scenario: Data contact list auto update
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click expand Notes on Detail Chatroom panel
    And User click and type "Catatan untuk customer dan penting" on field notes
    And User click toggle 'Important'
    When User click menu Contact
    Then User will be redirected to page Contact List
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth | Country | Province | City | Address | Postal Code | Tag Contact  | Notes                              | Label |
      | 6285259027122  | Rahmadhany   |       |         |          |      |         |             | New Customer | Catatan untuk customer dan penting |       |
    And [contact-page] Column Notes on contact number "6285259027122" will be blue highlighted

  @Scenario-14
  Scenario: Status Chat Session OnGoing
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    And The chatroom is handled by user "qa-matt@gmail.com"
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - New Session ID Created"
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Ongoing        |
    And Photo profile contact on chatbox will be blue highlighted
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send

  @Scenario-15
  Scenario: Status Chat Session Pending
    Given User already login
    And User in inbox page
    And User change pending time to 1 min and expired time to 1 min
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    When User not send message and no interaction for 3 min
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Pending        |
    And Photo profile contact on chatbox will be yellow highlighted

  @Scenario-16
  Scenario: Status Chat Session Expired
    Given User already login
    And User in inbox page
    And User change pending time to 1 min and expired time to 1 min
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    When User not send message and no interaction for 5 min
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended    | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | Expired        |
    And Photo profile contact on chatbox will be red highlighted
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - Session ID Expired"

  @Scenario-17
  Scenario: Status Chat Session OnGoing
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    And The chatroom is handled by user "qa-matt@gmail.com"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    When User not send message and no interaction for 1 min
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - New Session ID Created"
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Ongoing        |
    And Photo profile contact on chatbox will be blue highlighted

  @Scenario-18
  Scenario: Status Chat Session Pending & Expired Unanswered
    Given User already login
    And User in inbox page
    And There is contact "6282213294071 - Juliet" chatting with "6282213288475 - Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    When User not send message and no interaction for 3 min
    And There is contact "6282213288475 - Julia" chatting with "6282213294071 - WA 2"
    And Photo profile contact on chatbox will be yellow highlighted
    When User not send message and no interaction for 2 min
    And On Detail Chat Session shows information
      | Whatsapp              | Username          | Room Created     | Session Created  | Session Ended    | Status Session     |
      | WA 2 (+6282213294071) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | Expired Unanswered |
    And Photo profile contact on chatbox will be red highlighted
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - Session ID Expired Unanswered"

  @Scenario-19
  Scenario: Mengganti durasi waktu Chat Session
    Given User already login
    And User in inbox page
    When User click menu Setting
    Then User will be redirected to page App Information
    When User click sub menu Chat Setting
    Then User will be redirected to Chat Setting
    When [chat-setting-page] User click button 'Edit'
    And User change Pending time to "0 Hours & 5 Min"
    And User change Expired time to "0 Hours & 10 Min"
    When [chat-setting-page] User click button 'Apply Edit'
    Then Chat session will be updated, Pending time will be "0 Hours & 5 Min" and Expired time will be "0 Hours & 10 Min"

  @Scenario-20
  Scenario: Terdapat pesan masuk dan Status Chat Session Ongoing, Pending & Expired Unanswered
    Given User already login
    And User in inbox page
    And User change pending time to 1 min and expired time to 1 min
    And There is contact "6282213294071 - Juliet" chatting with "6282213288475 - Julia"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    When User not send message and no interaction for 1 min
    And There is contact "6282213288475 - Julia" chatting with "6282213294071 - WA 2"
    And Photo profile contact on chatbox will be blue highlighted
    And On Detail Chat Session shows information
      | Whatsapp              | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | WA 2 (+6282213294071) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Ongoing        |
    When User not send message and no interaction for 2 min
    And Photo profile contact on chatbox will be yellow highlighted
    And On Detail Chat Session shows information
      | Whatsapp              | Username          | Room Created     | Session Created  | Session Ended | Status Session |
      | WA 2 (+6282213294071) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | -             | Pending        |
    When User not send message and no interaction for 3 min
    And Photo profile contact on chatbox will be red highlighted
    And On Detail Chat Session shows information
      | Whatsapp              | Username          | Room Created     | Session Created  | Session Ended    | Status Session     |
      | WA 2 (+6282213294071) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | Expired Unanswered |
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - Session ID Expired Unanswered"

  @Scenario-21
  Scenario: Melakukan Close Session
    Given User already login
    And User already add Whatsapp number "6282213288475 - Julia"
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    And The chatroom is handled by user "qa-matt@gmail.com"
    When User click field input chat dan type "Halo"
    And User click button 'Send'
    Then Message "Halo" from user "qa-matt@gmail.com" will be send
    When User not send message and no interaction for 1 min
    When User click button 'Close Session'
    And On Detail Chat Session shows information
      | Whatsapp               | Username          | Room Created     | Session Created  | Session Ended    | Status Session |
      | Julia (+6282213288475) | qa-matt@gmail.com | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | MM/dd/yyyy HH:mm | Close Session  |
    And Photo profile contact on chatbox will be none highlighted
    And On middle chatroom will shows "MM/dd/yyyy HH:mm - Closed Session ID"

  @Scenario-22
  Scenario: User mengedit informasi Contact
    Given User already login
    And User in inbox page
    And There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    When User click button 'Edit Info Contact' on Detail Chatroom panel
    Then Detail Chatroom panel will be changed to Edit Info Contact panel
    When User click field Contact Name and type "Dhany Putra"
    And User click field Birth and type "01/01/2001"
    And User click field Country and type "Indonesia"
    And User click field Province and type "Jawa Timur"
    And User click field City and type "Surabaya"
    And User click field Address and type "Jl. Kertajaya"
    And User click field Postal Code and type "666666"
    And User click button 'Save' on Edit Info Contact panel
    Then Edit Info Contact panel will be changed to Detail Chatroom panel
    And On middle chatroom will shows "qa-matt@gmail.com Edited Contact Information"
    When User click icon info on records
    Then Show pop-up Edited Contact
    And Show table has column Activity,From and To
      | Activity    | From       | To            |
      | Name        | rahmadhany | Dhany Putra   |
      | Birth       | Null       | 01/01/2001    |
      | Country     | Null       | Indonesia     |
      | Province    | Null       | Jawa Timur    |
      | City        | Null       | Surabaya      |
      | Postal Code | Null       | 666666        |
      | Address     | Null       | Jl. Kertajaya |

  @Scenario-23
  Scenario: Data contact list auto update
    Given User already login
    And User in inbox page
    When User click menu Contact
    Then User will be redirected to page Contact List
    And Contact list will be auto updated
      | Contact Number | Contact Name | Birth      | Country   | Province   | City     | Address       | Postal Code | Tag Contact  | Notes                              | Label |
      | 6285259027122  | Dhany Putra  | 01/01/2001 | Indonesia | Jawa Timur | Surabaya | Jl. Kertajaya | 666666      | New Customer | Catatan untuk customer dan penting |       |
    And Revert back contact Rahmadhany

  @Scenario-24
  Scenario: User menambahkan tag pada beberapa chatroom/contact secara sekaligus
    Given User already login
    And User in inbox page
    When User click button 'Check' on chatbox sidebar
    And User check Chatroom from contact "6285259027122,6282213294071"
    And User click button 'More' on chatbox sidebar
    And User choose 'Tagging All Selected'
    Then Show pop-up Tagging All Selected
    When User click and type "Customer baru" on field Search Tag Tagging
    And User click button 'Add Tagging'
    Then There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    Then Tag "Customer baru" will be added on Contact "6285259027122 - Rahmadhany"
    And On middle chatroom will shows "qa-matt@gmail.com Added Tag Customer baru"
    Then There is contact "6282213294071 - Juliet" chatting with "6282213288475 - Julia"
    Then Tag "Customer baru" will be added on Contact "6282213294071 - Juliet"
    And On middle chatroom will shows "qa-matt@gmail.com Added Tag Customer baru"

  @Scenario-25
  Scenario: User menambahkan notes pada beberapa chatroom/contact secara sekaligus
    Given User already login
    And User in inbox page
    When User click button 'Check' on chatbox sidebar
    And User check Chatroom from contact "6285259027122,6282213294071"
    And User click button 'More' on chatbox sidebar
    And User choose 'Notes All Selected'
    Then Show pop-up Notes All Selected
    When User click and type "Catatan untuk pelanggan" on field Search Tag Notes
    And user click toggle important note
    And User click button 'Add Notes'
    Then There is contact "6285259027122 - Rahmadhany" chatting with "6282213288475 - Julia"
    Then Notes "Catatan untuk pelanggan" will be added akan on contact
    And On middle chatroom will shows "qa-matt@gmail.com Added Notes"
    Then There is contact "6282213294071 - Juliet" chatting with "6282213288475 - Julia"
    Then Notes "Catatan untuk pelanggan" will be added akan on contact
    And On middle chatroom will shows "qa-matt@gmail.com Added Notes"

  @Scenario-26
  Scenario: Terdapat beberapa Chatroom pada Chatbox dan user melakukan Filter pada Chatbox
    Given User already login
    And User in inbox page
    When User click button 'Filter' on chatbox sidebar
    And User tick session "OnGoing, Expired"
    And User choose "qa-matt@gmail.com" on form User Name
    And User click button 'Apply Filter'
    Then Chatroom on chatbox will be filtered and showed 'Filter Results' with button 'Reset Filter'

  @Scenario-27
  Scenario: Create New Chat tabs
    Given User already login
    And User in inbox page
    When User click button Add New Chat Tabs
    And User click and type "Achmad Ongoing" on form Chat Tabs Name
    And User tick session "OnGoing"
    And User choose "qa-matt@gmail.com" on form User Name
    And User click button 'Create Chat Tabs'
    And On Chat Tabs will added new tab "Achmad Ongoing"

  @Scenario-28
  Scenario: Membuka Chat Tab yang telah dibuat sebelumnya
    Given User already login
    And User in inbox page
    When User click button Add New Chat Tabs
    And User click and type "Achmad Ongoing" on form Chat Tabs Name
    And User tick session "OnGoing"
    And User choose "qa-matt@gmail.com" on form User Name
    And User click button 'Create Chat Tabs'
    And On Chat Tabs will added new tab "Achmad Ongoing"
    When User click tab "Achmad Ongoing"
    Then Chatroom on chatbox will be filtered and showed 'Chat Tab Results' with button 'Close'

  @Scenario-29
  Scenario: Mengedit Chat Tabs yang sudah dibuat
    Given User already login
    And User in inbox page
    And On Chat Tabs will added new tab "Achmad Ongoing"
    When User click tab "Achmad Ongoing" dropdown
    And User click button Edit chat tabs
    And User click and type "Achmad Expired" on form Chat Tabs Name
    And User tick session "Expired"
    And User click button 'Save Chat Tabs'
    And On Chat Tabs will added new tab "Achmad Expired"

  @Scenario-30
  Scenario: Membuka Chat Tabs yang telah diedit
    Given User already login
    And User in inbox page
    And On Chat Tabs will added new tab "Achmad Expired"
    When User click tab "Achmad Expired"
    Then Chatroom on chatbox will be filtered and showed 'Chat Tab Results' with button 'Close'
