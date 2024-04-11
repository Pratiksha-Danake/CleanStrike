package com.amaap.cleanstrike.repository.db.impl;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;
import com.amaap.cleanstrike.domain.model.exception.InvalidCarromCoinsException;
import com.amaap.cleanstrike.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<Player> players = new ArrayList<>();
    List<CarromBoard> carromBoards = new ArrayList<>();
    int carromBoardId = 0;

    @Override
    public Player insert(Player player) {
        players.add(player);
        return player;
    }

    @Override
    public Player getPlayer(int playerId) {
        for (Player player : players) {
            if (player.getId() == playerId)
                return player;
        }
        return null;
    }

    @Override
    public CarromBoard insertCarromBoard(int noOfBlackCoins, int noOfRedCoins) throws InvalidCarromCoinsException {
        carromBoardId++;
        CarromBoard carromBoard = CarromBoard.create(carromBoardId, noOfBlackCoins, noOfRedCoins);
        carromBoards.add(carromBoard);
        return carromBoard;
    }

    @Override
    public CarromBoard getCarromBoardById(int carromBoardId) {
        for (CarromBoard carrom : carromBoards)
            if (carrom.getId() == carromBoardId)
                return carrom;
        return null;
    }
}
