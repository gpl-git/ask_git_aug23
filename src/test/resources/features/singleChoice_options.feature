@singleChoice_options
  Feature: Single Choice Question - Options
    Background:
      Given I open "login" page
      When I type "jreym73@truxamail.com" into email field
      And I type "12345ABC" into password field
      When I click button "Sign In"
      Then I wait for 1 sec
      And I verify that name "Tania Chak" and role "TEACHER" are displayed in the home page TC
      When I click "Quizzes" menu item
      Then I wait for 2 sec
      When I click button "Create New Quiz"
      Then I wait for 1 sec

    @singleChoice_options1
    Scenario: Options 1 and 2 filled up, radio button checked
      When I type "TA-742-TC1" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then quiz title "TA-742-TC1" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC1" from the list of quizzes

    @singleChoice_options2
    Scenario: Options 1 and 2 are empty, radio button is not checked
      When I type "TA-742-TC2" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      When I type "The main focus of acceptance testing is?" into question field of "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then "Option 1" field error message "This field is required" is displayed TC
      And "Option 2" field error message "This field is required" is displayed TC
      Then error message "Choose correct answer" is displayed TC
      And snack-bar error message is displayed in the bottom TC

    @singleChoice_options3
    Scenario: Option 1 with 1000 characters and Option 2 with 1 character, radio button checked
      When I type "TA-742-TC3" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type 1000 character into "Option 1" field of "Q1" TC
      And I type 1 character into "Option 2" field of "Q1" TC
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then quiz title "TA-742-TC3" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC3" from the list of quizzes

    @singleChoice_options4
    Scenario: Option 1 with 1 character and Option 2 with 1001 characters, radio button checked
      When I type "TA-742-TC4" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type 1 character into "Option 1" field of "Q1" TC
      And I type 1001 character into "Option 2" field of "Q1" TC
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then "Option 2" field error message is displayed TC

    @singleChoice_options5
    Scenario: Option 1 and Option 2 filled up only with white spaces, radio button is checked
      When I type "TA-742-TC5" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type " " into "Option 1" field of "Q1"
      And I type " " into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then "Option 1" field error message "This field is required" is displayed TC
      And "Option 2" field error message "This field is required" is displayed TC
      Then snack-bar error message is displayed in the bottom TC

    @singleChoice_options6
    Scenario: 15 Options filled up, radio button checked
      When I type "TA-742-TC6" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I add up to 15 options to "Q1" and fill them up TC
      And I select "Option 1" as correct option in "Q1"
      When I click button "Save"
      Then I wait for 1 sec
      Then quiz title "TA-742-TC6" is displayed on the list of quizzes
      When I delete quiz "TA-742-TC6" from the list of quizzes

    @singleChoice_options7
    Scenario: 16 Options filled up, radio button checked
      When I type "TA-742-TC7" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I add up to 16 options to "Q1" and fill them up TC
      And I select "Option 1" as correct option in "Q1"
      When I click button "Save"
      Then I wait for 1 sec
      Then error message is displayed TC

    @singleChoice_options8
    Scenario: Delete one of 3 options filled up
      When I type "TA-742-TC8" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I add option to "Q1" TC
      And I type "Option 3" into "Option 3" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I click gear icon next to "Option 2" field of "Q1" TC
      When I wait for 1 sec
      And I select "Delete Option" menu item TC
      And I click button "Save"
      Then I wait for 1 sec
      Then quiz title "TA-742-TC8" is displayed on the list of quizzes
      When I click down arrow icon of quiz "TA-742-TC8" TC
      Then I wait for 1 sec
      And I click "Edit" button of quiz "TA-742-TC8" TC
      Then I wait for 1 sec
      When I expand the tab TC
      Then I wait for 1 sec
      Then text "Option 3" is displayed in "Option 2" field TC
      When I click button "Save"
      And I wait for 1 sec
      When I delete quiz "TA-742-TC9" from the list of quizzes

    @singleChoice_options9
    Scenario: Move Up and Down one of 3 Options filled up
      When I type "TA-742-TC9" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I add option to "Q1" TC
      When I type "Option 3" into "Option 3" field of "Q1"
      And I click gear icon next to "Option 2" field of "Q1" TC
      Then I wait for 1 sec
      When I select "Move option up" menu item TC
      And I wait for 1 sec
      And I click button "Save"
      Then I wait for 1 sec
      Then quiz title "TA-742-TC9" is displayed on the list of quizzes
      When I click down arrow icon of quiz "TA-742-TC9" TC
      Then I wait for 1 sec
      And I click "Edit" button of quiz "TA-742-TC9" TC
      Then I wait for 1 sec
      When I expand the tab TC
      Then I wait for 1 sec
      Then text "Ensuring that the system is acceptable to all users" is displayed in "Option 1" field TC
      And text "Testing for a business perspective" is displayed in "Option 2" field TC
      When I click button "Save"
      And I wait for 1 sec
      When I delete quiz "TA-742-TC9" from the list of quizzes

    @singleChoice_options10
    Scenario: Delete Option checked with Radio button from Quiz
      When I type "TA-742-TC10" into quiz title field
      And I add a question
      When I select "Single-Choice" question type in "Q1"
      And I type "The main focus of acceptance testing is?" into question field of "Q1"
      When I type "Testing for a business perspective" into "Option 1" field of "Q1"
      And I type "Ensuring that the system is acceptable to all users" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I add option to "Q1" TC
      When I type "Option 3" into "Option 3" field of "Q1"
      And I click gear icon next to "Option 1" field of "Q1" TC
      Then I wait for 1 sec
      And I select "Delete Option" menu item TC
      Then I wait for 1 sec
      Then radio button in "Option 1" field of "Q1" is not checked TC
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      Then I wait for 1 sec
      Then quiz title "TA-742-TC10" is displayed on the list of quizzes
      When I click down arrow icon of quiz "TA-742-TC10" TC
      Then I wait for 1 sec
      And I click "Edit" button of quiz "TA-742-TC10" TC
      Then I wait for 1 sec
      When I expand the tab TC
      Then I wait for 1 sec
      Then text "Ensuring that the system is acceptable to all users" is displayed in "Option 1" field TC
      And text "Option 3" is displayed in "Option 2" field TC
      When I click button "Save"
      And I wait for 1 sec
      When I delete quiz "TA-742-TC10" from the list of quizzes















