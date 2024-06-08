package com.ludo.game;

public class Piece {
    private int id;
    private int position; // -1 indicates the piece is at home

    public Piece(int id) {
        this.id = id;
        this.position = -1;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
