package com.amaap.cleanstrike.domain.model;

import java.util.Objects;

public class CarromBoard {
    private int blackCoins;
    private int redCoins;

    public CarromBoard(int noOfBlackCoins, int noOfRedCoins) {
        this.blackCoins = noOfBlackCoins;
        this.redCoins = noOfRedCoins;
    }

    public static CarromBoard create(int noOfBlackCoins, int noOfRedCoins) {
        return new CarromBoard(noOfBlackCoins, noOfRedCoins);
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
