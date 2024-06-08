package com.ludo.game;

import java.util.*;

public class Game {
    private String gameId;
    private List<Player> players;
    private String currentPlayer;
    private Random random;

    public Game(String gameId) {
        this.gameId = gameId;
        this.players = new ArrayList<>();
        this.random = new Random();
    }

    public String addPlayer(Player player) {
        if (players.size() < 4) {
            players.add(player);
            if (players.size() == 1) {
                currentPlayer = player.getName();
            }
            return "Player added";
        }
        return "Game is full";
    }

    public String rollDice(String playerName) {
        if (!currentPlayer.equals(playerName)) {
            return "Not your turn";
        }
        int diceValue = random.nextInt(6) + 1;
        return "Dice rolled: " + diceValue;
    }

    public String movePiece(String playerName, int pieceId, int steps) {
        if (!currentPlayer.equals(playerName)) {
            return "Not your turn";
        }
        Player player = players.stream().filter(p -> p.getName().equals(playerName)).findFirst().orElse(null);
        if (player == null) {
            return "Player not found";
        }
        Piece piece = player.getPieces().stream().filter(p -> p.getId() == pieceId).findFirst().orElse(null);
        if (piece == null) {
            return "Piece not found";
        }
        piece.setPosition(piece.getPosition() + steps);
        currentPlayer = players.get((players.indexOf(player) + 1) % players.size()).getName();
        return "Piece moved";
    }

    public String getGameId() {
        return gameId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
