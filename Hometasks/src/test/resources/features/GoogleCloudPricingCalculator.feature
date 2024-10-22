Feature: Google Cloud Pricing Calculator
  Scenario: Verify Compute Engine estimation and all selected parameters
    Given User opens the Google Cloud Pricing Calculator page
    And User chooses Add to estimate
    When User fills the form with required data
    And User clicks on the detailed view link
    Then All filled data should be displayed on the Summary View page
    And The estimated cost should match