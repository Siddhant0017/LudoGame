package com.ludo.game;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {

    private Map<String, Game> games = new HashMap<>();

    @PostMapping("/createGame")
    public String createGame() {
        String gameId = String.valueOf(System.currentTimeMillis());
        games.put(gameId, new Game(gameId));
        return gameId;
    }

    @PostMapping("/joinGame")
    public String joinGame(@RequestParam String gameId, @RequestParam String playerName) {
        Game game = games.get(gameId);
        if (game == null) {
            return "Game not found";
        }
        return game.addPlayer(new Player(playerName));
    }

    @PostMapping("/rollDice")
    public String rollDice(@RequestParam String gameId, @RequestParam String playerName) {
        Game game = games.get(gameId);
        if (game == null) {
            return "Game not found";
        }
        return game.rollDice(playerName);
    }

    @PostMapping("/movePiece")
    public String movePiece(@RequestParam String gameId, @RequestParam String playerName, @RequestParam int pieceId, @RequestParam int steps) {
        Game game = games.get(gameId);
        if (game == null) {
            return "Game not found";
        }
        return game.movePiece(playerName, pieceId, steps);
    }

    @GetMapping("/gameState")
    public Game getGameState(@RequestParam String gameId) {
        return games.get(gameId);
    }
}



