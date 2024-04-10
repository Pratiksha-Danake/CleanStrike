package com.amaap.cleanstrike.domain.service;

import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.repository.PlayerRepository;
import com.amaap.cleanstrike.domain.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.domain.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.domain.service.exception.PlayerUnavailableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(playerRepository);

    @Test
    void shouldBeAbleToCreatePlayerWithGivenDetails() {
        // arrange
        int playerId = 1;
        int totalPoints = 0;
        Player expected = playerService.createPlayer(playerId, totalPoints);

        // act
        Player actual = playerService.createPlayer(playerId, totalPoints);

        // assert
        assertEquals(expected, actual);
        assertTrue(actual instanceof Player);
    }

    @Test
    void shouldBeAbleToGetPlayerFromDatabaseOfGivenId() throws PlayerUnavailableException {
        // arrange
        int playerId = 1;
        Player expectedPlayer = playerService.createPlayer(1, 0);

        // act
        Player actualPlayer = playerService.getPlayer(playerId);

        // assert
        assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    void shouldThrowPlayerNotFoundExceptionWhenThereIsNoPlayerToPlay(){
        // arrange
        int playerId = 2;

        // act && assert
        assertThrows(PlayerUnavailableException.class,()->playerService.getPlayer(playerId));
    }
}