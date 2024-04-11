package com.amaap.cleanstrike.service.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarromBoardValidatorTest {
    @Test
    void shouldBeAbleToReturnTrueIfNumberOfCoinsPassedAreValid() {
        // arrange
        int noOfBlackCoins = 9;
        int noOfRedCoins = 1;

        // act && assert
        assertTrue(CarromBoardValidator.isValidCoins(noOfBlackCoins, noOfRedCoins));
    }

    @Test
    void shouldBeAbleToReturnFalseIfNumberOfCoinsPassedAreInvalid() {
        // arrange
        int noOfBlackCoins = 0;
        int noOfRedCoins = 0;

        // act && assert
        assertFalse(CarromBoardValidator.isValidCoins(noOfBlackCoins, noOfRedCoins));
    }
}