@test
Feature: ASK test set for multiple choice questions



@test1
Scenario: Check minimum # of options
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
    Then I should see 2 options in the question
    And I wait for 2 sec

@test2
Scenario:Check max # of options
    Given I open "login" page
    When I type "junalife@uwesport.com" into email field
    And I type "abc123456" into password field
    When I click button "Sign In"
    And I wait for 1 sec
    And I click "Quizzes" menu item
    And I wait for 1 sec
    And I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "My TA Quiz" into quiz title field
    When I add a question
    And I wait for 1 sec
    Then I click on "Multiple-Choice" question type in "Q1"
    And I wait for 1 sec
    When I click on "Add Option" button until 16 options reached
    Then I verify that there only 15 options
    And I wait for 5 sec

@test3
Scenario: Check minimum amount of characters in the input field
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
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I click on "Option 2" in "Q1"
    And I click on "Option 1" in "Q1"
    Then I should see an "This field is required" error in "Option 1" in "Q1"
    And I wait for 3 sec

@test4
Scenario: Check maximum amount of characters in the input field
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
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I click on "Option 2" in "Q1"
    And I type "asdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjkla" into "Option 2" field of "Q1" question
    And I wait for 2 sec
    And I click on button "Save"
    And I wait for 3 sec
    Then title "My TA Quiz" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "My TA Quiz" from the list of quizzes

@test5
Scenario: Check handling of exceeding maximum amount of characters in the input field
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
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I click on "Option 2" in "Q1"
    And I type "asdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklaq" into "Option 2" field of "Q1" question
    Then I should see an "Maximum amount is 1000 Characters" error in "Option 2" in "Q1"

@test6
Scenario: Option deletion
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
    When I click on "Add Option" button until 3 options reached
    When I type "Question 1" into field of "Q1"
    Then I select "Option 1" as a correct option in "Q1"
    And I type "1" into "Option 1" field of "Q1" question
    And I type "2" into "Option 2" field of "Q1" question
    And I type "3" into "Option 3" field of "Q1" question
    And I wait for 1 sec
    When I click on Settings icon and delete "Option 1" in "Q1"
    And I wait for 5 sec
    Then I verify that there only 2 options


    @test6
    Scenario: Move up option
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
        Then I select "Option 1" as a correct option in "Q1"
        When I type "Question 1" into field of "Q1"
        And I type "1" into "Option 1" field of "Q1" question
        And I type "2" into "Option 2" field of "Q1" question
        And I wait for 1 sec
        When I click on Settings icon and "Move option up" "Option 2" in "Q1"
        And I wait for 5 sec
        Then "Option 1" should contain "2" in the "Q1" question

    @test6
    Scenario: Move down option
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
        Then I select "Option 1" as a correct option in "Q1"
        When I type "Question 1" into field of "Q1"
        And I type "1" into "Option 1" field of "Q1" question
        And I type "2" into "Option 2" field of "Q1" question
        And I wait for 1 sec
        When I click on Settings icon and "Move option down" "Option 1" in "Q1"
        And I wait for 5 sec
        Then "Option 2" should contain "1" in the "Q1" question