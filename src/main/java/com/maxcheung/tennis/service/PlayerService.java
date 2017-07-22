package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;

public interface PlayerService {
	Player pointWonBy(Player player);
	Player gameWonBy(Player player);
	Player gameLostBy(Player player);
}
