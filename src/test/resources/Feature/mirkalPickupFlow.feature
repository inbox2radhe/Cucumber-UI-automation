 Feature: validate ThirdPartyApp flow with pickUp

#  Scenario: validate ThirdPartyApp products
#    Given launch application 
#    When click on ThirdPartyApp templates
#    And select design of product 
#    And upload template
#    Then click add to cart
#    And proceed to checkout
#    And select pickup
#    Then continue to payment 
#    Then select CC payment method
#    And click review 
#    Then submit order
    
   Scenario Outline: validate ThirdPartyApp products
    Given launch application 
    When click on ThirdPartyApp templates
    And select ThirdPartyApp <productName>
    And upload template <productName>
    Then click add to cart
    And proceed to checkout
    And select pickup
    Then continue to payment 
    Then select CC payment method
    And click review 
    Then submit order
    
    Examples:
    |productName|
    |productOne11|
    |productTwo22|
    |productThree33|
    |Flyers|
    |Invitations|
 



    
    