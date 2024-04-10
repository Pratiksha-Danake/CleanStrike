package com.amaap.cleanstrike.domain.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void shouldBeAbleToCreatePlayerWithGivenDetails() {
        // arrange
        int playerId = 1;
        int totalPoints = 0;
        Player expected = Player.create(playerId, totalPoints);

        // act
        Player actual = Player.create(playerId, totalPoints);

        // assert
        assertEquals(expected, actual);
    }
}
