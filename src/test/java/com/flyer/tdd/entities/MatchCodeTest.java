package com.flyer.tdd.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchCodeTest {

    @Test
    public final void shouldReturnCorrectMatchCode() {
        assertEquals("A", MatchCode.POSITION.getCode());
        assertEquals("B", MatchCode.OCCURRENCE.getCode());
    }

}