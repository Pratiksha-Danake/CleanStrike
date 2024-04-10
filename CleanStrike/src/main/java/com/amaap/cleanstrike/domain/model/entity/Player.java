package com.amaap.cleanstrike.domain.model.entity;

import java.util.Objects;

public class Player {
    private final int id;
    private final int totalPoints;

    private Player(int playerId, int totalPoints) {
        this.id = playerId;
        this.totalPoints = totalPoints;
    }

    public static Player create(int playerId, int totalPoints) {
        return new Player(playerId, totalPoints);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && totalPoints == player.totalPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPoints);
    }
}
