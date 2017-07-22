package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public class TennisProgressServiceTest extends TennisTst {

    private static final int TIEBREAKER_GAMES_W0N = 6;

    private TennisProgressService tennisProgressService = new TennisProgressServiceImpl();

    @Before
    public void setup() {
        tennisMatch = new TennisMatch(PLAYER_1, PLAYER_2);
        player1 = tennisMatch.getPlayer1();
        player2 = tennisMatch.getPlayer2();
    }

    @Test
    public void shouldReturnGameLeadPlayer() {
        player1.setPoint(1);
        player2.setPoint(0);
        Player leadplayer = tennisProgressService.getGameLeadPlayer(tennisMatch);
        assertEquals(player1, leadplayer);
    }

    @Test
    public void shouldReturnGameCompleted() {
        player2.setPoint(0);
        player1.setPoint(3);
        assertFalse(tennisProgressService.isGameCompleted(tennisMatch));
        player1.setPoint(4);
        player1.setPoint(4);
        assertTrue(tennisProgressService.isGameCompleted(tennisMatch));
    }

    @Test
    public void shouldReturnLoveAll() {
        player1.setPoint(0);
        player2.setPoint(0);
        assertTrue(tennisProgressService.isLoveAll(tennisMatch));
    }

    @Test
    public void shouldReturnTieBreaker() {
        player1.setGame(TIEBREAKER_GAMES_W0N);
        player2.setGame(TIEBREAKER_GAMES_W0N);
        assertTrue(tennisProgressService.isTieBreaker(tennisMatch));
    }

}
