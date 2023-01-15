Feature:
  Verify different GET operations using REST-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    Then I should see the author name as "typicode"

  Scenario: Verify authors of the posts
    Given I perform GET operation for "/post"
    Then I should see the author names

  Scenario: Verify Parameter of Get
    Given I perform GET operation for "/post"
    Then I should verify Get parameter

  Scenario: Verify QueryParameter of Get
    Given I perform GET operation for "/post"
    Then I should verify query parameter