@asset @asset

  Feature: click on google link
#    TC1: Verify you can navigate to Payees page using the navigation menu
#    1. Click ‘Menu’
#    2. Click ‘Payees’
#    3. Verify Payees page is loaded

    Background: TC1 Navigation to Payees
      Given user navigates to the login page by opening Chrome
      When user clicks on menu
      Then user is able to click on payees page
      And user is able to see payees page
#
#    1. Navigate to Payees page
#    2. Click ‘Add’ button
#    3. Enter the payee details (name, account number)
#    4. Click ‘Add’ button
#    5. ‘Payee added’ message is displayed, and payee is added in the list of payees

Scenario: TC2 Verify you can add new payee in the Payees page
    Given user is able to see payees page
    Then User clicks Add button
    When Add payees popup is displayed
    Then user enters the payee details
    And user clicks on add button
    Then payee added message is displayed
    And payee is added in the list of payees

#TC3: Verify payee name is a required field
#1. Navigate to Payees page
#2. Click ‘Add’ button
#3. Click ‘Add’ button
#4. Validate errors
#5. Populate mandatory fields
#6. Validate errors are gone

 Scenario: TC3 Verify payee name is a required field
      Given user is able to see payees page
      Then User clicks Add button
      When Add payees popup is displayed
      Then user does not enter the payee details
      And user clicks on disabled add button
      Then an error message is displayed
      Then user enters the payee details
      And user clicks on add button
      Then an error message is not displayed
      Then payee added message is displayed
      And payee is added in the list of payees

# TC4: Verify that payees can be sorted by name
# 1. Navigate to Payees page
# 2. Add new payee
# 3. Verify list is sorted in ascending order by default
# 4. Click Name header
# 5. Verify list is sorted in descending order

    Scenario: TC4 Verify that payees can be sorted by name
      Given user is able to see payees page
      Then User clicks Add button
      When Add payees popup is displayed
      Then user enters the payee details
      And user clicks on add button
      Then payee added message is displayed
      And payee is added in the list of payees
      Then payees are sorted in ascending order by default
      And user clicks on Name header
      Then payees are sorted in descending order


#    TC5: Navigate to Payments page
#    1. Navigate to Payments page
#    2. Transfer $500 from Everyday account to Bills account
#    3. Transfer successful message is displayed
#    4. Verify the current balance of Everyday account and Bills account are correct

      Scenario: TC5 Navigate to Payments page
        Given user navigates to the login page by opening Chrome
        When user clicks on menu
        Then user is able to click on payments page
        And user is able to see payments popup
        Then user click on from account
        And user selects everyday account
        Then user clicks on account
        Then user click on to account
        And user clicks on bills account
        Then user inputs five hundred into the input box
        And user clicks on transfer
        Then transfer successful message is displayed
        Then user is navigated to the home page
        And the amount in every day is two thousand
        And the amount in bills is nine twenty





