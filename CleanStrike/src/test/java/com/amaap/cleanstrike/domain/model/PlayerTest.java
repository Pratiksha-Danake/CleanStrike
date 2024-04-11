package com.amaap.cleanstrike.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @Test
    void shouldBeAbleToReturnSameHashCodeForSameInstances() {
        // arrange
        Player player1 = Player.create(1, 0);
        Player player2 = Player.create(1, 0);

        // act && assert
        assertEquals(player1.hashCode(), player2.hashCode());
    }

    @Test
    void shouldBeAbleToCheckEqualityOfTwoInstances() {
        // act
        Player player1 = Player.create(1, 100);
        Player player2 = Player.create(2, 100);
        Player player3 = Player.create(1, 200);
        Player player4 = Player.create(1, 100);

        // assert && assert
        assertEquals(player1, player1);
        assertNotEquals(null, player1);
        assertNotEquals(player1, new Object());
        assertNotEquals(player1, player2);
        assertNotEquals(player1, player3);
        assertEquals(player1, player4);
    }
}
