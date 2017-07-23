package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TennisMatchServiceTest extends TennisTst {

    @Test
    public void shouldReturnPlayerByName() {
        assertEquals(player1, tennisMatchService.getPlayerByName(tennisMatch, PLAYER_1));
        assertEquals(player2, tennisMatchService.getPlayerByName(tennisMatch, PLAYER_2));
    }

    @Test
    public void shouldReturnOpponent() {
        assertEquals(player1, tennisMatchService.getPlayerByName(tennisMatch, PLAYER_1));
        assertEquals(player2, tennisMatchService.getOpponentPlayer(tennisMatch, player1));
        assertEquals(player1, tennisMatchService.getOpponentPlayer(tennisMatch, player2));
    }

    @Test
    public void shouldAwardPoint() {
        player1.setPoint(1);
        player2.setPoint(0);
        tennisMatchService.awardPoint(tennisMatch, PLAYER_1);
        assertEquals(2, player1.getPoint());
    }

}
