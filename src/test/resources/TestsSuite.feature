Feature: Make a payment via Demo99

  Background:
    Given : The user wants to go to Gateway

  @Smoke
  Scenario: Header verification
    When The user wants to verify that the header is present as "Mother Elephant With Babies Soft Toy"

  @Smoke
  Scenario: Verify the toy price
    When The user wants to verify that the toy price is "$20"

  @Smoke
  Scenario: Verify the URL
    When The user wants to verify that the URL contains "payment-gateway"

  @Smoke
  Scenario: Verify that payment is successfully completed
    When The user wants to have quantity as "5"
    And The user wants to click Buy button
    And The user wants to enter information about payment as
      | cardnumber  | 55555555555555555     |
      | expiryMonth | 12   |
      | ExpiryYear  | 2022 |
      | CVVCode     | 234  |
    And The user wants to click pay button
    Then The user wants to verify that "Payment successfull!"

  @Regression
  Scenario Outline:
    When The user wants to choose different "<quantity>"
    And The user wants to click Buy button
#    And The user wants to enter payment information
    And The user wants to enter information about payment as
      | cardnumber  | 55555555555555555     |
      | expiryMonth | 12   |
      | ExpiryYear  | 2022 |
      | CVVCode     | 234  |
    And The user wants to click pay button
    Then The user wants to verify that "Payment successfull!"

    Examples:
      |quantity|
      |5       |
      |8       |
      |9       |
      |2       |
      |4       |



