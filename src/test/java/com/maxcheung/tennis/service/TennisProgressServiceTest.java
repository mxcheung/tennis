package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.maxcheung.tennis.model.Player;

public class TennisProgressServiceTest extends TennisTst {

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
        player2.setPoint(4);
        assertFalse(tennisProgressService.isGameCompleted(tennisMatch));
        player1.setGame(6);
        player2.setGame(6);
        player1.setPoint(7);
        player2.setPoint(6);
        assertFalse(tennisProgressService.isGameCompleted(tennisMatch));
    }

    @Test
    public void shouldReturnLoveAll() {
        player1.setPoint(0);
        player2.setPoint(0);
        assertTrue(tennisProgressService.isLoveAll(tennisMatch));
        player1.setPoint(1);
        player2.setPoint(1);
        assertFalse(tennisProgressService.isLoveAll(tennisMatch));
        player1.setPoint(0);
        player2.setPoint(1);
        assertFalse(tennisProgressService.isLoveAll(tennisMatch));
        player1.setPoint(1);
        player2.setPoint(0);
        assertFalse(tennisProgressService.isLoveAll(tennisMatch));
    }

    @Test
    public void shouldReturnTieBreaker() {
        player1.setGame(0);
        player2.setGame(0);
        assertFalse(tennisProgressService.isTieBreaker(tennisMatch));
        player1.setGame(0);
        player2.setGame(TIEBREAKER_GAMES_W0N);
        assertFalse(tennisProgressService.isTieBreaker(tennisMatch));
        player1.setGame(TIEBREAKER_GAMES_W0N);
        player2.setGame(0);
        assertFalse(tennisProgressService.isTieBreaker(tennisMatch));
        player1.setGame(TIEBREAKER_GAMES_W0N);
        player2.setGame(TIEBREAKER_GAMES_W0N);
        assertTrue(tennisProgressService.isTieBreaker(tennisMatch));
    }

}
