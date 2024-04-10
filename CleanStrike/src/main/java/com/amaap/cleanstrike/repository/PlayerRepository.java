package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.entity.Player;

public interface PlayerRepository {
    Player addPlayer(Player playerToAdd);
}
