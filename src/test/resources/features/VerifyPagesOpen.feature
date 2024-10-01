@smokeTest

Feature: Page Navigation
  As a user
  I want to navigate through different pages
  So that I can verify they open and function correctly

  @homePageTest
  Scenario: Navigate to Home Page
    Given I am on the Home page
    Then  I should see the Home page features displayed
    And   the page URL should be "https://s4e.io/"

  @platformPageTest
  Scenario: Navigate to Platform Page
    Given I am on the Home page
    When  I navigate to the "Platform" page
    Then  I should see the Platform page elements displayed
    And   the page title should be "Platform | S4E"

  @pricingPageTest
  Scenario: Navigate to Pricing Page
    Given I am on the Home page
    When  I navigate to the "Pricing" page
    Then  I should see the pricing plans displayed
    When  I move the slider to 5 websites or IP addresses
    Then  the plan prices should update accordingly
    When  I move the slider to 10 websites or IP addresses
    Then  the plan prices should update accordingly
    And   the page URL should be "https://s4e.io/pricing"


  @joinPageTest @signUpPageTest
  Scenario: Navigate to Join Page
    Given I am on the Home page
    When  I navigate to the "Join" page
    Then  the page URL should be "https://app.s4e.io/sign-up"
    And   I fill out the signup form with valid data
    And   I submit the form
    Then  I should see the Confirmation Required page


    ### Ve dahası....
