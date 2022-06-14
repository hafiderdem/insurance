Feature: negative tests

  @invalidInceptionDate
  Scenario Outline: invalid inception date
    Given launching browser and going to webpage
    When User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
    Then Verify continue button is not enabled

    Examples:
    |PreCondition                    |Inception Date|
    # DATE IN THE PAST
    |The car is already insured      |10062022      |
    |The car will still be registered|16062023      |
    #DATE IN THE FUTURE : MORE THAN 1 YEAR FROM CURRENT DATE
    |The car is already insured      |16062023      |
    |The car will still be registered|16062023      |
    #SENDING SPECIAL CHARACTERS AS DATE
    |The car is already insured      |,./=-!@$      |
    |The car will still be registered|)(*&^%$#      |
    #SENDING LETTERS
    |The car is already insured      |ASDFGHJK      |
    |The car will still be registered|QWERTYUI      |


    @invalidInputOnSelectVehiclePage
  Scenario Outline: invalid first registration date,hsn & tsn

  Given launching browser and going to webpage
  When User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
  And click continue button
  When User setup car owner "<are you owner of the car>" and new or used "<the car is>"
  And click continue button
  When User set first registration date "<First Registration Date>" and hsn "<HSN>"  then tsn "<TSN>"
  Then Verify continue button is not enabled

  Examples:

   # first registration -- >  cant be more than 40 years old, can't be more than 1 year from current month
  # hsn--> cant be letters, cant be less than 4 digits
  #tsn --> cant be less than 3 digits

    |PreCondition                     |Inception Date        |are you owner of the car|the car is|First Registration Date|HSN |TSN |
    |The car is already insured       |16072022              |Yes                     |used      |061980                 |0005|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |082023                 |0005|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |                       |0005|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |0619                   |0005|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |!@#$%^                 |0005|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |QWERTY                 |0005|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |071999                 |005 |AAA |
    |The car is already insured       |16072022              |Yes                     |used      |071999                 |QWER|AAA |
    |The car is already insured       |16072022              |Yes                     |used      |062000                 |0005|AA  |
    |The car is already insured       |16072022              |Yes                     |used      |062004                 |!@#$|!@# |
    |The car is already insured       |16072022              |Yes                     |used      |062009                 |    |AAA |
    |The car is already insured       |16072022              |Yes                     |used      |061980                 |0005|    |


      @invalidInputOnRegistrationDatePage
  Scenario Outline: invalid registration date
    Given launching browser and going to webpage
    When  User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
    And   click continue button
    When  User setup car owner "<are you owner of the car>" and new or used "<the car is>"
    And   click continue button
    When  User set first registration date "<First Registration Date>" and hsn "<HSN>"  then tsn "<TSN>"
    And   click continue button
    Then  Verify show HsnTsnCar page
    And   click continue button
    When User set registration date "<Registration Date>"
    Then Verify continue button is not enabled

  Examples:
  # it can't be 1 year head of cuurent date
  # registration date to you can not be before first registration date
    |PreCondition                     |Inception Date        |are you owner of the car|the car is|First Registration Date|HSN |TSN |Registration Date|
    |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA |041998           |
    |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA |072023           |


  @invalidBD
  Scenario Outline: invalid birthdate
    Given launching browser and going to webpage
    When  User setup pre conditions "<PreCondition>" and  insurance starting day "<Inception Date>"
    And   click continue button
    When  User setup car owner "<are you owner of the car>" and new or used "<the car is>"
    And   click continue button
    When  User set first registration date "<First Registration Date>" and hsn "<HSN>"  then tsn "<TSN>"
    And   click continue button
    Then  Verify show HsnTsnCar page
    And   click continue button
    When User set registration date "<Registration Date>"
    And click continue button
    When User enter BD "<birthday>"
    Then Verify continue button is not enabled

    Examples:
    # dates before 01.01.1906
    #under 18 years old
      |PreCondition                     |Inception Date        |are you owner of the car|the car is|First Registration Date|HSN|TSN |Registration Date|birthday|
      |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA| 072014          |01011905|
      |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA| 072014          |01072004|
      |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA| 072014          |        |
      |The car is already insured       |13072022              |Yes                     |used      |051998                 |0005|AAA| 072014          |AA!@#$#^|



