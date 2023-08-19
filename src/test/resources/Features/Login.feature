Feature: Login feature

  @smoke
  Scenario: validate login functionality with valid credential
    When provide username and password
    And click on login button
    Then home page should display
