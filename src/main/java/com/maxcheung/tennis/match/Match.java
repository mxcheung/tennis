package com.maxcheung.tennis.match;

import com.maxcheung.tennis.model.TennisMatch;
import com.maxcheung.tennis.service.TennisMatchService;
import com.maxcheung.tennis.service.TennisReportingService;
import com.maxcheung.tennis.service.TennisReportingServiceImpl;

public class Match {

    private TennisMatch tennisMatch;
    private TennisMatchService tennisMatchService = new com.maxcheung.tennis.service.TennisMatchServiceImpl();
    private TennisReportingService tennisReportingService = new TennisReportingServiceImpl();

    public Match(String player1, String player2) {
        tennisMatch = new TennisMatch(player1, player2);
    }

    public void pointWonBy(String playerName) {
        tennisMatchService.awardPoint(tennisMatch, playerName);
    }

    public String getScore() {
        return tennisReportingService.reportMatchScore(tennisMatch);
    }

}