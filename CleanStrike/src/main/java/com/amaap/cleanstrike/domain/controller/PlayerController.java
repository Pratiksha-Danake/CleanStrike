package com.amaap.cleanstrike.domain.controller;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.service.PlayerService;

public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Player createPlayer(int playerId, int totalPoints) {
        Player player = playerService.createPlayer(playerId, totalPoints);
        return player;
    }
}
