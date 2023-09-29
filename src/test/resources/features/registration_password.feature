@registration
  Feature: Registration Password/Confirm Password
    
    @registration1
    Scenario: Verify Password/Confirm password field (min(5) characters)
      Given I open "login" page vs
      Then I click button "Register Now" vs
      Then I type "a" into password field vs
      And I click on "Confirm Password" field vs
      And I wait for 2 sec
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
        Scenario: Verify Password must match Confirm Password

          Given I open "login" page vs
          Then I click button "Register Now" vs
          Then I type "abc123" into password field vs
          Then I type "abc12" into confirm password field vs
          And I wait for 2 sec
          Then I click on "Group Code" field vs
          Then the error message "Entered passwords should match" is displayed vs
          Then I clear confirm password field vs
          And I wait for 2 sec
          When I type "abc12" into password field vs
          Then the password error message is not displayed vs
          Then I type "abc12" into confirm password field vs

















