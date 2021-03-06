package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisReportingServiceTest extends TennisTst {

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
        assertEquals(DEUCE, tennisReportingService.reportCurrentGameScore(tennisMatch));
    }

    @Test
    public void shouldReportCurrentTiebreakGameScore() {
        player1.setGame(6);
        player2.setGame(6);
        player1.setPoint(4);
        player2.setPoint(4);
        assertEquals("4-4", tennisReportingService.reportCurrentGameScore(tennisMatch));
        player1.setPoint(6);
        player2.setPoint(6);
        assertEquals(DEUCE, tennisReportingService.reportCurrentGameScore(tennisMatch));
        player1.setPoint(6);
        player2.setPoint(4);
        assertEquals("6-4", tennisReportingService.reportCurrentGameScore(tennisMatch));
        player1.setPoint(4);
        player2.setPoint(6);
        assertEquals("4-6", tennisReportingService.reportCurrentGameScore(tennisMatch));
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
        assertEquals(DEUCE, tennisReportingService.reportCurrentGameScore(tennisMatch));
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
