package com.amaap.cleanstrike.repository.db.impl;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FakeInMemoryDatabaseTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(playerRepository);

    @Test
    void shouldBeAbleToAddPlayerIntoTheDatabase() {
        // arrange
        Player expected = playerService.createPlayer(1, 0);

        // act
        Player actual = inMemoryDatabase.insert(expected);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetPlayerFromDatabaseOfGivenId() {
        // arrange
        int playerId = 1;
        Player expectedPlayer = playerService.createPlayer(1, 0);

        // act
        Player actualPlayer = inMemoryDatabase.getPlayer(playerId);

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }
}