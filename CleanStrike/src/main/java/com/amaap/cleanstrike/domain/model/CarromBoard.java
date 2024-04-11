package com.amaap.cleanstrike.domain.model;

import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.service.validator.CarromBoardValidator;

import java.util.Objects;

public class CarromBoard {
    private final int id;
    private final int blackCoins;
    private final int redCoins;
    private Player playerOne;
    private Player playerTwo;

    public CarromBoard(int id, int noOfBlackCoins, int noOfRedCoins) {
        this.id = id;
        this.blackCoins = noOfBlackCoins;
        this.redCoins = noOfRedCoins;
    }

    public static CarromBoard create(int id, int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException {
        if (!CarromBoardValidator.isValidCoins(noOfBlackCoins, noOfRedCoins))
            throw new InvalidCarromCoinsException("Insufficient coins");
        return new CarromBoard(id, noOfBlackCoins, noOfRedCoins);
    }

    public int getId() {
        return id;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarromBoard that = (CarromBoard) o;
        return blackCoins == that.blackCoins && redCoins == that.redCoins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blackCoins, redCoins);
    }
}
