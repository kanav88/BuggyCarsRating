@loginFeature
Feature: Login/Logout

  
  Scenario Outline: Login Buggy Cars Rating successfull with correct credentials
    Given User is on home page
    When User enters credentials "<username>" "<password>"
    Then User should be able to see logout button
    Examples:
    |username  |password  |
    |admin1    |Admin@123 |
    
    
  
  Scenario Outline: Login Buggy Cars Rating unsuccessfull with incorrect credentials
    Given User is on home page
    When User enters credentials "<username>" "<password>"
    Then User should be able to see failure message
    Examples:
    |username  |password  |
    |xyz       |Admin@123 |
    |admin1    |xyz@123   |
    
    
   
   Scenario Outline: Logout Buggy Cars Rating successfull
    Given User is on home page
    When User enters credentials "<username>" "<password>"
    Then User should be able to see logout button
    And User should be able to logout successfully
    Examples:
    |username  |password  |
    |admin1    |Admin@123 |