Feature: Validating StarWars API


Scenario: -	The API should be able to return a list of all the Star Wars characters
Given Get Character request
When User calls "GetAllCharacter" with get http request
Then the api call is success with status code "200"
And "count" in response is "82"


Scenario Outline: -	The API should be able to return the details of a specified Star Wars Character
Given Get special Character request with "<NAME>"
When User calls for request with "GetAllCharacter"
Then the api call for get special character is success with status code "200"
And name in response should be "<NAME>"

Examples:
|NAME			|
|Darth Vader	|

Scenario: -	The API should be able to return a list of all the Star Wars planets
Given Get Planet request
When User calls "GetAllPlanets" api with get http request method
Then the api call should be a success with status code "200"
And "count" of planets in response is "60"

Scenario Outline: -	The API should be able to return the details of a specified Star Wars planet
Given Get special planet request with "<NAME>"
When User calls api "GetAllPlanets" to get the desired planet 
Then the api call for get special planet is success with status code "200"
And Planet name in response should be "<NAME>"

Examples:
|NAME			|
|Dagobah		|