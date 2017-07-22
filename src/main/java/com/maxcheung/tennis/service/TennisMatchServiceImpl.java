package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public class TennisMatchServiceImpl implements TennisMatchService {

    private PlayerService playerService;
    private TennisProgressService tennisProgressService;

    public TennisMatchServiceImpl() {
        playerService = new PlayerServiceImpl();
        tennisProgressService = new TennisProgressServiceImpl();
    }

    public Player getPlayerByName(TennisMatch tennisMatch, String playerName) {
        Player player1 = tennisMatch.getPlayer1();
        Player player2 = tennisMatch.getPlayer2();
        return (player1.getName().equalsIgnoreCase(playerName)) ? player1 : player2;
    }

    public Player getOpponentPlayer(TennisMatch tennisMatch, Player player) {
        Player player1 = tennisMatch.getPlayer1();
        Player player2 = tennisMatch.getPlayer2();
        return (player.getName().equalsIgnoreCase(player1.getName())) ? player2 : player1;
    }

    public void awardPoint(TennisMatch tennisMatch, String playerName) {
        Player player = getPlayerByName(tennisMatch, playerName);
        playerService.pointWonBy(player);
        if (tennisProgressService.isGameCompleted(tennisMatch)) {
            Player opponent = getOpponentPlayer(tennisMatch, player);
            playerService.gameWonBy(player);
            playerService.gameLostBy(opponent);
        }

    }

}
