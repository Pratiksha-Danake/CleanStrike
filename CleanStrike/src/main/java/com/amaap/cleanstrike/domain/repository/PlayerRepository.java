package com.amaap.cleanstrike.domain.repository;

import com.amaap.cleanstrike.domain.model.entity.Player;

public interface PlayerRepository {
    Player addPlayer(Player playerToAdd);
}
