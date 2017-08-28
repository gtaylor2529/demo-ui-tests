Feature: Navigation
  As a user
  I want to be able to navigate the Valtech website
  So that I can find what I need

  Background:
    When I go to http://www.valtech.com

  Scenario: Homepage displays latest news
    Then the LATEST NEWS section is displayed

  Scenario Outline: Pages display correct headers
    When I navigate to the <pageName> page
    Then the <pageName> header is displayed

    Examples:
      | pageName      |
      | ABOUTsdada    |
      | SERVICESdadas |
      | WORKsadaa     |

  Scenario: Calculate number of Valtech offices
    When I open the contact page
    Then all of the Valtech offices will be displayed