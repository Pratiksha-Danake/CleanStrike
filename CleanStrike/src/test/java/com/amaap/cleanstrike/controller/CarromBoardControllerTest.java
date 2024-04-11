package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import com.amaap.cleanstrike.service.CarromBoardService;
import com.amaap.cleanstrike.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarromBoardControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);
    CarromBoardController carromBoardController = new CarromBoardController(carromBoardService);
    PlayerService playerService = new PlayerService(new InMemoryPlayerRepository(new FakeInMemoryDatabase()));

    @Test
    void shouldBeAbleToReturnOkResponseIfCreatesCarromBoardWithGivenDetails() throws InvalidCarromCoinsException {
        // arrange
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;
        Response expected = new Response(HttpStatus.OK, "Added Carrom Board");

        // act
        Response actual = carromBoardController.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetCarromBoardById() throws InvalidCarromCoinsException {
        // arrange
        int carromBoardId = 1;
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;
        CarromBoard expected = carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // act
        CarromBoard actual = carromBoardController.getCarromBoardById(carromBoardId);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnResponseAsOkIfAddPlayersToCarromBoard() throws InvalidCarromCoinsException {
        // arrange
        Player playerOne = playerService.createPlayer(1, 0);
        Player playerTwo = playerService.createPlayer(2, 0);
        CarromBoard carromBoard = carromBoardService.createCarromBoard(9, 1);
        Response expected = new Response(HttpStatus.OK, "Players Added");

        // act
        Response actual = carromBoardController.addPlayersToCarromBoard(carromBoard, playerOne, playerTwo);

        // assert
        assertEquals(expected, actual);
    }
}
