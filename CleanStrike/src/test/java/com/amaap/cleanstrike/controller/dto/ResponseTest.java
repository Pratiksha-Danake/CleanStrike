package com.amaap.cleanstrike.controller.dto;

import com.amaap.cleanstrike.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {
    @Test
    void shouldBeAbleToCheckEqualityOfSameResponseInstances() {
        // arrange
        Response response1 = new Response(HttpStatus.OK, "Added");
        Response response2 = new Response(HttpStatus.OK, "Added");
        Response response3 = new Response(HttpStatus.BAD_REQUEST, "Not Added");
        Object obj = new Object();

        // act && assert
        assertEquals(response1, response1);
        assertNotEquals(null, response1);
        assertNotEquals(response1, obj);
        assertNotEquals(response1, response3);
        assertEquals(response1, response2);
    }

    @Test
    void shouldBeAbleToReturnSameHashCodeForSameInstances() {
        // arrange
        Response response1 = new Response(HttpStatus.OK, "Added");
        Response response2 = new Response(HttpStatus.OK, "Added");

        // act && assert
        assertEquals(response1.hashCode(), response2.hashCode());
    }
}