@totalQs
Feature: Predefined Steps To Test Total Questions Allowed
  Background: ASK website in QA environment
    Given I visit the website "ASK" in "qa" environment_kc
    Then I should see "Environment: qa" on the page and verify page title_kc
    And "email" and "password" input field should be present_kc
    Then fill out "email" and "password" fields and "Sign In" as a teacher_kc
    When click "Quizzes" to land on quiz list_kc
    Then click on the "Create New Quiz" button_kc
    Then verify presence of quiz title field and quiz list button_kc
    When I type into the quiz title field_kc
    Then Add Question button appears_kc

  @totalQs0
  Scenario: Verify Add Question Button Disappears When Title Field Is Cleared
    When I erase the quiz title field_kc
    Then Add Question button should disappear_kc
    # The assertion of isDisplayed() is set true because the button remains and can produce a quiz without title.
    # Refer to Ticket: AUG23-703

  @totalQs1
  Scenario: Verify Minimum Number Of Question Allowed
    When I click on the Add Question button_kc
    Then "Q1" and Passing Rate will appear_kc
    Then complete required info of the question Q1_kc
    And save the quiz_kc
    Then go to the "List of Quizzes" and verify total questions of quiz_kc
    Then delete the quiz_kc

  @totalQs2
  Scenario: Verify Maximum Number of Question Allowed
    When I add 50 questions to the quiz_kc
    And save the quiz_kc
    Then go to the "List of Quizzes" and verify total questions of quiz_kc
    Then delete the quiz_kc


