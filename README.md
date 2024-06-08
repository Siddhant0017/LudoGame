# LudoGame

This is a simple implementation of the classic Ludo game using Spring Boot. The project includes REST APIs to create a game, join a game, roll dice, move pieces, and get the game state.

#Features
Create a new game.
Join an existing game.
Roll dice.
Move a piece.
Retrieve the current game state.

#Assumptions
1. Maximum Number of Players: The game allows a maximum of 4 players.
2. Unique Player Names: Each player in a game must have a unique name.
3. UUID for Game ID: Each game is uniquely identified by a UUID.
4. Player Joining: Players can join a game only if the game exists and has less than 4 players.
5. Rolling Dice Logic: The dice roll returns a random number between 1 and 6.
6. Piece Movement: The move is always valid in the provided example.
7. Game State Management: The game state is stored and managed in-memory using a HashMap.

#Getting Started
1. Prerequisites
2. Java 8 or higher
3. Maven
4. Spring Boot
