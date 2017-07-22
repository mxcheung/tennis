package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;
import com.maxcheung.tennis.model.TennisMatch;

public interface TennisProgressService {

	Player getGameLeadPlayer(TennisMatch tennisMatch);
	Boolean isGameCompleted(TennisMatch tennisMatch);
	Boolean isLoveAll(TennisMatch tennisMatch);
	Boolean isTieBreaker(TennisMatch tennisMatch);

}
