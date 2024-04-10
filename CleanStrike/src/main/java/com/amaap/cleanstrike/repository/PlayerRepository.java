package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.Player;

public interface PlayerRepository {
    Player addPlayer(Player playerToAdd);

    Player getPlayer(int playerId);
}
