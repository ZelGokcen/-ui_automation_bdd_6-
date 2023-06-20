
@Regression

// Every feature MUST start with a Feature and one Feature only, but multiple Scenarios
Feature: Google search functionality

// Every test MUST start with a Scenario or Scenario Outline
  //Scenario should have meaningful name.

  @Google
  Scenario Outline: Validate the title and url after search
    Given user navigates to "https://www.google.com"
    When user search for "<input>"
    Then user should see "<input>" in the url
    And user should see "<input>" in the title

    Examples:
      | input     |
      | Tesla     |
      | Apple     |
      | Microsoft |
      | Amazon    |