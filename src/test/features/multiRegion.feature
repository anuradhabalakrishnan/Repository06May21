Feature: Multi Region Test
  As a user on choosing a region
  I should get re-directed to appropriate domain
  
  @region @regression
    Scenario Outline: : Validate multi region feature
    Given I'm on home page "https://www.next.co.uk/"
    When I click language icon on header
    And I choose a region "<region>"
    And I select the language"<language>"
    And I click shop now button
    Then I should be on the appropriate domain"<domain>"

    Examples:
    |region  |language  |domain                                             |
    |  SE    |    sv    | https://www.next.se/sv                            |
    |  AU    |    EN    | https://www.next.com.au/en                        |
