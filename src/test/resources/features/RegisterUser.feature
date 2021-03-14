@registerFeature
Feature: Register User


  Scenario: Register as User
    Given User is on home page
    When User goto register page
    Then User should be able to register successfully

    