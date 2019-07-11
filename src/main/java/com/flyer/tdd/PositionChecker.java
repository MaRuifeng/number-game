package com.flyer.tdd;

import com.flyer.tdd.entities.MatchCode;
import com.flyer.tdd.entities.MatchResult;
import com.flyer.tdd.interfaces.MatchChecker;

/**
 * Checks the input number array for numbers at correct positions.
 *
 * e.g. target [2, 3, 5, 1], input [2, 1, 4, 3], output {1, A}
 *
 * @author sg.ruifeng.ma
 * @since 2019-Jul-09
 */
public class PositionChecker implements MatchChecker {

    @Override
    public MatchResult check(int[] source, int[] target) {
        if (null == source || null == target) throw new IllegalArgumentException();
        int count = 0;
        for (int i=0; i<Math.min(source.length, target.length); i++) {
            if (source[i] == target[i]) count++;
        }
        return new MatchResult(MatchCode.POSITION, count);
    }
}
