package com.flyer.tdd;

import com.flyer.tdd.entities.MatchCode;
import com.flyer.tdd.entities.MatchResult;
import com.flyer.tdd.interfaces.MatchChecker;

import java.util.Arrays;

/**
 * Checks the input number array for matched number occurrences.
 *
 * e.g. target [2, 3, 5, 1], input [2, 1, 4, 3], output {3, B}
 *
 * @author sg.ruifeng.ma
 * @since 2019-Jul-09
 */

public class OccurrenceChecker implements MatchChecker {

    @Override
    public MatchResult check(int[] source, int[] target) {
        if (null == source || null == target) throw new IllegalArgumentException("Input arguments cannot be null!");
        int matchCount = Arrays.stream(source).reduce(0,
                (count, element) -> count + (int)Arrays.stream(target).distinct().filter(x -> x == element).count());
        return new MatchResult(MatchCode.OCCURRENCE, matchCount);
    }

}
