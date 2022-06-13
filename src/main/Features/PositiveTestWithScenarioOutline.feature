Feature: successful test
@Regression @Smoke
  Scenario Outline: the car is already insured
    Given launching browser and going to webpage
    Then  Verify preCondition page
    When  User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
    And   click continue button
    Then  Verify Register Owner Page
    When  User setup car owner "<are you owner of the car>" and new or used "<the car is>"
    And   click continue button
    Then  Verify select vehicle page
    When  User set first registration date "<First Registration Date>" and hsn "<HSN>"  then tsn "<TSN>"
    And   click continue button
    Then  Verify show HsnTsnCar page
    And   click continue button
    Then  Verify enterRegistrationDate page
    When User set registration date "<Registration Date>"
    And click continue button
    Then  Verify enterBirthDate page
    When User enter BD "<birthday>"
    And click continue button

    Examples:
    |PreCondition                     |Inception Date        |are you owner of the car|the car is|First Registration Date|HSN|TSN |Registration Date|birthday|
    |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA| 072014          |08101967|
    |The car is already insured       |13072022              |No                      |used      |012020                 |7909|ABO| 012020          |01121967|
    |The car is already insured       |13072022              |Yes                     |used      |092016                 |0588|AAU| 072019          |07031967|
    |The car is already insured       |13072022              |No                      |used      |032000                 |0037|301| 022013          |05101997|
    |The car is already insured       |13072022              |Yes                     |used      |112007                 |0591|330| 122008          |08121987|



  Scenario Outline: The car will be insured
    Given launching browser and going to webpage
    Then  Verify preCondition page
    When  User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
    And   click continue button
    Then  Verify Register Owner Page
    When  User setup car owner "<are you owner of the car>" and new or used "<the car is>"
    And   click continue button
    Then  Verify select vehicle page
    When  User set first registration date "<First Registration Date>" and hsn "<HSN>"  then tsn "<TSN>"
    And   click continue button
    Then  Verify show HsnTsnCar page
    And   click continue button
    Then  Verify enterBirthDate page
    When User enter BD "<birthday>"
    And click continue button


    Examples:
      |PreCondition                     |Inception Date        |are you owner of the car|the car is|First Registration Date|HSN|TSN  |birthday|
      |The car will still be registered |12062022              |No                      |new       |082005                 |0009|301|10101993|