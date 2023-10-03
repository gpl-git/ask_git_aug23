@test
Feature: ASK test set for multiple choice questions
Background: ASK website QA env
    Given I open the "login" page
    When I type "junalife@uwesport.com" into email
    And I type "abc123456" into password
    When I click on button "Sign In"
    And I wait for 1 sec
    And I click on "Quizzes" menu item
    And I wait for 1 sec
    And I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "My TA Quiz" into quiz title
    Then I add a question
    And I wait for 1 sec
    When I click on "Multiple-Choice" question type in "Q1"
    And I wait for 1 sec

@test1
Scenario: Check minimum # of options
    Then I should see 2 options in the question
    And I wait for 2 sec

@test2
Scenario:Check maximum number of options
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type "2" into "Option 2" field of "Q1" question
#    When I click on "Add Option" button until 16 options reached
    And I add upp to 15 options in "Q1"
    And I click on button "Save"
    And I wait for 3 sec
    Then title "My TA Quiz" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "My TA Quiz" from the list of quizzes
    And I wait for 5 sec

@test3
Scenario:Check exceeding maximum number of options
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type "2" into "Option 2" field of "Q1" question
    And I add upp to 15 options in "Q1"
    Then I verify that there only 16 options
    And I click on button "Save"
    Then I should see an "Maximum amount is 15 options" error in "Q1"
    And I wait for 3 sec
    Then title "My TA Quiz" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "My TA Quiz" from the list of quizzes
    And I wait for 5 sec


@test4
Scenario: Check minimum amount of characters in the input field
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I click on "Option 2" in "Q1"
    And I click on "Option 1" in "Q1"
    Then I should see an "This field is required" error in "Option 1" in "Q1"
    And I wait for 3 sec

@test5
Scenario: Check maximum amount of characters in the input field
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I click on "Option 2" in "Q1"
    And I type 1000 characters into "Option 2" field of "Q1" question
    And I wait for 2 sec
    And I click on button "Save"
    And I wait for 3 sec
    Then title "My TA Quiz" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "My TA Quiz" from the list of quizzes

@test6
Scenario: Check handling of exceeding maximum amount of characters in the input field
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type 1001 characters into "Option 2" field of "Q1" question
    And I wait for 5 sec
    And I click on button "Save"
    Then I should see an "Maximum amount is 1000 Characters" error in "Option 2" in "Q1"

@test7
Scenario: Option deletion
    When I click on "Add Option" button until 3 options reached
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type "2" into "Option 2" field of "Q1" question
    And I type "3" into "Option 3" field of "Q1" question
    And I wait for 1 sec
    When I click on Settings icon and delete "Option 1" in "Q1"
    And I wait for 2 sec
    Then I verify that there only 2 options


@test7
Scenario: Move up option
    Then I select "Option 1" as a correct option in "Q1"
    When I type "Question 1" into field of "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type "2" into "Option 2" field of "Q1" question
    And I wait for 1 sec
    When I click on Settings icon and "Move option up" "Option 2" in "Q1"
    And I wait for 5 sec
    Then "Option 1" should contain "2" in the "Q1" question

@test8
Scenario: Move down option
    Then I select "Option 1" as a correct option in "Q1"
    When I type "Question 1" into field of "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type "2" into "Option 2" field of "Q1" question
    And I wait for 1 sec
    When I click on Settings icon and "Move option down" "Option 1" in "Q1"
    And I wait for 5 sec
    Then "Option 2" should contain "1" in the "Q1" question