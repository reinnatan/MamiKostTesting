@tag
Feature: Test search border house in mami kost
    Test search border house in mami kost

    @tag1
    Scenario: User search border house near dipo tower
        Given User input dipo tower keyword
        When User sorting the price from the lowest price
        Then User get top 3 the lowest price of the border house
