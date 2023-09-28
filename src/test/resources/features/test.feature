@test
Feature:  Test

  @test1
  Scenario: Hello
    Given I print "Hello World"

@test2
    Scenario:  Login
      Given I go to "login"
      When I login as a teacher
      And I click button "Sign In"
      And I wait for 1 sec
      Then "TEACHER" home page is displayed
