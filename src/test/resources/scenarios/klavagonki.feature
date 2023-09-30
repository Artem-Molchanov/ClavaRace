Feature: Bot for Klavagonki
  Background: I'm on the main page
    Given Open URL "https://klavogonki.ru/go?type=normal"

    Scenario: Bot starts the game and enters words
      When We start the game
      And wait for game start
      And enter highlighted word in cycle
      Then ensure that the game is ended and it has a number of symbols not less than 1500