Feature: Login
  As a user
  I should login and use the application
@login @regression
  Scenario: Validate login with valid credentials
    Given I'm on home page "https://www.next.co.uk/"
    When I click on My Account link
    And I enter the username "anu@gmail.com"
    And I enter the password "ljdf"
    And I click the login Button
    Then I should successfully and redirected to Account Page
@login @regression @invalid
    Scenario: Validate login wth invalid credentials
      Given I'm on home page "https://www.next.co.uk/"
      When I click on My Account link
      And I enter the username "anurail.com"
      And I enter the password "kdfjda"
      And I click the login Button
      Then I should not be able to login
@regression
  Scenario: Validate login wth no credentials
    Given I'm on home page "https://www.next.co.uk/"
    When I click on My Account link
    And I enter the username ""
    And I enter the password ""
    And I click the login Button
    Then I should not be able to login


