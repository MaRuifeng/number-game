package com.flyer.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class OccurrenceCheckerTest {

    private OccurrenceChecker checker = new OccurrenceChecker();

    @Test
    public final void shouldReturnSingleOccurrenceCheckResult() {
        int[] source = {1, 2, 3};
        int[] target = {2, 4, 5};

        assertEquals("1 B", checker.check(source, target).print());
    }

    @Test
    public final void shouldReturnMultipleOccurrenceCheckResult() {
        int[] source = {1, 2, 3};
        int[] target = {2, 3, 1};

        assertEquals("3 B", checker.check(source, target).print());
    }

    @Test
    public final void shouldReturnZeroOccurrenceCheckResult() {
        int[] source = {1, 2, 3};
        int[] target = {4, 5};

        assertEquals("0 B", checker.check(source, target).print());
    }

    @Test
    public final void shouldReturnOccurrenceCheckResultWithDuplicatesInTargetIgnored() {
        int[] source = {1, 1, 1};
        int[] target = {1, 1, 1};

        assertEquals("3 B", checker.check(source, target).print());
    }

    @Test
    public final void shouldReturnZeroOccurrenceCheckResultWhenTargetIsEmpty() {
        int[] source = {1, 2, 3};
        int[] target = {};

        assertEquals("0 B", checker.check(source, target).print());
    }

    @Test
    public final void shouldReturnZeroOccurrenceCheckResultWhenSourceIsEmpty() {
        int[] source = {};
        int[] target = {5, 6, 7};

        assertEquals("0 B", checker.check(source, target).print());
    }

    @Test
    public final void shouldReturnZeroOccurrenceCheckResultWhenBothSourceAndTargetAreEmpty() {
        int[] source = {};
        int[] target = {};

        assertEquals("0 B", checker.check(source, target).print());
    }

    @Test(expected = IllegalArgumentException.class)
    public final void shouldThrowExceptionWhenSourceIsNull() {
        checker.check(null, new int[]{1, 2, 3});
    }

    @Test(expected = IllegalArgumentException.class)
    public final void shouldThrowExceptionWhenTargetIsNull() {
        checker.check(new int[]{1, 2, 3}, null);
    }
}