package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public interface TennisMatchService {

	Player getPlayerByName(TennisMatch tennisMatch, String playerName);

	Player getOpponentPlayer(TennisMatch tennisMatch, Player player);

	void awardPoint(TennisMatch tennisMatch, String playerName);

}
