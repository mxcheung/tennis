package com.maxcheung.tennis.model;

public class TennisMatch {

    private Player player1;
    private Player player2;

    public TennisMatch(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

}