package com.flyer.tdd;

import com.flyer.tdd.entities.MatchCode;
import com.flyer.tdd.entities.MatchResult;
import com.flyer.tdd.interfaces.MatchChecker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberCheckerTest {

    private static List<MatchChecker> checkerList;

    private NumberChecker checker = new NumberChecker(checkerList);

    @BeforeClass
    public static void setUpBeforeClass() {
        checkerList = new ArrayList<>();
        checkerList.add(new PositionChecker());
        checkerList.add(new OccurrenceChecker());
    }

    @Test
    public final void shouldInvokeAllSubCheckersAndRenderMatchResults() {
        int[] source = {1, 3, 5, 2, 4};
        int[] target = {1, 5, 3, 4};

        List<MatchResult> resList = checker.check(source, target);

        List<String> expected = new ArrayList<>();
        expected.add(new MatchResult(MatchCode.POSITION, 1).print());
        expected.add(new MatchResult(MatchCode.OCCURRENCE, 4).print());

        List<String> actual = resList.stream().map(MatchResult::print).collect(Collectors.toList());
        Assert.assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }


    @Test
    public final void shouldRendMatchResultsAsString() {
        int[] source = {1, 4, 6, 8};
        int[] target = {1, 4, 7, 8};

        checker.check(source, target);

        Assert.assertEquals("3 A 3 B", checker.printResult());
    }

    @Test
    public final void shouldRenderEmptyStringWhenNoMatchResults() {
        Assert.assertEquals("", checker.printResult());
    }



}