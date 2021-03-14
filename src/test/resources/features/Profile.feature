@profileFeature
Feature: Profile change

  Scenario Outline: Change profile of the user
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to profile page
    Then He can change his profile
    Examples:
    |username  |password  |
    |admin1    |Admin@123 |