@login
  
  Feature: login predefined steps
    
   @login1
   Scenario: Valid email and valid password combination lets teacher user in
     Given I open "login" page

     And I should see page title
     When I type "qzwxecrv@proklain.com" into email field
     And I type "ABC123" into password field
     And I wait for 1 sec
     And I click button "Sign In"
     And I wait for 1 sec
     When I open "http://ask-qa.portnov.com/#/home" page
     Then user name 'Max Smith' is present
     And I wait for 1 sec
     Then user role 'TEACHER' is present
     And I wait for 1 sec

     @login2
     Scenario: Valid email and valid password combination lets student user in
       Given I open "login" page
       When I type "kmh111@uuluu.net" into email field
       And I type "ABC123" into password field
       And I wait for 1 sec
       And I click button "Sign In"
       And I wait for 1 sec
       When I open "http://ask-qa.portnov.com/#/home" page
       Then user name 'Name Lastname' is present
       And I wait for 1 sec
       Then user role 'STUDENT' is present
       And I wait for 1 sec

       @login3
       Scenario: Valid email and incorrect password
         Given I open "login" page
         When I type "kmh111@uuluu.net" into email field
         And I type "abc123" into password field
         When I click button "Sign In"
         And I get allert "Authentication failed. User not found or password does not match"
         And I wait for 2 sec


    @login4
    Scenario: Email field is Case insensitive
      Given I open "login" page
      When I type "Kmh111@uuluu.net" into email field
      And I type "ABC123" into password field
      And I wait for 1 sec
      And I click button "Sign In"
      And I wait for 1 sec
      When I open "http://ask-qa.portnov.com/#/home" page
      Then user name 'Name Lastname' is present
      And I wait for 1 sec
      Then user role 'STUDENT' is present
      And I wait for 1 sec


         @login5
           Scenario: Invalid email and valid password(PWD field Case sensitive)
           Given I open "login" page
           When I type "kmh11123@uuluu.nett" into email field
           And I type "ABC123" into password field
           When I click button "Sign In"
           And I get allert "Authentication failed. User not found or password does not match"
           And I wait for 2 sec


         @login6
         Scenario: Password field is masked and copy/paste is not allowed
           Given I open "login" page
           When I type "kmh111@uuluu.net" into email field
           And I type "ABC123" into password field
           Then I verify that password field is masked

          @login7
          Scenario: Leading and trailing spaces are not allowed
            Given I open "login" page
            When I type " kmh111@uulu u.net" into email field
            And I type "ABC123" into password field
            Then element with xpath "//input[@formcontrolname='email']" should be disabled
            Then element with xpath "//label[@id='email'-error']" should contain text "Should be a valid email address."































