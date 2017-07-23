package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.maxcheung.tennis.model.Player;

public class PlayerServiceTest extends TennisTst {

    private Player player;

    @Before
    public void setup() {
        player = new Player("player 1");
    }

    @Test
    public void shouldAwardPoint() {
        assertEquals(0, player.getPoint());
        playerService.pointWonBy(player);
        assertEquals(1, player.getPoint());
    }

    @Test
    public void shouldAwardGame() {
        assertEquals(0, player.getGame());
        playerService.gameWonBy(player);
        assertEquals(1, player.getGame());
        assertEquals(0, player.getPoint());
    }

    @Test
    public void shouldResetPoints() {
        assertEquals(0, player.getGame());
        playerService.gameLostBy(player);
        assertEquals(0, player.getGame());
        assertEquals(0, player.getPoint());
    }

}
