package com.maxcheung.tennis.service;

import java.util.Arrays;
import java.util.List;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public class TennisReportingServiceImpl implements TennisReportingService {


    public static final List<String> pointsDescription = Arrays.asList("love", "15", "30", "40");

    private static final String ADVANTAGE = "Advantage";
    
    private static final String DEUCE = "Deuce";

    private TennisProgressService tennisProgressService;

    public TennisReportingServiceImpl() {
        tennisProgressService = new TennisProgressServiceImpl();
    }

    @Override
    public String reportCurrentGameScore(TennisMatch tennisMatch) {
        Boolean tiebreaker = tennisProgressService.isTieBreaker(tennisMatch);
        return (tiebreaker) ? tieBreakGameDescription(tennisMatch) : standardGameDescription(tennisMatch);
    }

    @Override
    public String reportCurrentSetScore(TennisMatch tennisMatch) {
        return tennisMatch.getPlayer1().getGame() + "-" + tennisMatch.getPlayer2().getGame();
    }

    @Override
    public String reportMatchScore(TennisMatch tennisMatch) {
        String gameScore = reportCurrentSetScore(tennisMatch);
        if (tennisProgressService.isLoveAll(tennisMatch)) {
            return gameScore;
        }
        return gameScore + ", " + reportCurrentGameScore(tennisMatch);
    }

    private Player getLeadPlayer(TennisMatch tennisMatch) {
        return tennisProgressService.getGameLeadPlayer(tennisMatch);
    }

    private String getScoreDescription(int score) {
        return pointsDescription.get(score);
    }

    private String standardGameDescription(TennisMatch tennisMatch) {
        Player player1 = tennisMatch.getPlayer1();
        Player player2 = tennisMatch.getPlayer2();

        if (player1.getPoint() >= 3 && player2.getPoint() >= 3) {
            return deuceOrAdvantage(tennisMatch, player1, player2);
        } else {
            return getScoreDescription(player1.getPoint()) + "-" + getScoreDescription(player2.getPoint());
        }
    }

    private String tieBreakGameDescription(TennisMatch tennisMatch) {
        Player player1 = tennisMatch.getPlayer1();
        Player player2 = tennisMatch.getPlayer2();

        if (player1.getPoint() >= 6 && player2.getPoint() >= 6) {
            return deuceOrAdvantage(tennisMatch, player1, player2);
        } else {
            return player1.getPoint() + "-" + player2.getPoint();
        }
    }

    private String deuceOrAdvantage(TennisMatch tennisMatch, Player player1, Player player2) {
        if (player1.getPoint() == player2.getPoint()) {
            return DEUCE;
        } else {
            return ADVANTAGE + " " + getLeadPlayer(tennisMatch).getName();
        }
    }

}
