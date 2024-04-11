package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.service.CarromBoardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryCarromBoardRepositoryTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);

    @Test
    void shouldBeAbleToAddCreatedCarromBoardToDatabase() throws InvalidCarromCoinsException {
        // arrange
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;
        CarromBoard expected = carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // act
        CarromBoard actual = carromBoardRepository.addCarromBoard(noOfBlackCoins, noOfRedCoins);

        // assert
        assertEquals(expected, actual);
    }
}