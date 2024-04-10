package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.repository.PlayerRepository;
import com.amaap.cleanstrike.domain.service.exception.PlayerUnavailableException;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(int playerId, int totalPoints) {
        Player playerToAdd = Player.create(playerId, totalPoints);
        return playerRepository.addPlayer(playerToAdd);
    }

    public Player getPlayer(int playerId) throws PlayerUnavailableException {
        Player player = playerRepository.getPlayer(playerId);
        if (player == null)
            throw new PlayerUnavailableException("No active player found..!");
        return player;
    }
}
