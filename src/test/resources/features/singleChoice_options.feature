@singleChoice_options
  Feature: Single Choice Question - Options
    Background:
      Given I open "login" page
      When I type "jreym73@truxamail.com" into email field
      And I type "12345ABC" into password field
      When I click button "Sign In"
      And I wait for 1 sec
      Then I verify that name "Tania Chak" and role "TEACHER" are displayed in the home page TC
      When I click "Quizzes" menu item
      And I wait for 2 sec
      And I click button "Create New Quiz"
      And I wait for 1 sec

    @singleChoice_options1
    Scenario: Options 1 and 2 filled up, radio button checked
      When I type "TA-742-TC1" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      And I wait for 1 sec
      Then quiz title "TA-742-TC1" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC1" from the list of quizzes

    @singleChoice_options2
    Scenario: Options 1 and 2 are empty, radio button is not checked
      When I type "TA-742-TC2" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I click button "Save"
      And I wait for 1 sec
      Then "Option 1" field error message "This field is required" is displayed TC
      And "Option 2" field error message "This field is required" is displayed TC
      Then error message "Choose correct answer" is displayed TC
      And I wait for 2 sec

    @singleChoice_options3
    Scenario: Option 1 with 1000 characters and Option 2 with 1 character, radio button checked
      When I type "TA-742-TC3" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type 1000 characters into "Option 1" field of "Q1" TC
      And I type 1 character into "Option 2" field of "Q1" TC
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      And I wait for 1 sec
      Then quiz title "TA-742-TC3" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC3" from the list of quizzes

    @singleChoice_options4
    Scenario: Option 1 with 1 character and Option 2 with 1001 characters, radio button checked
      When I type "TA-742-TC4" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type 1 character into "Option 1" field of "Q1" TC
      And I type 1001 characters into "Option 2" field of "Q1" TC
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then "Option 2" field error message is displayed TC


    @singleChoice_options5
    Scenario: Option 1 and Option 2  filled up only with white spaces, radio button is checked
      When I type "TA-742-TC5" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type " " into "Option 1" field of "Q1"
      When I type " " into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then "Option 1" field error message "This field is required" is displayed TC
      And "Option 2" field error message "This field is required" is displayed TC

    @singleChoice_options6
    Scenario: 15 Options filled up, radio button checked
      When I type "TA-742-TC6" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I wait for 2 sec
      When I add 13 options to "Q1" TC
      And I type "1" into "Option 1" field of "Q1"
      When I type "2" into "Option 2" field of "Q1"
      When I type "3" into "Option 3" field of "Q1"
      And I type "4" into "Option 4" field of "Q1"
      When I type "5" into "Option 5" field of "Q1"
      When I type "6" into "Option 6" field of "Q1"
      And I type "7" into "Option 7" field of "Q1"
      When I type "8" into "Option 8" field of "Q1"
      When I type "9" into "Option 9" field of "Q1"
      And I type "10" into "Option 10" field of "Q1"
      When I type "11" into "Option 11" field of "Q1"
      When I type "12" into "Option 12" field of "Q1"
      And I type "13" into "Option 13" field of "Q1"
      When I type "14" into "Option 14" field of "Q1"
      And I type "15" into "Option 15" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I wait for 2 sec
      And I click button "Save"
      Then I wait for 2 sec
      Then quiz title "TA-742-TC6" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC6" from the list of quizzes

    @singleChoice_options7
    Scenario: 16 Options filled up, radio button checked
      When I type "TA-742-TC7" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I wait for 2 sec
      When I add 14 options to "Q1" TC
      And I type "1" into "Option 1" field of "Q1"
      When I type "2" into "Option 2" field of "Q1"
      When I type "3" into "Option 3" field of "Q1"
      And I type "4" into "Option 4" field of "Q1"
      When I type "5" into "Option 5" field of "Q1"
      When I type "6" into "Option 6" field of "Q1"
      And I type "7" into "Option 7" field of "Q1"
      When I type "8" into "Option 8" field of "Q1"
      When I type "9" into "Option 9" field of "Q1"
      And I type "10" into "Option 10" field of "Q1"
      When I type "11" into "Option 11" field of "Q1"
      When I type "12" into "Option 12" field of "Q1"
      And I type "13" into "Option 13" field of "Q1"
      When I type "14" into "Option 14" field of "Q1"
      And I type "15" into "Option 15" field of "Q1"
      And I type "16" into "Option 16" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I wait for 2 sec
      And I click button "Save"
      Then error message "" is displayed TC

    @singleChoice_options8
    Scenario: Delete one of 3 options filled up
      When I type "TA-742-TC8" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      When I add option to "Q1" TC
      When I type "Incorrect" into "Option 3" field of "Q1"
      And I wait for 2 sec
      And I click gear icon next to "Option 2" field of "Q1" TC
      When I wait for 2 sec
      And I select "Delete Option" menu item TC
#      Then text "Incorrect" is displayed in "Option 2" field TC
#      And I wait for 3 sec
#      Then "Option 3" field is not displayed TC
      And I click button "Save"
      And I wait for 2 sec
      Then quiz title "TA-742-TC8" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC8" from the list of quizzes

    @singleChoice_options9
    Scenario: Move Up and Down one of 3 Options filled up
      When I type "TA-742-TC9" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      When I add option to "Q1" TC
      When I type "Incorrect" into "Option 3" field of "Q1"
      And I wait for 2 sec
      And I click gear icon next to "Option 2" field of "Q1" TC
      When I wait for 2 sec
      And I select "Move option up" menu item TC
      And I wait for 3 sec
#      Then text "Ensuring that the system is acceptable to all users" is displayed in "Option 1" field TC
#      And text "Testing for a business perspective" is displayed in "Option 2" field TC
      When I click button "Save"
      And I wait for 2 sec
      Then quiz title "TA-742-TC9" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC9" from the list of quizzes

    @singleChoice_options10
    Scenario: Delete Option checked with Radio button from Quiz
      When I type "TA-742-TC10" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      When I add option to "Q1" TC
      When I type "Incorrect" into "Option 3" field of "Q1"
      And I wait for 2 sec
      And I click gear icon next to "Option 1" field of "Q1" TC
      Then I wait for 2 sec
      And I select "Delete Option" menu item TC
#      Then text "Testing for a business perspective" is displayed in "Option 1" field TC
#      And text "Incorrect" is displayed in "Option 2" field TC
#      Radio button is not checked
      When I select "Option 1" as correct option in "Q1"
      When I click button "Save"
      And I wait for 2 sec
      Then quiz title "TA-742-TC10" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC10" from the list of quizzes















