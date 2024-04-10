package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.service.CarromBoardService;

public class CarromBoardController {

    private CarromBoardService carromBoardService;

    public CarromBoardController(CarromBoardService carromBoardService) {
        this.carromBoardService = carromBoardService;
    }

    public CarromBoard createCarromBoard(int noOfBlackCoins, int noOfRedCoins) {
        return carromBoardService.createCarromBoard(noOfBlackCoins,noOfRedCoins);
    }
}
