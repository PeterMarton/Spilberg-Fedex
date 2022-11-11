@language_select
Feature: Landing page

  @smoke
  Scenario: As a user I am able to navigate to the fedex site
    When I go to the main page
    Then The CHOOSE_LOCATION page is loaded successfully

  @regression
  Scenario Outline: As a user I am able to select my location on the site
    When I go to the main page
    Then The CHOOSE_LOCATION page is loaded successfully
    When I select <country> with <position> option as location
    Then I redirected to the expected page
    Examples:
      | country | position |
      | Hungary | first    |
      | Hungary | second   |
      | Italy   | second   |

  Scenario: As a user I am able to select language on the location selection page
    When I go to the main page