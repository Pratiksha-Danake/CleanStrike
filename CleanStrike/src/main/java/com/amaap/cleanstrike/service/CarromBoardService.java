package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.service.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.service.validator.CarromBoardValidator;

public class CarromBoardService {
    private CarromBoardRepository carromBoardRepository;

    public CarromBoardService(CarromBoardRepository carromBoardRepository) {
        this.carromBoardRepository = carromBoardRepository;
    }

    public CarromBoard createCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException {
        if (CarromBoardValidator.isValidCoins(noOfBlackCoins, noOfRedCoins))
            return CarromBoard.create(noOfBlackCoins, noOfRedCoins);
        throw new InvalidCarromCoinsException("Insufficient carrom coins");
    }
}
