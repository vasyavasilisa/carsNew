Feature:Car Test
@1
Scenario: Verify that site save right car's characteristics, according to the user choice
  Given I open http://www.cars.com
  When I select tab Read Specs & Reviews
    And Search for randomly selected characteristics for a car
    And On the Trims tab select the first available modification of the car
    And Remember the Available Engines, Transmissions of the car for later comparison
    And Go to the main page
    And Search for randomly selected characteristics for the second a car
    And On the Trims tab select the first available modification of the second car
    And Remember the Available Engines, Transmissions of the second car for later comparison
    And In the Trims list, select the first (current) modification for comparison, click Compare and then Compare Now
    And Select for comparison the first car (I press the button Add Another Car and choose the necessary model)



 Then I should see that the auto characteristics on the page correspond to those that were obtained in the previous steps