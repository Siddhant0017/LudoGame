
# Ludo Game

This is a simple implementation of the classic Ludo game using Spring Boot. The project includes REST APIs to create a game, join a game, roll dice, move pieces, and get the game state.

## Features

- Create a new game.
- Join an existing game.
- Roll dice.
- Move a piece.
- Retrieve the current game state.

## Assumptions

1. **Maximum Number of Players**: The game allows a maximum of 4 players.
2. **Unique Player Names**: Each player in a game must have a unique name.
3. **UUID for Game ID**: Each game is uniquely identified by a UUID.
4. **Player Joining**: Players can join a game only if the game exists and has less than 4 players.
5. **Rolling Dice Logic**: The dice roll returns a random number between 1 and 6.
6. **Piece Movement**: The move is always valid in the provided example.
7. **Game State Management**: The game state is stored and managed in-memory using a HashMap.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- Spring Boot

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/ludo-game.git
   cd ludo-game
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   The application will be running at `http://localhost:8080`.

## Testing the API with Postman

### Setup Postman

1. **Download and install Postman** from [Postman website](https://www.postman.com/downloads/).
2. **Open Postman** and create a new workspace (optional).

### API Endpoints

#### Create a Game

**Request**:
- **Method**: POST
- **URL**: `http://localhost:8080/game/createGame`

**Steps**:
1. Open Postman and create a new request.
2. Set the request type to `POST`.
3. Enter the URL: `http://localhost:8080/game/createGame`.
4. Click `Send`.
5. You should receive a response with the `gameId`.


#### Join a Game

**Request**:
- **Method**: POST
- **URL**: `http://localhost:8080/game/joinGame`
- **Body**: `x-www-form-urlencoded`
  - `gameId`: `<gameId>`
  - `playerName`: `Player1`

**Steps**:
1. Create a new request in Postman.
2. Set the request type to `POST`.
3. Enter the URL: `http://localhost:8080/game/joinGame`.
4. Go to the `Body` tab and select `x-www-form-urlencoded`.
5. Add the following key-value pairs:
   - `gameId`: Paste the `gameId` from the create game response.
   - `playerName`: Enter a player name (e.g., `Player1`).
6. Click `Send`.
7. You should receive a response confirming the player has joined the game.

**Example Response**:
```json
"Player joined the game"
```

#### Roll Dice

**Request**:
- **Method**: POST
- **URL**: `http://localhost:8080/game/rollDice`
- **Body**: `x-www-form-urlencoded`
  - `gameId`: `<gameId>`
  - `playerName`: `Player1`

**Steps**:
1. Create a new request in Postman.
2. Set the request type to `POST`.
3. Enter the URL: `http://localhost:8080/game/rollDice`.
4. Go to the `Body` tab and select `x-www-form-urlencoded`.
5. Add the following key-value pairs:
   - `gameId`: Use the same game ID.
   - `playerName`: The name of the player rolling the dice.
6. Click `Send`.
7. You should receive a response with the dice value.

**Example Response**:
```json
5
```

#### Move Piece

**Request**:
- **Method**: POST
- **URL**: `http://localhost:8080/game/movePiece`
- **Body**: `x-www-form-urlencoded`
  - `gameId`: `<gameId>`
  - `playerName`: `Player1`
  - `pieceId`: `1`
  - `steps`: `5`

**Steps**:
1. Create a new request in Postman.
2. Set the request type to `POST`.
3. Enter the URL: `http://localhost:8080/game/movePiece`.
4. Go to the `Body` tab and select `x-www-form-urlencoded`.
5. Add the following key-value pairs:
   - `gameId`: Use the same game ID.
   - `playerName`: The name of the player moving the piece.
   - `pieceId`: The ID of the piece to move (e.g., 1, 2, 3, 4).
   - `steps`: The number of steps to move the piece (use the dice value received from the "Roll Dice" request).
6. Click `Send`.
7. You should receive a response confirming the piece move.

**Example Response**:
```json
"Piece moved successfully"
```

#### Get Game State

**Request**:
- **Method**: GET
- **URL**: `http://localhost:8080/game/gameState`
- **Parameters**:
  - `gameId`: `<gameId>`

**Steps**:
1. Create a new request in Postman.
2. Set the request type to `GET`.
3. Enter the URL: `http://localhost:8080/game/gameState`.
4. Go to the `Params` tab and add the following key-value pair:
   - `gameId`: Use the same game ID.
5. Click `Send`.
6. You should receive a response with the current game state.

**Example Response**:
```json
{
  "gameId": "c4d8e5b7-7e85-4b3a-8055-3c4f6f3d4f32",
  "players": ["Player1"]
}
```

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgements

- Spring Boot Documentation
- Postman Documentation

---

This README provides an overview of the project, setup instructions, API documentation, and detailed steps for testing the APIs using Postman.
