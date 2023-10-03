# Test Set "Registration - Email" for ACA-730
# Auhtor: Iryna Bannikova

@registration_email
Feature: Test Set "Registration Email"

  Background:
    Given I go to "Registration" page IB

  @registration_email_valid
  Scenario Outline: Valid email address -positive
    When I type "First" in first name field
    And I type "Last" in last name field
    When I enter email <email>
    And enter group code "any"
    When I enter password "12345"
    And I retype password in Confirm password "12345"
    When I press "Register Me" button
    And I wait for 2 sec
    Then I get pop-up message "You have been Registered."

    Examples:
      | email                                                                                                                              |
      | "email@test.com"                                                                                                                   |
      | "email23@test.com"                                                                                                                 |
      | "123@123.123"                                                                                                                      |
      | "qa!email$@test.com"                                                                                                               |
      | "emailtestememailteststemailtestenmailtestemailtestemailtestemail@email.com"                                                       |
      | "test@testemailtestememailteststemailtestenmailtestemailtestemailtest.com"                                                         |
      | "test@email.coomcomcmcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcom"                                                       |
      | "emailtestemetesttestmailteststemailtestenmailtestemailteailt@tteststemailtestenmailtestemailtestemailtest.mcomcomcomcomcomcomcom" |


  @registration_email_invalid
  Scenario Outline: Invalid email address - negative
    When I type "First" in first name field
    And I type "Last" in last name field
    When I enter email <email>
    And enter group code "any"
    Then I get error message <error_message>
    When I enter password "12345"
    And I retype password in Confirm password "12345"
    When I press "Register Me" button

    Examples:
      | email                                                                            | error_message                     |
      | ""                                                                               | "This field is required"          |
      | "qa email@test.com"                                                              | "Should be a valid email address" |
      | "@email.com"                                                                     | "Should be a valid email address" |
      | "testemailtestememailteststemailtestenmailtestemailtestemailtestemail@email.com" | "Should be a valid email address" |
      | "test@emaitestemailtestememailteststemailtestenmailtestemailtestemailt.com"      | "Should be a valid email address" |
      | "test@.com"                                                                      | "Should be a valid email address" |
      | "test@email.mcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcom"    | "Should be a valid email address" |
      | "test@email."                                                                    | "Should be a valid email address" |


  @registration_email_more128charactrs
  Scenario: More, than max 128 characters
    When I type "First" in first name field
    And I type "Last" in last name field
    When I enter email "emailtestememailteststemailtestenmailtestemailtestemailtestemail@testemailtestememailteststemailtestenmailtestemailtestemailtest.cmcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomm"
    And enter group code "any"
    When I enter password "12345"
    And I retype password in Confirm password "12345"
    When I press "Register Me" button
    And I wait for 2 sec
    Then I get alert "Data too long for column 'email' at row 1"


