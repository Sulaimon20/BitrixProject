@logintest
Feature: Automating login functionality

  Background:
    Given User is on the Login page


  Scenario Outline: 1. As an authorized user I should be able to login
    When "<User>" login with username and password
    Then User should be on the Active Stream "<home page>"
    Examples:
      | User      | home page  |
      | HR        | Portal     |
      | Helpdesk  | Portal     |
      | Marketing | (1) Portal |

  Scenario Outline: 2. As an unauthorized user I should NOT be able to login
    When I login with username "<wrongUsername>" and password "<wrongPassword>"
    Then "Incorrect login or password" should be displayed.
    And I login with username "" and password ""
    Then "Incorrect login or password" should be displayed.
    Examples:
      | wrongUsername           | wrongPassword |
      | user@cybertekschool.com | userUser      |
      | 23492349234&*&*&        | %^&%^&%^&%^&  |
      | @-23pjsdjojsdf          | 0000000       |
      | -99999999               | 99999999      |
      | 0000000000              | 00000000000   |

