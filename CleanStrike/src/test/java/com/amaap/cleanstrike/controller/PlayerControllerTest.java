package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.PlayerService;
import com.amaap.cleanstrike.service.exception.PlayerUnavailableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    PlayerRepository playerRepository = new InMemoryPlayerRepository(inMemoryDatabase);
    PlayerService playerService = new PlayerService(playerRepository);
    PlayerController playerController = new PlayerController(playerService);

    @Test
    void shouldBeAbleToReturnResponseAsOKWhenCreatesPlayer() {
        // arrange
        int playerId = 1;
        int totalPoints = 0;
        Response expectedResponse = new Response(HttpStatus.OK, "Added player");

        // act
        Response actualResponse = playerController.createPlayer(playerId, totalPoints);

        // assert
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void shouldBeAbleToReturnPlayerFoundWithGivenId() throws PlayerUnavailableException {
        // arrange
        int playerId = 1;
        int totalPoints = 0;

        // act
        playerService.createPlayer(playerId, totalPoints);
        Player expected = playerController.getPlayer(1);
        Player actual = playerController.getPlayer(1);

        // assert
        assertEquals(expected, actual);
    }
}