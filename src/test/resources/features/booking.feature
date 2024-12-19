Feature: Search hotel

  Scenario: Looking for 'Akra Kemer'
    Given booking search page is opened
    When user performs search by "Akra Kemer"
    Then "Akra Kemer - Ultra All Inclusive " hotel is shown

  Scenario Outline: Looking for 'Meraki'
    Given booking search page is opened
    When user performs search by "<hotel>"
    Then "<expectedResult>" hotel is shown
    Examples:
      | hotel      | expectedResult                   |
      | Akra Kemer | Akra Kemer - Ultra All Inclusive |
      | Meraki     | Meraki Resort - Adults Only      |