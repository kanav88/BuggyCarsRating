@popularMakeFeature
Feature: Popular Make page features

 
  Scenario Outline: Popular Make page - Navigate to car page
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to popular make page
    And User selects a "<car>"
    Then User should be able to navigate to "<car>" page
    Examples:
    |username  |password  |car         |
    |admin1    |Admin@123 |'Diablo'    |
    |admin1    |Admin@123 |'Veneno'    |
    |admin1    |Admin@123 |'Reventón'  |
    
    
    
  Scenario Outline: Popular Make page - Traverse to different pages
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to popular make page
    Then User should be able to navigate to other pages
    Examples:
    |username  |password  |
    |admin1    |Admin@123 |
    
 
    Scenario Outline: Popular Make page - Navigate back to home page
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to popular make page
    And User click home button
    Then User should be able to navigate back to home page
     Examples:
    |username  |password  |
    |admin1    |Admin@123 |