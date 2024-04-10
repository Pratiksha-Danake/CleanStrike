package com.amaap.cleanstrike.domain.controller;

import com.amaap.cleanstrike.domain.controller.PlayerController;
import com.amaap.cleanstrike.domain.model.entity.Player;
import com.amaap.cleanstrike.domain.repository.PlayerRepository;
import com.amaap.cleanstrike.domain.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.domain.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.domain.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerControllerTest {
    @Test
    void shouldBeAbleToCreatePlayerWithGivenDetails() {
        // arrange
        InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
        PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
        PlayerService playerService = new PlayerService(playerRepository);
        PlayerController playerController = new PlayerController(playerService);
        int playerId = 1;
        int totalPoints = 0;
        Player expected = playerController.createPlayer(playerId, totalPoints);

        // act
        Player actual = playerController.createPlayer(playerId, totalPoints);

        // assert
        assertEquals(expected, actual);
        assertTrue(actual instanceof Player);
    }
}