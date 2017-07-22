package com.maxcheung.tennis.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.maxcheung.tennis.model.TennisMatch;
import com.maxcheung.tennis.service.TennisMatchService;
import com.maxcheung.tennis.service.TennisMatchServiceImpl;

public class TennisMatchServiceTest extends TennisTst {

	private TennisMatchService tennisMatchService;

	@Before
	public void setup() {
		tennisMatch = new TennisMatch(PLAYER_1, PLAYER_2);
		player1 = tennisMatch.getPlayer1();
		player2 = tennisMatch.getPlayer2();
		tennisMatchService = new TennisMatchServiceImpl();
	}

	@Test
	public void shouldReturnPlayerByName() {
		assertEquals(player1, tennisMatchService.getPlayerByName(tennisMatch, PLAYER_1));
		assertEquals(player2, tennisMatchService.getPlayerByName(tennisMatch, PLAYER_2));
	}

	@Test
	public void shouldReturnOpponent() {
		assertEquals(player1, tennisMatchService.getPlayerByName(tennisMatch, PLAYER_1));
		assertEquals(player2, tennisMatchService.getOpponentPlayer(tennisMatch, player1));
	}

	@Test
	public void shouldAwardPoint() {
		player1.setPoint(1);
		player2.setPoint(0);
		tennisMatchService.awardPoint(tennisMatch, PLAYER_1);
		assertEquals(2, player1.getPoint());
	}

}
