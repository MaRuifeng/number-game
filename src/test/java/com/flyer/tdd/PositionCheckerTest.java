package com.flyer.tdd;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PositionCheckerTest {

    private PositionChecker checker = new PositionChecker();

    @Test
    public void shouldReturnSinglePositionMatchResult() {
        int[] source = {1, 2, 4};
        int[] target = {4, 2, 1};

        assertEquals("1 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnMultiplePositionMatchResult() {
        int[] source = {1, 2, 4};
        int[] target = {1, 2, 3};

        assertEquals("2 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnFullPositionMatchResult() {
        int[] source = {1, 2, 4};
        int[] target = {1, 2, 4};

        assertEquals("3 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnFullPositionMatchResultWithSmallerSource() {
        int[] source = {1, 1, 1};
        int[] target = {1, 1, 1, 5, 9};

        assertEquals("3 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnFullPositionMatchResultWithSmallerTarget() {
        int[] source = {1, 2, 4, 5, 8};
        int[] target = {1, 4};

        assertEquals("1 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnZeroPositionMatchResult() {
        int[] source = {1, 2, 4, 5, 8};
        int[] target = {0, 9, 7};

        assertEquals("0 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnZeroPositionMatchResultWhenSourceIsEmpty() {
        int[] source = {};
        int[] target = {0, 9, 7};

        assertEquals("0 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnZeroPositionMatchResultWhenTargetIsEmpty() {
        int[] source = {1, 2, 4, 5, 8};
        int[] target = {};

        assertEquals("0 A", checker.check(source, target).print());
    }

    @Test
    public void shouldReturnZeroPositionMatchResultWhenBothSourceAndTargetAreEmpty() {
        int[] source = {};
        int[] target = {};

        assertEquals("0 A", checker.check(source, target).print());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSourceIsNull() {
        checker.check(null, new int[]{1, 2});
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTargetIsNull() {
        checker.check(new int[]{1, 2}, null);
    }

}