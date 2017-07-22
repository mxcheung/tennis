package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public class TennisProgressServiceImpl implements TennisProgressService {

	private final int TIEBREAKER_GAMES_W0N = 6;

	public Player getGameLeadPlayer(TennisMatch tennisMatch) {
		Player player1 = tennisMatch.getPlayer1();
		Player player2 = tennisMatch.getPlayer2();
		return (player1.getPoint() > player2.getPoint()) ? player1 : player2;
	}

	public Boolean isGameCompleted(TennisMatch tennisMatch) {
		Player leadPlayer = getGameLeadPlayer(tennisMatch);
		if (leadPlayer.getPoint() > 3) {
			if (Math.abs(tennisMatch.getPlayer2().getPoint() - tennisMatch.getPlayer1().getPoint()) >= 2) {
				return true;
			}
		}
		return false;
	}

	public Boolean isLoveAll(TennisMatch tennisMatch) {
		Player player1 = tennisMatch.getPlayer1();
		Player player2 = tennisMatch.getPlayer2();
		return ((player1.getPoint() == 0) && (player2.getPoint() == 0));
	}

	public Boolean isTieBreaker(TennisMatch tennisMatch) {
		return ((tennisMatch.getPlayer1().getGame() == TIEBREAKER_GAMES_W0N)
				&& (tennisMatch.getPlayer2().getGame() == TIEBREAKER_GAMES_W0N));
	}

}
