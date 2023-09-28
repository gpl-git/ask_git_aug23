@Webdriver
Feature:Webdriver Methods


  @Webdriver1
  Scenario: Validate responsive UI behavior
    Given I go to "sample"
    Then I should see page title
    And I wait
    When I resize window as desktop
    Then date should be displayed
    When I resize window to as tablet
    Then date should be displayed
    When I resize window to as phone
    Then date should not be displayed


  @Webdriver2
  Scenario:  Fill out and validate “Username” field. Validate minimal “Username” field
  length requirement as 2 characters
    Given I go to "sample"
    Then I should see page title
    When I type "a" into username
    And I click on email
    Then Username error should be displayed
    Then Username error should contain text "Please enter at least 2 characters."
    When I clear username element
    And I wait
    Then Username error should contain text "This field is required."
    When I type "aa" into username
    Then Username error should not be displayed
    And I wait

  @Webdriver3
  Scenario:  Validate ”Email” field behavior Validate that email field accepts only valid
  email addresses.
    Given I go to "sample"
    Then I should see page title
    When I type "a" into Email
    And I click on Username
    Then Email error should be displayed
    Then Email error should contain text "Please enter a valid email address."
    When I clear Email
    Then Email error should contain text "This field is required."
    When I type "a228@gmail.com" into Email
    Then Email error should not be displayed
    And I wait

  @Webdriver4
  Scenario:  Fill out and validate “Password” set of fields. Validate that Confirm
  Password is disabled if Password field is empty.
    Given I go to "sample"
    Then I should see page title
    When I type "a" into password
    And I click on confirm password
    When I type "a" into confirm password
    And I click on Username
    Then Password error should be displayed
    Then Password error should contain text "Please enter at least 5 characters."
    Then Confirm password error should be displayed
    Then Confirm password error should contain text "Please enter at least 5 characters."
    When I clear confirm password field
    When I clear password field
    And I click on Username
    Then Password error should contain text "This field is required."
    Then Confirm password error should contain text "This field is required."
    When I type "12345" into password
    When I type "12345" into confirm password
    Then Password error should not be displayed
    Then Confirm password error should not be displayed
    And I wait

  @Webdriver5
  Scenario:  Validate “Name” field behavior Modal dialog: verify that upon clicking inside of Name
  field popup dialog appears. Validate name concatenation.
    Given I go to "sample"
    Then I should see page title
    And I click on Name input field
    Then Name input fields should be displayed
    When I type "Naruto" into first name
    When I type "Sage" into middle name
    When I type "Uzumaki" into last name
    Then I click on confirmation
    Then Name should have attribute "value" as "Naruto Sage Uzumaki"
    And I wait

  @Webdriver6
  Scenario:  Validate that Accepting Privacy Policy is required to submit the form, then
  check the field
    Given I go to "sample"
    Then I should see page title
    When I type "Uzum4k1" into username
    When I type "Konoha@leafvillage.com" into Email
    When I type "Jiraya_the_best" into password
    And I click on confirm password
    When I type "Jiraya_the_best" into confirm password
    And I click on Name input field
    Then Name input fields should be displayed
    When I type "Naruto" into first name
    When I type "Sage" into middle name
    When I type "Uzumaki" into last name
    Then I click on confirmation
    Then Name should have attribute "value" as "Naruto Sage Uzumaki"
    Then I click on form submit
    Then Privacy policy error should be displayed
    Then Privacy policy error should contain text "- Must check!"
    Then I check on privacy policy
    Then I click on form submit
    Then element Privacy policy confirmation should be displayed on confirmation page
    Then element Privacy policy confirmation should contain text "true"
    And I wait

  @Webdriver7
  Scenario:  Validate info on conf page
    Given I go to "sample"
    Then I should see page title
    When I type "Uzum4k1" into username
    When I type "Konoha@leafvillage.com" into Email
    When I type "Jiraya_the_best" into password
    And I click on confirm password
    When I type "Jiraya_the_best" into confirm password
    And I click on Name input field
    Then Name input fields should be displayed
    When I type "Naruto" into first name
    When I type "Sage" into middle name
    When I type "Uzumaki" into last name
    Then I click on confirmation
    Then Name should have attribute "value" as "Naruto Sage Uzumaki"
    When I type "5615582394" into number input field
    Then I click on country in selector
    Then I click on male radio button
    Then I click on contact permission
    When I type "1234 Hugo st" into address input field
    Then I click on car make in selector
    Then I click on third party confirmation
    When I accept pop-up
    When I type "02/03/1995" into DoB field
    Then I check on privacy policy
    Then I click on form submit
    Then element first name should contain text "Naruto"
    Then element middle name should contain text "Sage"
    Then element last name should contain text "Uzumaki"
    Then element full name should contain text "Naruto Sage Uzumaki"
    Then element username should contain text "Uzum4k1"
    Then element password should contain text "[entered]"
    Then element email should contain text "Konoha@leafvillage.com"
    Then element Privacy policy confirmation should contain text "true"
    Then element phone number should contain text "5615582394"
    Then element country should contain text "Japan"
    Then element address should contain text "1234 Hugo st"
    Then element DoB should contain text "02/03/1995"
    Then element car make should contain text "Toyota"
    Then element allowed to contact should contain text "true"
    Then element gender should contain text "male"
    And I wait

  @Webdriver8
  Scenario:Submit the form and verify the data. Validate that after form submission entered fields values are present on the page. Validate that password is not displayed on the page
    Given I go to "sample"
    Then I should see page title
    When I type "Uzum4k1" into username
    When I type "Konoha@leafvillage.com" into Email
    When I type "Jiraya_the_best" into password
    And I click on confirm password
    When I type "Jiraya_the_best" into confirm password
    And I click on Name input field
    Then Name input fields should be displayed
    When I type "Naruto" into first name
    When I type "Sage" into middle name
    When I type "Uzumaki" into last name
    Then I click on confirmation
    Then Name should have attribute "value" as "Naruto Sage Uzumaki"
    Then I check on privacy policy
    Then I click on form submit
    Then element first name should contain text "Naruto"
    Then element middle name should contain text "Sage"
    Then element last name should contain text "Uzumaki"
    Then element full name should contain text "Naruto Sage Uzumaki"
    Then element username should contain text "Uzum4k1"
    Then element password should contain text "[entered]"
    Then element email should contain text "Konoha@leafvillage.com"
    Then element Privacy policy confirmation should contain text "true"
    And I wait