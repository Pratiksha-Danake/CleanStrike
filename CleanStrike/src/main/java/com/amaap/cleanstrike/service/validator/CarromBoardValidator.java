package com.amaap.cleanstrike.service.validator;

public class CarromBoardValidator {
    public static boolean isValidCoins(int noOfBlackCoins, int noOfRedCoins) {
        if (noOfBlackCoins > 0 && noOfRedCoins>0)
            return true;
        return false;
    }
}
