@overallRatingFeature
Feature: Overall rating page features


  Scenario Outline: Overall rating - Navigate to different make
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to overall rating page
    And User selects a "<make>"
    Then User should be able to navigate to "<makeName>" page
    Examples:
    |username  |password  |make         |makeName                   |
    |admin1    |Admin@123 |'Alfa Romeo' |'Alfa Romeo'               |
    |admin1    |Admin@123 |'Pagani'     |'Pagani Automobili S.p.A.' |
    |admin1    |Admin@123 |'Lancia'     |'Lancia'                   |
    

    Scenario Outline: Overall rating - Navigate to different model
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to overall rating page
    And User selects a "<car>"
    Then User should be able to navigate to "<carName>" page
    Examples:
    |username  |password  |car         |carName                    |
    |admin1    |Admin@123 |'Diablo'    |'Diablo'                   |
    |admin1    |Admin@123 |'Zonda'     |'Pagani Zonda Revolucion'  |
    |admin1    |Admin@123 |'Rally 037' |'Lancia 037 Stradale'      |
    
    
    Scenario Outline: Overall rating - page should not be forwarded after last page
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to overall rating page
    And User input page "<page>"
    Then page forward button should be disabled
     Examples:
    |username  |password  |page  |
    |admin1    |Admin@123 |7     |
    

     Scenario Outline: Overall rating - Author should be updated after commenting
    Given User is on home page
    And User enters credentials "<username>" "<password>"
    And User should be able to see logout button
    When User goes to overall rating page
    And User selects a "<car>"
    Then Author name should be updated
    Examples:
    |username  |password  |car         |carName                    |
    |admin1    |Admin@123 |'Diablo'    |'Diablo'                   |