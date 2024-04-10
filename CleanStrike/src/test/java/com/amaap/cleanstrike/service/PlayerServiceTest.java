package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerServiceTest {
    @Test
    void shouldBeAbleToCreatePlayerWithGivenDetails() {
        // arrange
        InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
        PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
        PlayerService playerService = new PlayerService(playerRepository);
        int playerId = 1;
        int totalPoints = 0;
        Player expected = playerService.createPlayer(playerId, totalPoints);

        // act
        Player actual = playerService.createPlayer(playerId, totalPoints);

        // assert
        assertEquals(expected, actual);
        assertTrue(actual instanceof Player);
    }
}