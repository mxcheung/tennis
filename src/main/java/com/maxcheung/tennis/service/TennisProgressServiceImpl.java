package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public class TennisProgressServiceImpl implements TennisProgressService {

    private static final int TIEBREAKER_GAMES_REQUIRED = 6;
    private static final int STANDARD_POINTS_REQUIRED = 4;
    private static final int TIMEBREAK_POINTS_REQUIRED = 7;

    @Override
    public Player getGameLeadPlayer(TennisMatch tennisMatch) {
        Player player1 = tennisMatch.getPlayer1();
        Player player2 = tennisMatch.getPlayer2();
        return (player1.getPoint() > player2.getPoint()) ? player1 : player2;
    }

    @Override
    public Boolean isGameCompleted(TennisMatch tennisMatch) {
        Player leadPlayer = getGameLeadPlayer(tennisMatch);
        int pointsRequired = getMininumGamePoints(tennisMatch);
        if ((leadPlayer.getPoint() >= pointsRequired) && playerLeadsOutright(tennisMatch)) {
            return true;
        }
        return false;
    }

    private int getMininumGamePoints(TennisMatch tennisMatch) {
        return (isTieBreaker(tennisMatch)) ? TIMEBREAK_POINTS_REQUIRED : STANDARD_POINTS_REQUIRED;
    }

    @Override
    public Boolean isLoveAll(TennisMatch tennisMatch) {
        Player player1 = tennisMatch.getPlayer1();
        Player player2 = tennisMatch.getPlayer2();
        return (player1.getPoint() == 0) && (player2.getPoint() == 0);
    }

    @Override
    public Boolean isTieBreaker(TennisMatch tennisMatch) {
        return (tennisMatch.getPlayer1().getGame() == TIEBREAKER_GAMES_REQUIRED)
                && (tennisMatch.getPlayer2().getGame() == TIEBREAKER_GAMES_REQUIRED);
    }

    private boolean playerLeadsOutright(TennisMatch tennisMatch) {
        return Math.abs(tennisMatch.getPlayer2().getPoint() - tennisMatch.getPlayer1().getPoint()) >= 2;
    }
}
