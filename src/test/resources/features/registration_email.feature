# Test Set "Registration - Email" for ACA-730
# Auhtor: Iryna Bannikova

@registration_email
Feature: Test Set "Registration Email"

  Background:
    Given I go to "Registration" page IB

  @registration_email1
  Scenario: Alphabetical characters
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "email@test.com"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."


  @registration_email2
  Scenario: Alphanumeric characters
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "email23@test.com"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."


  @registration_email3
  Scenario: Numeric characters
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "123@123.123"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."


  @registration_email4
  Scenario: Special characters
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "qa!email$@test.com"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."


  @registration_email5
  Scenario: Email field required, can’t be empty
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get error message "This field is required"


  @registration_email6
  Scenario: White spaces in email are not allowed
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "qa email@test.com"
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec

  @registration_email7
  Scenario: Local port with less, than min characters on the left of an @
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "@email.com"
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec

  @registration_email7
  Scenario: Local port with 64 characters on the left of an @
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "emailtestememailteststemailtestenmailtestemailtestemailtestemail@email.com"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."


  @registration_email8
  Scenario: Local port with more, than 64 characters on the left of an @
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "testemailtestememailteststemailtestenmailtestemailtestemailtestemail@email.com"
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec

  @registration_email9
  Scenario: Domain on the right with 63 characters followed by (.)
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "test@testemailtestememailteststemailtestenmailtestemailtestemailtest.com"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."

  @registration_email10
  Scenario: Domain on the right with more, than 63 characters followed by (.)
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "test@emaitestemailtestememailteststemailtestenmailtestemailtestemailt.com"
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec


  @registration_email11
  Scenario: Domain on the right with less, than min characters followed by (.)
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "test@.com"
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec

  @registration_email12
  Scenario: With 63 characters in the last part of the domain
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "test@email.comcomcmcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcom"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."


  @registration_email13
  Scenario: With more, than 63 characters in the last part of the domain
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "test@email.mcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcom"
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec

  @registration_email14
  Scenario: With less, than min characters in the last part of the domain
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "test@email."
    Then enter group code "any"
    And I get error message "Should be a valid email address"
#      Then I enter password "12345"
#      Then I retype password in Confirm password "12345"
#      Then I press "Register Me" button
    And I wait for 2 sec

  @registration_email15
  Scenario: Max 128 characters
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "emailtestemetesttestmailteststemailtestenmailtestemailteailt@tteststemailtestenmailtestemailtestemailtest.mcomcomcomcomcomcomcom"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get pop-up message "You have been Registered."

  @registration_email16
  Scenario: More, than max 128 characters
    When I type "First" in first name field
    Then I type "Last" in last name field
    Then I enter email "emailtestememailteststemailtestenmailtestemailtestemailtestemail@testemailtestememailteststemailtestenmailtestemailtestemailtest.cmcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomm"
    Then enter group code "any"
    Then I enter password "12345"
    Then I retype password in Confirm password "12345"
    Then I press "Register Me" button
    And I wait for 2 sec
    And I get alert "Data too long for column 'email' at row 1"

