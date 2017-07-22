package com.maxcheung.tennis.match;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatchTest {

    private static final String PLAYER_1 = "player 1";
    private static final String PLAYER_2 = "player 2";
    private Match match;

    @Before
    public void setup() {
        match = new Match(PLAYER_1, PLAYER_2);
    }

    @Test
    public void shouldReturnScore() {
        match = new Match(PLAYER_1, PLAYER_2);

        assertEquals("0-0", match.getScore());
        match.pointWonBy(PLAYER_1);
        match.pointWonBy(PLAYER_2);
        // this will return "0-0, 15-15"
        assertEquals("0-0, 15-15", match.getScore());

        match.pointWonBy(PLAYER_1);
        match.pointWonBy(PLAYER_1);
        // this will return "0-0, 40-15"
        assertEquals("0-0, 40-15", match.getScore());

        match.pointWonBy(PLAYER_2);
        match.pointWonBy(PLAYER_2);
        // this will return "0-0, Deuce"
        assertEquals("0-0, Deuce", match.getScore());

        match.pointWonBy(PLAYER_1);
        // this will return "0-0, Advantage player 1"
        assertEquals("0-0, Advantage player 1", match.getScore());

        match.pointWonBy(PLAYER_1);
        assertEquals("1-0", match.getScore());

    }
}
