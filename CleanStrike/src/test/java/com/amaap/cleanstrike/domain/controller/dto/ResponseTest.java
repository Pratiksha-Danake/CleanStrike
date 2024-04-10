package com.amaap.cleanstrike.domain.controller.dto;

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
        assertTrue(response1.equals(response1));
        assertFalse(response1.equals(null));
        assertFalse(response1.equals(obj));
        assertFalse(response1.equals(response3));
        assertTrue(response1.equals(response2));
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