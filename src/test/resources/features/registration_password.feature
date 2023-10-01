@registration
  Feature: Registration Password/Confirm Password


    @registration1
    Scenario: Verify Password/Confirm password field (min(5) characters)
      Given I open "login" page vs
      Then I click button "Register Now" vs
      Then I type "Test" into first name field vs
      And I wait for 2 sec
      Then I type "Tester" into last name field vs
      Then I type "test@test.com" into email field vs
      Then I type "AA" into group code field vs
      And I wait for 2 sec
      Then I type "a" into password field vs
      And I click on "Confirm Password" field vs
      Then the password error message "Should be at least 5 characters" is displayed vs
      When I clear password field vs
      Then the password error message "This field is required" is displayed vs
      When I type "abc12" into password field vs
      Then the password error message is not displayed vs
      Then I type "abc12" into confirm password field vs


      @registration2
      Scenario: Verify Password/confirm password field (max(32) characters)
        Given I open "login" page vs
        Then I click button "Register Now" vs
        Then I type "Test" into first name field vs
        And I wait for 2 sec
        Then I type "Tester" into last name field vs
        Then I type "test@test.com" into email field vs
        Then I type "AA" into group code field vs
        And I wait for 2 sec
        Then I type "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" into password field vs
        And I click on "Confirm Password" field vs
        Then the password error message "Not more then 32 characters" is displayed vs

#        this step will fail,because it's a bug(more then 32 char are allowed)

        When I clear password field vs
        Then the password error message "This field is required" is displayed vs
        When I type "abc12" into password field vs
        Then the password error message is not displayed vs
        Then I type "abc12" into confirm password field vs

        @registration3
        Scenario: Verify Password must match Confirm Password. Error message is displayed

          Given I open "login" page vs
          Then I click button "Register Now" vs
          Then I type "Test" into first name field vs
          And I wait for 2 sec
          Then I type "Tester" into last name field vs
          Then I type "test@test.com" into email field vs
          Then I type "AA" into group code field vs
          And I wait for 2 sec
          Then I type "abc123" into password field vs
          Then I type "abc12" into confirm password field vs
          And I wait for 2 sec
          Then I click button "Register Me" vs
          Then the error message "Entered passwords should match" is displayed vs
          Then I clear confirm password field vs
          And I wait for 2 sec
          When I type "abc12" into password field vs
          Then the password error message is not displayed vs
          Then I type "abc12" into confirm password field vs

          @registration4
          Scenario: Verify Password/Confirm Password field can not be empty. The error message is displayed

            Given I open "login" page vs
            Then I click button "Register Now" vs
            Then I type "Test" into first name field vs
            And I wait for 2 sec
            Then I type "Tester" into last name field vs
            Then I type "test@test.com" into email field vs
            Then I type "AA" into group code field vs
            And I wait for 2 sec
            Then I click button "Register Me" vs
            Then the error message "This field is required" is displayed vs
            And I wait for 2 sec

            @registration5
            Scenario: Verify Password/Confirm Password field does not allow white space

              Given I open "login" page vs
              Then I click button "Register Now" vs
              Then I type "Test" into first name field vs
              And I wait for 2 sec
              Then I type "Tester" into last name field vs
              Then I type "test@test.com" into email field vs
              Then I type "AA" into group code field vs
              And I wait for 2 sec
              Then I type "abc  123" into password field vs
              Then I type "abc  123" into confirm password field vs
              Then I click button "Register Me" vs
              And I wait for 2 sec
              Then the error message "Whitespaces are not allowed" is displayed vs

              @registration6
              Scenario: Verify Password/Confirm Password field is masked

                Given I open "login" page vs
                Then I click button "Register Now" vs
                Then I type "Test" into first name field vs
                And I wait for 2 sec
                Then I type "Tester" into last name field vs
                Then I type "test@test.com" into email field vs
                Then I type "AA" into group code field vs
                And I wait for 2 sec
                Then I type "abc123" into password field vs
                Then I type "abc123" into confirm password field vs
                Then I verify that the password is masked vs

    @registration7
    Scenario Outline: Verify Password/Confirm password field((min),(max)) char
      Given I open <url> page vs
      Then I click button <btnName> vs
      Then I type <first_name> into first name field vs
      And I wait for <sec> sec
      Then I type <last_name> into last name field vs
      Then I type <email> into email field vs
      Then I type <group_code> into group code field vs
      And I wait for <sec> sec
      Then I type <password> into password field vs
      And I click on <arg0> field vs
      Then the password error message <expectedError> is displayed vs
      When I clear password field vs
      Then the password error message <expectedError1> is displayed vs
      When I type <password1> into password field vs
      Then the password error message is not displayed vs
      Then I type <confirmPassword> into confirm password field vs
      Examples:
        | url     | btnName        | first_name | sec | last_name | email           | group_code | password | arg0               | expectedError                     | expectedError1           | password1 | confirmPassword |
        | "login" | "Register Now" | "Test"     | 2   | "Tester"  | "test@test.com" | "AA"       | "a"      | "Confirm Password" | "Should be at least 5 characters" | "This field is required" | "abc12"   | "abc12"         |

        | "login" | "Register Now" | "Test"     | 2   | "Tester"  | "test@test.com" | "AA"       | "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"| "Confirm Password" | "Error. Max 32 characters" | "This field is required" | "abc12"   | "abc12"         |

        | "login" | "Register Now" | "Test"     | 2   | "Tester"  | "test@test.com" | "AA"       | "abc  123"| "Confirm Password" | "Whitespaces are not allowed" | "This field is required" | "abc  123"   | "abc  123"         |


    @registration8
    Scenario:Verify Password must match Confirm Password.

      Given I open "login" page vs
      Then I click button "Register Now" vs
      Then I type "Test" into first name field vs
      And I wait for 2 sec
      Then I type "Tester" into last name field vs
      Then I type "test@test.com" into email field vs
      Then I type "AA" into group code field vs
      And I wait for 2 sec
      Then I type "abc123" into password field vs
      Then I type "abc123" into confirm password field vs
      Then I type "45" into password field
      And I wait for 2 sec
      Then the error message "Entered passwords should match" is displayed vs

#      The error message was not displayed, the user was allowed to register

      Then I click button "Register Me" vs














              
              


            





















