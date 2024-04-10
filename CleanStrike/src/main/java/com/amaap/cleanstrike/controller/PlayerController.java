package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.service.exception.PlayerUnavailableException;

public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response createPlayer(int playerId, int totalPoints) {
        Player player = playerService.createPlayer(playerId, totalPoints);
        return new Response(HttpStatus.OK, "Added player");
    }

    public Player getPlayer(int playerId) throws PlayerUnavailableException {
        return playerService.getPlayer(playerId);
    }
}
