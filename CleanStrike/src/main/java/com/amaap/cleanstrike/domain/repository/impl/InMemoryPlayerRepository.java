package com.amaap.cleanstrike.domain.repository.impl;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.repository.PlayerRepository;
import com.amaap.cleanstrike.domain.repository.db.InMemoryDatabase;

public class InMemoryPlayerRepository implements PlayerRepository {
    InMemoryDatabase inMemoryDatabase;

    public InMemoryPlayerRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Player addPlayer(Player playerToAdd) {
        return inMemoryDatabase.insert(playerToAdd);
    }
}
