package com.amaap.cleanstrike.repository.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.repository.CarromBoardRepository;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;

public class InMemoryCarromBoardRepository implements CarromBoardRepository {
    private InMemoryDatabase inMemoryDatabase;

    public InMemoryCarromBoardRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public CarromBoard addCarromBoard(CarromBoard carromBoard) {
        return inMemoryDatabase.insertCarromBoard(carromBoard);
    }
}

