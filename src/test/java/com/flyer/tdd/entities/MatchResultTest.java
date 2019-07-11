package com.flyer.tdd.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchResultTest {

    @Test
    public final void shouldReturnMatchResultInDesiredFormat() {
        MatchResult result = new MatchResult(MatchCode.OCCURRENCE, 3);
        assertEquals("3 B", result.print());
    }

    @Test(expected = IllegalArgumentException.class)
    public final void shouldThrowExceptionOnNegativeMatchCount() {
        new MatchResult(MatchCode.POSITION, -1);
    }
}