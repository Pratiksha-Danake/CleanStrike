package com.amaap.cleanstrike.repository.db;

import com.amaap.cleanstrike.domain.model.CarromBoard;
import com.amaap.cleanstrike.domain.model.Player;

public interface InMemoryDatabase {
    Player insert(Player playerToAdd);

    Player getPlayer(int playerId);

    CarromBoard insertCarromBoard(CarromBoard carromBoard);

}
