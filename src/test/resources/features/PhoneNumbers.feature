@phoneNumbers
Feature: PhoneNumbers

Business Need: define the business need for this feature

  Scenario: Verify the telephone number for 7 Day Print (HND) Checkout flow
    Given user is on "7 Day Print HND" subscription url
    When he create a new account
    And he continue with the retailer and delivery start date
    And he continue with the delivery instructions
    And he selects payment type as "cardPayment"
    And he enters the "Non3DS.card" details and confirms payment
    Then he can confirm the "7 Day Print HND" on his account subscriptions details
    And he can confirm the "checkout-flow" phone number for "7 Day Print HND"

  Scenario: Verify the telephone number for Weekend Print (HND) Checkout flow
    Given user is on "Weekend Print (HND)" subscription url
    When he create a new account
    And he continue with the retailer and delivery start date
    And he continue with the delivery instructions
    And he selects payment type as "cardPayment"
    And he enters the "Non3DS.card" details and confirms payment
    Then he can confirm the "Weekend Print (HND)" on his account subscriptions details
    And he can confirm the "checkout-flow" phone number for "Weekend Print (HND)"
