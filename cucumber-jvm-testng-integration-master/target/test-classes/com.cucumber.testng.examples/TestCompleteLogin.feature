@loginpage
Feature: TestComplete Login page

 
  Scenario: TestComplete Login page Sencarios
    Given I go to "qaurl" and with "chrome"
    When I enter "Tester" in the "usertxtbox_id"
    And I enter "test" in the "password_id"
    And I click on "login_id" button
    Then I validate "viewallorder_xpath" the Logged successful
    And I close Browser

 
  Scenario: TestComplete Login Failed invalid user,Verify Error Message
    Given I go to "qaurl" and with "chrome"
    When I enter "Tester123" in the "usertxtbox_id"
    And I enter "test" in the "password_id"
    And I click on "login_id" button
    Then I verified "Invalid Login or Password." is displayed
    And I close Browser

 
  Scenario: TestComplete Login Unsuccessful with invalid password,Verified Error Message
    Given I go to "qaurl" and with "chrome"
    When I enter "Tester" in the "usertxtbox_id"
    And I enter "test123" in the "password_id"
    And I click on "login_id" button
    Then I verified "Invalid Login or Password." is displayed
     And I close Browser

 
  Scenario: TestComplete Logout successful
    Given I go to "qaurl" and with "chrome"
    When I enter "Tester" in the "usertxtbox_id"
    And I enter "test" in the "password_id"
    And I click on "login_id" button
    And I click on "logout_linktxt" button
    Then I verified "Web Orders Login" page title
     And I close Browser
     
  
  Scenario: TestComplete Login page Sencarios
    Given I go to "qaurl" and with "chrome"
    When I enter "Tester" in the "usertxtbox_id"
    And I enter "test" in the "password_id"
    And I click on "login_id" button
    Then I validate "viewallorder_xpath" the Logged successful
    And I click on "viewallprodts_linktxt" button
     And I close Browser
