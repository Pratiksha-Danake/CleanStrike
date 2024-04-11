package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.repository.impl.InMemoryPlayerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarromBoardServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);
    PlayerService playerService = new PlayerService(new InMemoryPlayerRepository(new FakeInMemoryDatabase()));


    @Test
    void shouldBeAbleToCreateCarromBoardWithGivenDetails() throws InvalidCarromCoinsException {
        // arrange
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;
        CarromBoard expected = carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // act
        CarromBoard actual = carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowInvalidCarromCoinsExceptionIfCarromCoinsAreNotValidNumber() throws InvalidCarromCoinsException {
        // arrange
        int noOfBlackCoins = 0;
        int noOfRedCoins = 0;

        // act && assert
        assertThrows(InvalidCarromCoinsException.class, () -> {
            carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);
        });
    }

    @Test
    void shouldBeAbleToGetCarromBoardById() throws InvalidCarromCoinsException {
        // arrange
        int carromBoardId = 1;
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;
        CarromBoard expected = carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // act
        CarromBoard actual = carromBoardService.getCarromBoardById(carromBoardId);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToAddPlayersToCarromBoard() throws InvalidCarromCoinsException {
        // arrange
        Player playerOne = playerService.createPlayer(1, 0);
        Player playerTwo = playerService.createPlayer(2, 0);
        CarromBoard carromBoard = carromBoardService.createCarromBoard(9, 1);

        // act
        carromBoardService.addPlayersToCarromBoard(carromBoard,playerOne,playerTwo);

        // assert
        assertEquals(carromBoard.getPlayerOne(), playerOne);
        assertEquals(carromBoard.getPlayerTwo(), playerTwo);
    }
}