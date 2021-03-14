@popularModelFeature
Feature: Popular Model page features

  
  Scenario: Popular Model page - Vote and comment
    Given User is on home page
    When User goto register page
    And User should be able to register successfully
    And Login with new User
    And goto popular model page
    Then User is able to vote
    And comment is updated in the table