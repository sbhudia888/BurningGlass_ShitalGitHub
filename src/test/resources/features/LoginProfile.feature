@LoginProfile
Feature: Login Profile
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Background: User navigates to Company home page
    Given I am on the "Company home" page on URL "https://www.burning-glass.com/uk"
    Then I should see "Burning Glass Technologies United Kingdom" message

  Scenario: Navigate to Solutions page
    When I navigate to "Solutions" page from top menu bar
    Then I should see "Solutions" message
#    Then I should have landed in "Solutions" page
#    And below sections would be listed in "Solutions" page
#      | Corporations            |
#      | Education                |
#      | Government and Workforce |
#      | Recruiting and Staffing  |
#      | Strategic Partnerships  |

  Scenario: Verify Navigate to About page
    When I navigate to "About" page from top menu bar
    Then I should see "About Us" message
#    And below sections would be listed in "About" page
#      | Schedule a Demo        |
#      | Find Your Solution     |
#      | Have questions for us? |

  Scenario: Verify Navigate to About page
    When I navigate to "Research" page from top menu bar
    Then I should see "Insights based on real-time job data" message
