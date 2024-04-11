package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;

public class InMemoryCarromBoardRepository implements CarromBoardRepository {
    private final InMemoryDatabase inMemoryDatabase;

    public InMemoryCarromBoardRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public CarromBoard addCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException {
        return inMemoryDatabase.insertCarromBoard(noOfBlackCoins, noOfRedCoins);
    }

    @Override
    public CarromBoard getCarromBoardById(int carromBoardId) {
        return inMemoryDatabase.getCarromBoardById(carromBoardId);
    }
}

