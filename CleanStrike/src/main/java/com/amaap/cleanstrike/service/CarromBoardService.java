package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.repository.CarromBoardRepository;

public class CarromBoardService {
    private CarromBoardRepository carromBoardRepository;

    public CarromBoardService(CarromBoardRepository carromBoardRepository) {
        this.carromBoardRepository = carromBoardRepository;
    }

    public CarromBoard createCarromBoard(int noOfBlackCoins, int noOfRedCoins) {
        CarromBoard carromBoard=CarromBoard.create(noOfBlackCoins,noOfRedCoins);
        return carromBoardRepository.addCarromBoard(carromBoard);
    }
}
