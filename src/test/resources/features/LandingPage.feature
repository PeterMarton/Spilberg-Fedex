@language_select
Feature: Landing page

  @smoke
  Scenario: As a customer I am able to navigate to the fedex site
    When I go to the main page
    Then I am on the CHOOSE_LOCATION page

  @smoke @cookies
  Scenario: As a customer I see cookies at the home page with hu-hu language
    When I go to HOME page with direct link with hu-hu language settings
    Then I am on the HOME page with hu-hu language
    And Cookie option popped up

  @regression
  Scenario Outline: As a customer I am able to select my location on the site
    When I go to the main page
    Then I am on the CHOOSE_LOCATION page
    When I select <country> with <position> option as location
    Then I was redirected to the expected page
    Examples:
      | country | position |
      | Hungary | first    |
      | Hungary | second   |
      | Italy   | second   |

  @language
  Scenario: As a customer I am able to select language on the location selection page
    When I go to the main page of China in default language
    And My location is different HU
    Then I see location selection option
    When I select language HU-HU
    Then I am on the HOME page with language HU-HU

  @location
  Scenario: As a customer I go to location finder from the home page
    When I go to HOME page with direct link with en-us language settings
    And I select locations
    Then I am on the LOCATION page

  @invalid @parcel
  Scenario: As a customer I search for parcel with invalid number
    When I go to the main page of Italy in default language
    And I select language EN-IT
    And I search parcel with number 1234
    Then I am on the FEDEX_TRACK_ERROR page
    And I see message "Unfortunately we are unable to retrieve your tracking results at this time. Please try again later."

  @shipping
  Scenario: As a customer I can open dropdown menu
    When I go to the main page of Italy in default language
    And I select language EN-IT
    And I select international shipping
    Then I see 10 submenus in the list

  @smoke @login
  Scenario: As a customer I want to login
    When I go to HOME page with direct link with en-us language settings
    Then I am on the HOME page with en-us language
    When I select login
    Then  I am on the LOGIN page with en-us language



