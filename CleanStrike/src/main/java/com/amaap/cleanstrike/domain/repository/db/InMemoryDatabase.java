package com.amaap.cleanstrike.domain.repository.db;

import com.amaap.cleanstrike.domain.model.entity.Player;

public interface InMemoryDatabase {
    Player insert(Player playerToAdd);

    Player getPlayer(int playerId);

}
