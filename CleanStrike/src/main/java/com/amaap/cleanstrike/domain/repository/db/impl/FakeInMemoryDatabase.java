package com.amaap.cleanstrike.domain.repository.db.impl;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<Player> players = new ArrayList<>();

    @Override
    public Player insert(Player player) {
        players.add(player);
        return player;
    }
}
