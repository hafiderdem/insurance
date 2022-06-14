Feature: Insurance calculation with different path
  Scenario Outline: manual path
    Given launching browser and going to webpage
    Then  Verify preCondition page
    When  User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
    And   click continue button
    Then  Verify Register Owner Page
    When  User setup car owner "<are you owner of the car>" and new or used "<the car is>"
    And   click continue button
    Then  Verify select vehicle page
    And User choose make "<brand>"
    Then Verify select model page
    When User choose model "<Model>"
    Then Verify select body type page
    When User select body type "<Body Type>"
    Then Verify fuel type page
    When User select fuel type "<Fuel Type>"
    Then Verify select engine power page
    When User select engine power "<Engine Power>"
    Then Verify select engine page
    When User select engine "<Engine>"
    Then Verify enterRegistrationDate page
    When User set first registration date "<First Registration Date>" and "<Owner Registration Date>"
    And click continue button
    Then Verify enterBirthDate page
    When User enter BD "<BirthDate>"
    And click continue button

    Examples:
    |PreCondition                     |Inception Date        |are you owner of the car|the car is|brand|Model  |Body Type|Fuel Type|Engine Power   |Engine              |First Registration Date|Owner Registration Date|BirthDate|
    |The car will still be registered |12072022              |No                      |new       |AUDI |audi tt|Coupe    |Benzin   |145 kW / 197 PS|AUDI TT 40 TFSI     | 062005                |N/A                    |10061988|
    |The car is already insured       |12072022              |Yes                     |used      |AUDI |audi tt|Coupe    |Benzin   |145 kW / 197 PS|AUDI TT 40 TFSI     | 062005                |072009                 |10061995|
    |The car is already insured       |20062022              |Yes                     |new       |BMW  |5er    |Kombi    |Diesel   |294 kW / 400 PS|M550D TOURING XDRIVE| 042022                |N/A                    |10102000|

