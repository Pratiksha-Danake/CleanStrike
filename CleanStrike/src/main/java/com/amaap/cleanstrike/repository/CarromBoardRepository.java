package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;

public interface CarromBoardRepository {
    CarromBoard addCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException;

    CarromBoard getCarromBoardById(int carromBoardId);
}
