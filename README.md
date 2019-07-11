# Number Game

The game prompts the player to input 4 unique number digits separated by space, 
and then provides a hint on how much they match the target number array in below format. 

*\<NUMBER\> A \<NUMBER\> B*

where the number before A indicates how many digits are matched at the correct positions, and the
number before B indicates how many digits are matched but not necessarily at the correct positions. 

E.g. given a target 

`1 2 3 4`

user input 

`3 2 6 1`

game hint

`1 A 3 B`

This is because number 2 is guessed correctly at the correct position, 1 and 3 are guessed correctly but not at the correct positions. 

The game ends when all number digits are guessed correctly at the right positions, indicated by `4 A 4 B`. 

## Object Modelling

`NumberReader` - Reads and validates user input into an array <br />
`MatchChecker` - Interface for number match check <br />
`PositionChecker` - Implementation of `MatchChecker` for position check <br />
`OccurrenceChecker` - Implementation of `MatchChecker` for occurrence check <br />
`MatchResult` - Composite match check result with a count and code, e.g. `3 A` <br />
`NumberChecker` - Master checker that takes in individual checkers to perform the match check <br />
`GameModerator` - Game moderator that assembles all parts together and renders the game <br />

## Unit test

`mvn test`