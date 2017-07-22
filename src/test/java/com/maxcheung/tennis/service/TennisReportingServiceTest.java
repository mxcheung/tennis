package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.maxcheung.tennis.model.TennisMatch;
import com.maxcheung.tennis.service.TennisReportingService;
import com.maxcheung.tennis.service.TennisReportingServiceImpl;

public class TennisReportingServiceTest extends TennisTst {

    private TennisReportingService tennisReportingService;

    @Before
    public void setup() {
        tennisMatch = new TennisMatch(PLAYER_1, PLAYER_2);
        player1 = tennisMatch.getPlayer1();
        player2 = tennisMatch.getPlayer2();
        tennisReportingService = new TennisReportingServiceImpl();
    }

    @Test
    public void shouldReportCurrentGameScoreFifeenAll() {
        player1.setPoint(1);
        player2.setPoint(1);
        assertEquals("15-15", tennisReportingService.reportCurrentGameScore(tennisMatch));
    }

    @Test
    public void shouldReportCurrentGameDeuce() {
        player1.setPoint(4);
        player2.setPoint(4);
        assertEquals("Deuce", tennisReportingService.reportCurrentGameScore(tennisMatch));
    }

    @Test
    public void shouldReportCurrentTiebreakGameScoreFourAll() {
        player1.setGame(6);
        player2.setGame(6);
        player1.setPoint(4);
        player2.setPoint(4);
        assertEquals("4-4", tennisReportingService.reportCurrentGameScore(tennisMatch));
    }

    @Test
    public void shouldReportCurrentTiebreakGameScoreOneAll() {
        player1.setGame(6);
        player2.setGame(6);
        player1.setPoint(1);
        player2.setPoint(1);
        assertEquals("1-1", tennisReportingService.reportCurrentGameScore(tennisMatch));
    }

    @Test
    public void shouldReportCurrentTiebreakGameDeuce() {
        player1.setGame(6);
        player2.setGame(6);
        player1.setPoint(8);
        player2.setPoint(8);
        assertEquals("Deuce", tennisReportingService.reportCurrentGameScore(tennisMatch));
    }

    @Test
    public void shouldReportCurrentSetScoreOneAll() {
        player1.setGame(1);
        player2.setGame(1);
        assertEquals("1-1", tennisReportingService.reportCurrentSetScore(tennisMatch));
    }

    @Test
    public void shouldReportMatchScoreOneAllFifeenAll() {
        player1.setGame(1);
        player1.setPoint(1);
        player2.setGame(1);
        player2.setPoint(1);
        assertEquals("1-1, 15-15", tennisReportingService.reportMatchScore(tennisMatch));
    }

}
