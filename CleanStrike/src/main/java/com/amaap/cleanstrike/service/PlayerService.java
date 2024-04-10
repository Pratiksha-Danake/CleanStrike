package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(int playerId, int totalPoints) {
        Player playerToAdd = Player.create(playerId, totalPoints);
        return playerRepository.addPlayer(playerToAdd);
    }
}
