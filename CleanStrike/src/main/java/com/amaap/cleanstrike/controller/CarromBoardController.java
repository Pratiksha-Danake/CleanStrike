package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.HttpStatus;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.service.CarromBoardService;
import com.amaap.cleanstrike.service.exception.InvalidCarromCoinsException;

public class CarromBoardController {

    private CarromBoardService carromBoardService;

    public CarromBoardController(CarromBoardService carromBoardService) {
        this.carromBoardService = carromBoardService;
    }

    public Response createCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException {
        Response response;
        try {
            carromBoardService.createCarromBoard(noOfBlackCoins, noOfRedCoins);
            response = new Response(HttpStatus.OK, "Added Carrom Board");
        } catch (InvalidCarromCoinsException exception) {
            response = new Response(HttpStatus.BAD_REQUEST, "cannot create carrom board");
        }
        return response;
    }
}
