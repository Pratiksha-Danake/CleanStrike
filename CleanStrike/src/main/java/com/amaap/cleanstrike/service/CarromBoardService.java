package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.repository.CarromBoardRepository;

public class CarromBoardService {
    private final CarromBoardRepository carromBoardRepository;

    public CarromBoardService(CarromBoardRepository carromBoardRepository) {
        this.carromBoardRepository = carromBoardRepository;
    }

    public CarromBoard createCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException {
        return carromBoardRepository.addCarromBoard(noOfBlackCoins, noOfRedCoins);
    }

    public CarromBoard getCarromBoardById(int carromBoardId) {
        return carromBoardRepository.getCarromBoardById(carromBoardId);
    }

    public void addPlayersToCarromBoard(CarromBoard carromBoard, Player playerOne, Player playerTwo) {
        carromBoard.setPlayerOne(playerOne);
        carromBoard.setPlayerTwo(playerTwo);
    }
}
