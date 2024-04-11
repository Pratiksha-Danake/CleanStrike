package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.service.exception.InvalidCarromCoinsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarromBoardServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);

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
}