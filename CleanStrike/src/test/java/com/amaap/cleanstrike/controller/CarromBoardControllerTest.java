package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;
import com.amaap.cleanstrike.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.cleanstrike.repository.impl.InMemoryCarromBoardRepository;
import com.amaap.cleanstrike.service.CarromBoardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarromBoardControllerTest {
    InMemoryDatabase inMemoryDatabase= new FakeInMemoryDatabase();
    CarromBoardRepository carromBoardRepository = new InMemoryCarromBoardRepository(inMemoryDatabase);
    CarromBoardService carromBoardService = new CarromBoardService(carromBoardRepository);
    CarromBoardController carromBoardController = new CarromBoardController(carromBoardService);

    @Test
    void shouldBeAbleToCreateCarromBoardWithGivenDetails() {
        // arrange
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;
        CarromBoard expected = carromBoardController.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // act
        CarromBoard actual = carromBoardController.createCarromBoard(noOfBlackCoins, noOfRedCoins);

        // assert
        assertEquals(expected,actual);
        assertTrue(actual instanceof CarromBoard);
    }
}
