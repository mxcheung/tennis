package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public abstract class TennisTst {

    protected static final String PLAYER_1 = "player 1";
    protected static final String PLAYER_2 = "player 2";
    protected static final String DEUCE = "Deuce";
    protected static final int TIEBREAKER_GAMES_W0N = 6;
    
    protected TennisMatch tennisMatch;
    protected Player player1;
    protected Player player2;
    protected TennisMatchService tennisMatchService;
    protected TennisProgressService tennisProgressService;
    protected TennisReportingService tennisReportingService;
    protected PlayerService playerService;

    public TennisTst() {
        super();
        setupMatch();
    }

    private void setupMatch() {
        tennisMatch = new TennisMatch(PLAYER_1, PLAYER_2);
        player1 = tennisMatch.getPlayer1();
        player2 = tennisMatch.getPlayer2();
        tennisMatchService = new TennisMatchServiceImpl();
        tennisProgressService = new TennisProgressServiceImpl();
        tennisReportingService = new TennisReportingServiceImpl();
        playerService = new PlayerServiceImpl();
     }
}