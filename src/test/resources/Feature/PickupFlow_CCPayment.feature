Feature: validate pickupFlow

  Scenario: validate pickupFlow with CC
    Given launch application nonlogin
    When search product
    And upload templateFile 
    Then add to cart
    And proceed to checkout nonlogin
    And select pickup option
    Then continue to payment nonlogin
    Then select CC payment method nonlogin
    And click revirew order 
    Then submit order nonlogin
    And close browser