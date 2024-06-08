package com.ludo.game;

import java.util.*;

public class Player {
    private String name;
    private List<Piece> pieces;

    public Player(String name) {
        this.name = name;
        this.pieces = new ArrayList<>(Arrays.asList(new Piece(1), new Piece(2), new Piece(3), new Piece(4)));
    }

    public String getName() {
        return name;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
