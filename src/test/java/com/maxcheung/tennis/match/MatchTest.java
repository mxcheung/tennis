package com.maxcheung.tennis.match;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

	private Match match;

	@Before
	public void setup() {
		match = new Match("player 1", "player 2");
	}

	@Test
	public void shouldReturnScore() {
		match = new Match("player 1", "player 2");

		assertEquals("0-0", match.getScore());
		match.pointWonBy("player 1");
		match.pointWonBy("player 2");
		// this will return "0-0, 15-15"
		assertEquals("0-0, 15-15", match.getScore());

		match.pointWonBy("player 1");
		match.pointWonBy("player 1");
		// this will return "0-0, 40-15"
		assertEquals("0-0, 40-15", match.getScore());

		match.pointWonBy("player 2");
		match.pointWonBy("player 2");
		// this will return "0-0, Deuce"
		assertEquals("0-0, Deuce", match.getScore());

		match.pointWonBy("player 1");
		// this will return "0-0, Advantage player 1"
		assertEquals("0-0, Advantage player 1", match.getScore());

		match.pointWonBy("player 1");
		assertEquals("1-0", match.getScore());

	}
}
