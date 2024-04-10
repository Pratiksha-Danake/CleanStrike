package com.amaap.cleanstrike.domain.controller;

import com.amaap.cleanstrike.domain.controller.dto.Response;
import com.amaap.cleanstrike.domain.repository.PlayerRepository;
import com.amaap.cleanstrike.domain.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.domain.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.domain.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.domain.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Response expectedResponse = playerController.createPlayer(playerId, totalPoints);

        // act
        Response actualResponse = playerController.createPlayer(playerId, totalPoints);

        // assert
        assertEquals(expectedResponse, actualResponse);
    }
}