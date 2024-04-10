package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.entity.Player;

public interface InMemoryDatabase {
    Player insert(Player playerToAdd);
}
