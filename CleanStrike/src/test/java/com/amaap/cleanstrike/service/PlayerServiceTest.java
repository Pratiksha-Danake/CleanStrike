package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.exception.PlayerUnavailableException;
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