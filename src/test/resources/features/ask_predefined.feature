@predefined
  Feature: ASK Predefined Steps for Quiz
    Background:
      Given I open "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "ABC123" into password field
      When I click button "Sign In"
      And I wait for 1 sec
      And I click "Quizzes" menu item
      And I wait for 1 sec
      And I click button "Create New Quiz"
      And I wait for 1 sec

    @predefined1
    Scenario: Quiz
       When I type "Demo TA Quiz" into quiz title field
      And I wait for 1 sec
      When I add a question
      And I select "Single" question type in "Q1"
      When I type "Question 1" into question field of "Q1"
      And I type "Option 1" into "Option 1" field of "Q1"
      And I type "Option 2" into "Option 2" field of "Q1"
      When I select "Option 1" as correct option in "Q1"
      And I click button "Save"
      And I wait for 2 sec
      Then quiz title "Demo TA Quiz" is displayed on the list of quizzes
      And I delete quiz "Demo TA Quiz" from the list of quizzes


