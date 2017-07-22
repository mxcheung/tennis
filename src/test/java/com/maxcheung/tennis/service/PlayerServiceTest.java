package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.service.PlayerService;
import com.maxcheung.tennis.service.PlayerServiceImpl;

public class PlayerServiceTest {

	private PlayerService playerService;
	private Player player;

	@Before
	public void setup() {
		playerService = new PlayerServiceImpl();
		player = new Player("player 1");
	}

	@Test
	public void shouldReturnAwardPoint() {
		assertEquals(0, player.getPoint());
		playerService.pointWonBy(player);
		assertEquals(1, player.getPoint());
	}

	@Test
	public void shouldReturnIncreaseGame() {
		assertEquals(0, player.getGame());
		playerService.gameWonBy(player);
		assertEquals(1, player.getGame());
	}

}
