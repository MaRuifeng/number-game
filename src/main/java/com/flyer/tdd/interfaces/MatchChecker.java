package com.flyer.tdd.interfaces;

import com.flyer.tdd.entities.MatchResult;

/**
 * Number match checker interface
 */

public interface MatchChecker {
    MatchResult check(int[] source, int[] target);
}
