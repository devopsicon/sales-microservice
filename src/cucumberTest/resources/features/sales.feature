Feature: Testing a Sales microservice REST API
  Users should be able to submit GET and POST requests to sales microservice

  Scenario: Data Upload to a web service
    When users create a new sale entry
    Then the server should handle it and return a success status

  Scenario: Data retrieval on a particular sale
    When users want to get information on a particular sale entry
    Then the requested data about sale entry is returned

  Scenario: Data retrieval on all sales entries
    When users want to get information on all sales entries
    Then the requested data about all sale entries are returned
