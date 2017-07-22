package com.maxcheung.tennis.service;

import com.maxcheung.tennis.model.Player;

public class PlayerServiceImpl implements PlayerService {

	public Player pointWonBy(Player player) {
		player.setPoint(player.getPoint() + 1);
		return player;
	}

	public Player gameWonBy(Player player) {
		player.setGame(player.getGame() + 1);
		player.setPoint(0);
		return player;
	}

	public Player gameLostBy(Player player) {
		player.setPoint(0);
		return player;
	}

}
