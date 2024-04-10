package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryPlayerRepositoryTest {
    @Test
    void shouldBeAbleToAddPlayerDataIntoTheDatabase() {
        // arrange
        InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
        PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
        PlayerService playerService = new PlayerService(playerRepository);
        Player expected = playerService.createPlayer(1, 0);
        int playerId = 1;
        int totalPoints = 0;

        // act
        Player actual = playerService.createPlayer(playerId, totalPoints);

        // assert
        assertEquals(expected, actual);
    }
}