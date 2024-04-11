package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;

public interface InMemoryDatabase {
    Player insert(Player playerToAdd);

    Player getPlayer(int playerId);

    CarromBoard getCarromBoardById(int carromBoardId);

    CarromBoard insertCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException;
}
